
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamonta
 */
public class Scene {
   private BufferedImage picture;
   private int row;
   private int col;
   private boolean canMoveUp;
   private boolean canMoveRight;
   private boolean canMoveDown;
   private boolean canMoveLeft;
   private String description;

   public Scene(String imageName, boolean canMoveUp,boolean canMoveRight, boolean canMoveDown, boolean canMoveLeft, String description){
    this.canMoveUp = canMoveUp;
    this.canMoveRight = canMoveRight;
    this.canMoveDown = canMoveDown;
    this.canMoveLeft = canMoveLeft;
    this.description = description;
    // load the picture
    this.picture = null;
    try{
        // try to load picture from the images folder
        this.picture = ImageIO.read(new File("images/" + imageName));
    }catch(Exception e){
        // print out the error
        e.printStackTrace();
    }
    // split up the name to get row and col
    String[] data = imageName.split("-");
    // remove the .png part
    data[3] = data[3].replace(".png","");
    // convert the Strings to ints to store
    this.row = Integer.parseInt(data[1]);
    this.col = Integer.parseInt(data[3]);

   }

   public BufferedImage getImage(){
    return this.picture;
   }

   public int getRow(){
    return this.row;
   }

   public int getCol(){
    return this.col;
   }

   public boolean canMoveUp(){
    return this.canMoveUp;
   }

   public boolean canMoveRight(){
    return this.canMoveRight;
   }

   public boolean canMoveDown(){
    return this.canMoveDown;
   }

   public boolean canMoveLeft(){
    return this.canMoveLeft;
   }

   public String getDescription(){
    return this.description;
   }
    
    
}
