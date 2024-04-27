package game.Characters;

import city.cs.engine.*;
import game.Listeners.BulletListener;
import org.jbox2d.common.Vec2;


public class GorrillaEnemy extends Walker implements StepListener {
        private static final BodyImage GorrillaImage = new BodyImage("data/ImagesAndGifs/Gorrilla.png", 4f);
        private static final Shape GorrillaPolygonShape = new PolygonShape(-0f,2f,
                1.7f,1.48f,
                1.8f,0.3f,
                1.6f,-2.32f,
                -1.12f,-2.27f,
                -1.24f,1.21f);

        private float left;
        private float right;
        private int Health = 100;
        private BulletListener bulletListener = new BulletListener();


    public GorrillaEnemy(World w) {
        super(w, GorrillaPolygonShape);
        addImage(GorrillaImage);
        w.addStepListener(this);
        startWalking(3);
        this.addCollisionListener(bulletListener);

    }

    public void setPosition(Vec2 P){
        super.setPosition(P);
        left = getPosition().x - 3f;
        right = getPosition().x + 3f;
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


   public int getHealth(){return this.Health;}
    public void startWalking(float speed){
        super.startWalking(speed);
        this.removeAllImages();
        AttachedImage GorrillaImage = new AttachedImage(this, new BodyImage("data/ImagesAndGifs/Gorrilla.png"), 5f,0,new Vec2(0,0));
        if(speed < 0){
            GorrillaImage.flipHorizontal();

        }

    }
}
