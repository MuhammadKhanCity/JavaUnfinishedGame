package game.Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import game.Characters.GorrillaEnemy;
import game.Characters.JellyFishEnemy;
import game.Obstacles.Bullets;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class BulletListener implements CollisionListener {
    private SoundClip MonsterHurt;

    public BulletListener(){

    }
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Walker) {
            if (e.getReportingBody().getLinearVelocity().x > 2 || e.getReportingBody().getLinearVelocity().x <= -2) {
                if (e.getOtherBody() instanceof GorrillaEnemy) {
                    ((GorrillaEnemy) e.getOtherBody()).DecrementHealth();
                    try{
                        MonsterHurt = new SoundClip("data/Sounds/MonsterHurt.wav");
                        MonsterHurt.play();
                    }catch(UnsupportedAudioFileException | IOException | LineUnavailableException E){
                        System.out.println(E);
                    }

                } else if (e.getOtherBody() instanceof JellyFishEnemy) {
                    ((JellyFishEnemy) e.getOtherBody()).DecrementHealth();
                }
            }
            if (e.getOtherBody() instanceof Bullets) {
                e.getOtherBody().destroy();
                e.getReportingBody().destroy();
            }
        }
    }
}
