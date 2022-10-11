
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class Controller {
   private int currentRow;
   private int currentCol;
   private MainScreen theView;
   private Scene currentScene;
   private Scene[] map;

   public Controller(String filename, MainScreen view){
    this.theView = view;
    // read in from a file
    Scanner input = null;
    try{
        input = new Scanner(new File(filename));
    }catch(Exception e){
        // print the error
        e.printStackTrace();
    }
    // file is ready for reading
    int numRows = input.nextInt();
    // move down a row
    input.nextLine();
    int numCols = input.nextInt();
    // move down
    this.currentRow = input.nextInt();
    // move down
    this.currentCol = input.nextInt();
    // move down
    input.nextLine();
    // make the map storage
    this.map = new Scene[numRows*numCols];
    // loop through the rest of the data
    for(int i = 0; i < this.map.length; i++){
        String imageName = input.next();
        boolean up = input.nextBoolean();
        boolean right = input.nextBoolean();
        boolean down = input.nextBoolean();
        boolean left = input.nextBoolean();
        String description = input.nextLine();
        this.map[i] = new Scene(imageName, up, right, down, left, description);
    }

   }
    
}
