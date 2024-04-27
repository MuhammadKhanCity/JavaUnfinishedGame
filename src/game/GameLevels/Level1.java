package game.GameLevels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Characters.GorrillaEnemy;
import game.Obstacles.GameAward;
import game.Obstacles.Platform;
import org.jbox2d.common.Vec2;
import game.Obstacles.Portal;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Level1 extends GameWorld{
    private SoundClip BackgroundMusic;


    public Level1(){

        super();
        setgroundcolor(new Color(92, 64, 51));



        try {
            BackgroundMusic = new SoundClip("data/Sounds/Hitman(chosic.com).wav");
            BackgroundMusic.play();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }


        Shape platformShapeNormal = new BoxShape(3, 0.5f);
        Shape platfromShapeBigMiddle = new BoxShape(10, 0.5f);
        Shape SmallPlatformshape = new BoxShape(1.5f,0.5f);
        Shape PlaneCrashShape = new BoxShape(15,30);

        StaticBody PLaneCrash = new StaticBody(this, PlaneCrashShape);
        PLaneCrash.setPosition(new Vec2(-40,0));
        PLaneCrash.addImage(new BodyImage("data/ImagesAndGifs/PlaneCrashs.png",40));

        Platform AirPlatform1 = new Platform(this, SmallPlatformshape);
        AirPlatform1.setPosition(new Vec2(35, -8));

        Platform AirPlatform2 = new Platform(this, SmallPlatformshape);
        AirPlatform2.setPosition(new Vec2(45, -5));

        Platform AirPlatform3 = new Platform(this, SmallPlatformshape);
        AirPlatform3.setPosition(new Vec2(55, -3));

        Platform AirPlatform4 = new Platform(this, SmallPlatformshape);
        AirPlatform4.setPosition(new Vec2(100, -2));

        Platform BigAirPlatform = new Platform(this, new BoxShape(15,0.5f));
        BigAirPlatform.setPosition(new Vec2(80, -7));

        GorrillaEnemy GorrillaEnemy3 = new GorrillaEnemy(this);
        GorrillaEnemy3.setPosition(new Vec2(75,4));

        Portal portal = new Portal(this,getMainCharacter(), new CircleShape(2));
        portal.setPosition(new Vec2(110,2.5f));

        GameAward gameAward2 = new GameAward(this, getMainCharacter());
        gameAward2.setPosition(new Vec2(55,-0.5f));

        GameAward gameAward3 = new GameAward(this,getMainCharacter());
        gameAward3.setPosition(new Vec2(100,0));



    }



    @Override
    public boolean isCompleted() {
        if (getMainCharacter().getCoinCount() == 3f){
            return true;
        }
        return false;
    }
    public void StopMusic(){
        BackgroundMusic.stop();
    }
}
