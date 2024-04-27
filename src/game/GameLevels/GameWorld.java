package game.GameLevels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import com.sun.tools.javac.Main;
import game.Obstacles.Bullets;
import game.Obstacles.GameAward;
import game.Characters.GorrillaEnemy;
import game.Characters.JellyFishEnemy;
import game.Characters.MainCharacter;
import game.Obstacles.Platform;
import game.Other.Game;
import org.jbox2d.common.Vec2;
import city.cs.engine.World;

import java.awt.*;


public abstract class GameWorld extends World {

    private static MainCharacter mainCharacter;
    private StaticBody ground;


    public GameWorld() {
        //make a character (with an overlaid image)
        createPlayer();
        GameAward gameAward = new GameAward(this, this.getMainCharacter());
        gameAward.setPosition(new Vec2(1.2f, 8f));

        Shape groundShape = new BoxShape(50, 0.5f);
        ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-20, -12f));

        GorrillaEnemy gorrillaEnemy1 = new GorrillaEnemy(this);
        gorrillaEnemy1.setPosition(new Vec2(6f, 10));


        JellyFishEnemy jellyEnemy1 = new JellyFishEnemy(this);
        jellyEnemy1.setPosition(new Vec2(-5f, 10));

        Shape platformShapeNormal = new BoxShape(3, 0.5f);
        Shape platfromShapeBigMiddle = new BoxShape(10, 0.5f);
        Shape SmallPlatformshape = new BoxShape(1.5f,0.5f);

        Platform platorm1 = new Platform(this, platformShapeNormal);
        platorm1.setPosition(new Vec2(-7,-5.5f));

        Platform platorm2 = new Platform(this, platformShapeNormal);
        platorm2.setPosition(new Vec2(7,-5.5f));

        Platform platform3 = new Platform(this, platfromShapeBigMiddle);
        platform3.setPosition(new Vec2(1,6));

        Platform tiltedPlatform1 = new Platform(this, platformShapeNormal);
        tiltedPlatform1.setAngle(4);
        tiltedPlatform1.setPosition(new Vec2(15,0));

        Platform tiltedPlatform2 = new Platform(this, platformShapeNormal);
        tiltedPlatform2.setAngle(-4);
        tiltedPlatform2.setPosition(new Vec2(-15,0));

        GorrillaEnemy GorrillaEnemy2 = new GorrillaEnemy(this);
        GorrillaEnemy2.setPosition(new Vec2(10,-8));

        JellyFishEnemy JellyFishEnemy2 = new JellyFishEnemy(this);
        JellyFishEnemy2.setPosition(new Vec2(-10,-8));


    }



    public static MainCharacter getMainCharacter() {
        return mainCharacter;
    }

    public abstract boolean isCompleted();
    public void createPlayer(){
        if (this.mainCharacter != null) {
           mainCharacter.destroy();
        }
        mainCharacter = new MainCharacter(this);

        mainCharacter.setPosition(new Vec2(0,0));

    }
    public void setgroundcolor(Color groundColor){ground.setFillColor(groundColor);}

    public String GetLevelName(){
        if (this instanceof Level1){
            return "Level1";
        } else if (this instanceof Level2) {
            return "level2";
        }
        return "Null";
    }
}
