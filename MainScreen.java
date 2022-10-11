import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
* Creates the main screen that displays everything
* @author Mr. Lamont
*/
public class MainScreen extends JFrame implements ActionListener{

  // all the parts on the screen
  private PicturePanel picturePanel;
  private JButton north;
  private JButton east;
  private JButton west;
  private JButton south;
  private JTextField info;
  // the controller
  private Controller controller;


  /**
  * Constructor for the main screen
  */
  public MainScreen(){
    // create and add everything to the screen
    initializeComponents();
    this.controller = new Controller("pics.txt", this);
    
  }
  
  
  


  /**
  * Create and add all parts to the screen
  */
  private void initializeComponents(){
    // set the size of our JFrame
    this.setSize(800,600);

    // create the JPanel with a BoarderLayout
    JPanel mainPanel = new JPanel(new BorderLayout());
    // create another JPanel with a GridLayout to put 2 lines ontop of each other
    JPanel extraSpace = new JPanel(new GridLayout(2,1));
    

    // make the JTextArea for the extra info
    this.info = new JTextField();
    this.info.setEnabled(false);
    
    // create the different buttons
    this.north = new JButton("North");
    this.east = new JButton("East");
    this.west = new JButton("West");
    this.south = new JButton("South");
   
    // add the actionListeners
    this.north.addActionListener(this);
    this.east.addActionListener(this);
    this.south.addActionListener(this);
    this.west.addActionListener(this);
   
    // set action commands
    this.north.setActionCommand("north");
    this.east.setActionCommand("east");
    this.south.setActionCommand("south");
    this.west.setActionCommand("west");


    // create the picture panel
    this.picturePanel = new PicturePanel();
    
    // add the south and the info to the extra space to add to the bottom area
    extraSpace.add(this.south);
    extraSpace.add(this.info);

    // add all components in the correct spot
    mainPanel.add(this.east, BorderLayout.LINE_END);
    mainPanel.add(extraSpace, BorderLayout.PAGE_END);
    mainPanel.add(this.north, BorderLayout.PAGE_START);
    mainPanel.add(this.west, BorderLayout.LINE_START);
    mainPanel.add(this.picturePanel, BorderLayout.CENTER);

    // add panel to the frame
    this.add(mainPanel);
    // set the X in the corner to close things down
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // show the frame
    this.setVisible(true);
  }




  /** 
  * The method called when a button is pressed
  * @param e The actionEvent created from the button press
  */
  public void actionPerformed(ActionEvent e){
    // determine the action command
    String command = e.getActionCommand();
    // use a switch case to do the movement
    if(command.equals("north")){
      this.controller.moveUp();
    }else if(command.equals("east")){
      this.controller.moveRight();
    }if(command.equals("south")){
      this.controller.moveDown();
    }if(command.equals("west")){
      this.controller.moveLeft();
    }
    

  }





  public void setImage(BufferedImage image) {
    this.picturePanel.setImage(image);
  }

}
