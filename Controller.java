
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
    input.nextLine();
    this.currentRow = input.nextInt();
    // move down
    input.nextLine();
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

    // find the current scene
    this.currentScene = this.findScene(this.currentRow, this.currentCol);
    //set the corrent picture
    this.theView.setImage(this.currentScene.getImage());

   }

private Scene findScene(int row, int col) {
    for (int i = 0; i < this.map.length; i++) {
        // grab the scene row and col
        int sceneRow = this.map[i].getRow();
        int sceneCol = this.map[i].getCol();
        // did we find the scene?
        if(sceneRow == row && sceneCol == col){
            return this.map[i];
        }
    }
    // didn't find the scene
    return null;
}

public void moveUp(){
    // can we move up?
    if(this.currentScene.canMoveUp()){
        // move up
        this.currentRow--;
        // find new scene
        this.currentScene = findScene(this.currentRow, this.currentCol);
        // update picture
        this.theView.setImage(this.currentScene.getImage());
    }
}

public void moveRight(){
    // can we move right?
    if(this.currentScene.canMoveRight()){
        // move right
        this.currentCol++;
        // find new scene
        this.currentScene = findScene(this.currentRow, this.currentCol);
        // update picture
        this.theView.setImage(this.currentScene.getImage());
    }
}

public void moveLeft(){
    // can we move left?
    if(this.currentScene.canMoveLeft()){
        // move left
        this.currentCol--;
        // find new scene
        this.currentScene = findScene(this.currentRow, this.currentCol);
        // update picture
        this.theView.setImage(this.currentScene.getImage());
    }
}

public void moveDown(){
    // can we move down?
    if(this.currentScene.canMoveDown()){
        // move down
        this.currentRow++;
        // find new scene
        this.currentScene = findScene(this.currentRow, this.currentCol);
        // update picture
        this.theView.setImage(this.currentScene.getImage());
    }
}


    
}
