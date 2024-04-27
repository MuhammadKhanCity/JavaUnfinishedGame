package game.Listeners;

import city.cs.engine.World;
import game.Characters.MainCharacter;
import javax.swing.Timer;

import game.GameLevels.Level1;
import game.GameLevels.Level2;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyBoard implements KeyListener {
    private static final float WALKING_SPEED = 3;
    private MainCharacter mainCharacter;
    private  final World world;
    private Timer timer;




   public KeyBoard(MainCharacter mainCharacter, World world){
       this.mainCharacter = mainCharacter;
       this.world = world;
       timer = new Timer(2000, mainCharacter);
   }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        char KeyChar = e.getKeyChar();
        if (code == KeyEvent.VK_LEFT) {
            mainCharacter.startWalking(-WALKING_SPEED*2);
            mainCharacter.setDirectionofaCharacter(false);

        } else if (code == KeyEvent.VK_RIGHT) {
            mainCharacter.startWalking(WALKING_SPEED*2);
            mainCharacter.setDirectionofaCharacter(true);

        }
        else if (code == KeyEvent.VK_UP){
            mainCharacter.jump(20);
        } else if (KeyChar == 's') {
                timer.setInitialDelay(200);
                timer.start();
                timer.setRepeats(false);
                mainCharacter.setWorldBullets(world);


        } else if (code == KeyEvent.VK_L) {
            System.out.println("Loading game");
        } else if (code == KeyEvent.VK_K) {
            System.out.println("Saving game");
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            mainCharacter.stopWalking();
            mainCharacter.setLinearVelocity(new Vec2(0,0));
        } else if (code == KeyEvent.VK_RIGHT) {
            mainCharacter.stopWalking();
            mainCharacter.setLinearVelocity(new Vec2(0,0));
            mainCharacter.applyForce(new Vec2(6,10));
        }

    }
    public void updateMainCharacter(MainCharacter mainCharacter){
       this.mainCharacter = mainCharacter;
    }
}
