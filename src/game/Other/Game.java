package game.Other;

import game.ContolPanelActions.ControlPanel;
import game.GameLevels.GameWorld;
import game.GameLevels.Level1;
import game.GameLevels.Level2;
import game.GameLevels.Level3;
import game.Listeners.KeyBoard;

import javax.swing.*;
import java.awt.*;


/**
 * Your main game entry point
 */
public class Game {

    private static GameWorld level;
    private static GameView view;
    private static KeyBoard MainCharacterController;
    private Container container;
    private static JFrame frame = null;
    /** Initialise a new Game. */
    public Game() {


        level = new Level1();

        //3. make a view to look into the game level1
        view = new GameView(level, 750, 500, level.getMainCharacter());


        MainCharacterController = new KeyBoard(level.getMainCharacter(), level);
        view.addKeyListener(MainCharacterController);



        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        //   view to it
        frame = new JFrame("City Game");

        frame.add(view);

        frame.add(new ControlPanel(level, level.getMainCharacter(), "data/ImagesAndGifs/Save.txt"), BorderLayout.NORTH);

        frame.setLocationRelativeTo(null);



        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the level1 view
         frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(level, 500, 500);

        view.requestFocus();
        // start our game level1 simulation!
        level.start();
    }
    public static void setLevel(GameWorld Level){


    }

    public static void gotoNextLevel(){
        if (level instanceof Level1){
            level.stop();
            ((Level1) level).StopMusic();

            level = new Level2();
            level.createPlayer();

            view.setWorld(level);
            MainCharacterController.updateMainCharacter(level.getMainCharacter());
            level.start();
        } else if (level instanceof Level2) {
            level.stop();
            ((Level2) level).StopMusic();

            level = new Level3();
            level.createPlayer();

            view.setWorld(level);
            MainCharacterController.updateMainCharacter(level.getMainCharacter());
            level.start();
        } else if (level instanceof Level3) {
            level.stop();
          System.exit(2);
        }
    }




    public static GameWorld getLevel(){
        return level;
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
