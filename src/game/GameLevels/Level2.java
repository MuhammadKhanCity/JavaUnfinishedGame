package game.GameLevels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Obstacles.Bullets;
import game.Obstacles.GameAward;
import game.Obstacles.Portal;
import org.jbox2d.common.Vec2;
import game.Characters.GorrillaEnemy;
import game.Characters.JellyFishEnemy;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Level2 extends GameWorld{

    private SoundClip BackgroundMusic;

    public Level2(){
        super();
        setgroundcolor(Color.DARK_GRAY);
        Portal portal = new Portal(this, getMainCharacter(),new CircleShape(2));
        portal.setPosition(new Vec2(-20, -9));
        portal.addCollisionListener(portal);

        try {
            BackgroundMusic = new SoundClip("data/Sounds/Level2BackgroundMusic.wav");
            BackgroundMusic.play();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }


    }




    @Override
    public boolean isCompleted() {
        if (getMainCharacter().getCoinCount() == 1)
            return true;
        else return false;
    }
    public void StopMusic(){BackgroundMusic.stop();}
}

