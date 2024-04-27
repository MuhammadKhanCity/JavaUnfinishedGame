package game.Characters;

import city.cs.engine.*;
import game.Listeners.BulletListener;
import org.jbox2d.common.Vec2;

public class JellyFishEnemy extends Walker implements StepListener {
    private static final Shape JellyFishEnemy = new PolygonShape( 0f,2f,
            1.7f,1.48f,
            1.8f,0.3f,
            1.6f,-2.32f,
            -1.12f,-2.27f,
            -1.24f,1.21f);
    private float left;
    private float right;
    private int Health;
    private BulletListener bulletListener = new BulletListener();

    public JellyFishEnemy(World world) {
        super(world, JellyFishEnemy);
        this.addImage(new BodyImage("data/ImagesAndGifs/Enemy2.gif",5f));
        world.addStepListener(this);
        startWalking(3);
        this.Health = 100;
        this.addCollisionListener(bulletListener);
    }

    public void setPosition(Vec2 P){
        super.setPosition(P);
        right = getPosition().x + 4;
        left = getPosition().x - 2;

    }


    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-3);
        }
        if (getPosition().x < left){
            startWalking(3);
        }

    }

    @Override
    public void postStep(StepEvent stepEvent) {


    }
    public void DecrementHealth(){
        Health -= 10;
        if (Health == 0){
            this.destroy();
        }
    }
    public int getHealth(){return Health;}
}
