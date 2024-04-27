package game.Obstacles;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Characters.MainCharacter;
import game.GameLevels.GameWorld;
import game.GameLevels.Level1;
import game.GameLevels.Level2;
import game.Other.Game;

import java.awt.*;

public class Platform extends StaticBody {
    Color PlatformColor= new Color(196, 164, 132);
    public Platform(World w, Shape s) {
        super(w, s);
        if (!(Game.getLevel() instanceof Level1)){
            PlatformColor = new Color(196, 164, 132);
            this.setFillColor(PlatformColor);
        } else if (!(Game.getLevel() instanceof Level2)) {
            PlatformColor = Color.red;
            this.setFillColor(PlatformColor);
        }

    }

}
