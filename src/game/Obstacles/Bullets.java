package game.Obstacles;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Characters.GorrillaEnemy;
import game.Characters.JellyFishEnemy;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Bullets extends DynamicBody {

    private  World world;
   
    public Bullets(World world) {

            super(world);
            this.setLinearVelocity(new Vec2(70, 0));
            this.setAngularVelocity(0);
            this.setFillColor(Color.red);
            this.world = world;


    }
    public Bullets(World world, Shape shape){
        super(world, shape);
        this.setFillColor(Color.red);
        this.world = world;
    }
    


    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
    }
    @Override
    public void setLinearVelocity(Vec2 velocity){
        super.setLinearVelocity(velocity);
    }
    public void setAngularVelocity(float angularVelocity){
        super.setAngularVelocity(angularVelocity);
    }
    public void setWorld(World world){this.world = world;}


}
