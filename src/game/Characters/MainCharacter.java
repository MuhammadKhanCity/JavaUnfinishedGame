package game.Characters;

import city.cs.engine.*;
import game.GameLevels.GameWorld;
import game.Listeners.BulletListener;
import game.Obstacles.Bullets;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MainCharacter extends Walker implements CollisionListener, StepListener, ActionListener {
    private static final Shape mainchracterShape = new PolygonShape(0, 1.7f
            , 1f, 0.8f
            , 1.5f, 0.2f,
            0.5f, -1.7f,
            -0.8f, -1.7f,
            -1f, 0);
    private  static Bullets bullets;
    private int Health;
    private boolean directionofaCharacter = true;
    private static GameWorld world;
    private int CoinCount = 0;
    private SoundClip Gunshot;
    private SoundClip CharacterHurt;
    private SoundClip CharacterDeath;
    private SoundClip CoinCollect;
    private BulletListener bulletListener = new BulletListener();
    private MainCharacter mainCharacter;

    public MainCharacter(GameWorld world) {
        super(world, mainchracterShape);
        this.addImage(new BodyImage("data/ImagesAndGifs/MetalSlug.png", 4f));
        this.setGravityScale(3);
        this.Health = 3;
        this.world = world;
        this.bullets = new Bullets(world);
        this.addCollisionListener(this);
        world.addStepListener(this);




    }

    public void startWalking(float speed) {
        super.startWalking(speed);
        this.removeAllImages();
        AttachedImage MaincharacterImage = new AttachedImage(this, new BodyImage("data/ImagesAndGifs/MetalSlug.png"), 4, 0, new Vec2(0, 0));
        if (speed < 0) {

            MaincharacterImage.flipHorizontal();

        } else if (speed > 0) {

        }

    }

    public void Shoot(GameWorld world) {
        final Shape BulletShape = new BoxShape(0.2f, 0.1f);

        bullets = new Bullets(world, BulletShape);
        bullets.setAngularVelocity(0);
        bullets.addCollisionListener(bulletListener);
        try {
            Gunshot = new SoundClip("data/Sounds/GunShot.wav");
            Gunshot.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }



    }
    public void setDirectionofaCharacter(boolean directionofaCharacter){
        this.directionofaCharacter = directionofaCharacter;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        this.tracker();
        if (directionofaCharacter) {
            bullets.setPosition(new Vec2(world.getMainCharacter().getPosition().x + 1.7f, world.getMainCharacter().getPosition().y));
            bullets.setLinearVelocity(new Vec2(70, 0)); // Set velocity to the right if character is facing right
        } else {
            bullets.setPosition(new Vec2(world.getMainCharacter().getPosition().x - 1.7f, world.getMainCharacter().getPosition().y));
            bullets.setLinearVelocity(new Vec2(-70, 0)); // Set velocity to the left if character is facing left
        }




    }

    public void postStep(StepEvent stepEvent) {






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.Shoot(world);
    }

    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof GorrillaEnemy) {
            ((MainCharacter) e.getReportingBody()).DecrementHealth();
            try {
                CharacterHurt = new SoundClip("data/Sounds/CharacterHurt.wav");
                CharacterHurt.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
                System.out.println(exception);
            }
        } else if (e.getOtherBody() instanceof JellyFishEnemy) {
            ((MainCharacter) e.getReportingBody()).DecrementHealth();
            try {
                CharacterHurt = new SoundClip("data/Sounds/CharacterHurt.wav");
                CharacterHurt.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
                System.out.println(exception);
            }
        }

    }
    public void setWorldBullets(World world){
        bullets.setWorld(world);
    }

    public int getHealth() {
        return Health;
    }

    public void DecrementHealth() {
        Health -= 1;
        if (Health == 0) {
            this.destroy();
            try {
                CharacterDeath = new SoundClip("data/Sounds/ChracterDeath.wav");
                CharacterDeath.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {

            }
        }

    }
    public static Bullets getBullets(){
        return bullets;
    }

    public void CoinIncrement() {
        CoinCount += 1;
        try {
            CoinCollect = new SoundClip("data/Sounds/CoinCollect.wav");
            CoinCollect.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
        }
    }

    public int getCoinCount() {
        return CoinCount;
    }

    public void tracker() {

        if(this.getPosition().y < -30) {
            this.destroy();
            System.exit(1);
            try {
                CharacterDeath = new SoundClip("data/Sounds/ChracterDeath.wav");
                CharacterDeath.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            }

        }
    }



}
