package game.Other;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.Characters.GorrillaEnemy;
import game.Characters.JellyFishEnemy;
import game.Characters.MainCharacter;
import game.GameLevels.GameWorld;
import game.GameLevels.Level1;
import game.GameLevels.Level2;
import game.GameLevels.Level3;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image BackgroundImage;
    private Image HealthImage = new ImageIcon("data/ImagesAndGifs/redheart.png").getImage();
    private MainCharacter mainCharacter;
    private GameWorld world;

    public GameView(GameWorld w, int width, int height, MainCharacter mainCharacter) {
        super(w, width, height);
        ImageIcon icon = new ImageIcon("data/ImagesAndGifs/Forest.gif");
        BackgroundImage = icon.getImage();
        this.mainCharacter = mainCharacter;
        world = w;

    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (Game.getLevel() instanceof Level1) {
            g.drawImage(BackgroundImage, 0, 0, this);
            setView(new Vec2(Level1.getMainCharacter().getPosition().x, 0), 20);
        } else if (Game.getLevel() instanceof Level2) {
            ImageIcon Level2Icon = new ImageIcon("data/ImagesAndGifs/Level2Background.gif");
            BackgroundImage = Level2Icon.getImage();
            g.drawImage(BackgroundImage, 0, 0, this);
            setView(new Vec2(Level2.getMainCharacter().getPosition().x, 0), 20);
        } else if (Game.getLevel() instanceof Level3) {
            ImageIcon Level3Icon = new ImageIcon("data/ImagesAndGifs/Level3BackgroundPic.png");
            BackgroundImage = Level3Icon.getImage();
            g.drawImage(BackgroundImage, 0, 0, this);
            setView(new Vec2(Level3.getMainCharacter().getPosition().x, 0), 20);
        }
    }

    protected void paintForeground(Graphics2D g) {
        if (Game.getLevel() instanceof Level1) {
            int x = 10;
            for (int i = 0; i < world.getMainCharacter().getHealth(); i++) {
                g.drawImage(HealthImage, x, 0, this);
                x += 40;
            }


        } else if (Game.getLevel() instanceof Level2) {
            int x = 10;
            for (int i = 0; i < world.getMainCharacter().getHealth(); i++) {
                g.drawImage(HealthImage, x, 0, this);
                x += 40;
            }
        } else if (Game.getLevel() instanceof Level3) {
            int x = 10;
            for (int i = 0; i < world.getMainCharacter().getHealth(); i++) {
                g.drawImage(HealthImage, x, 0, this);
                x += 40;
            }

        }

    }
}
