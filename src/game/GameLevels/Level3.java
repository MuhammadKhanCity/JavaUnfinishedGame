package game.GameLevels;

import city.cs.engine.CircleShape;
import city.cs.engine.SoundClip;
import game.Obstacles.GameAward;
import game.Obstacles.Portal;
import game.Other.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Level3 extends GameWorld{
        private SoundClip BackgroundMusic;


    public Level3(){
        try {
            BackgroundMusic = new SoundClip("data/Sounds/Level3BackgroundMusic.wav");
            BackgroundMusic.play();

            Portal portal = new Portal(this, getMainCharacter(), new CircleShape(2));
            portal.setPosition(new Vec2(-20,-9));
            portal.addCollisionListener(portal);

            GameAward gameAward1 = new GameAward(this, getMainCharacter());
            gameAward1.setPosition(new Vec2(20, -9));

            GameAward gameAward2 = new GameAward(this, getMainCharacter());
            gameAward2.setPosition(new Vec2(5,0));
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){}

    }



    @Override
    public boolean isCompleted() {
        if (getMainCharacter().getCoinCount() == 3)
            return true;
        return false;
    }
}
