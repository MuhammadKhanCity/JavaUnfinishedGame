package game.Obstacles;

import city.cs.engine.*;
import game.Characters.MainCharacter;
import game.GameLevels.GameWorld;
import game.Other.Game;

public class Portal extends StaticBody implements CollisionListener {

        private MainCharacter mainCharacter;
        private GameWorld world;
        public Portal(GameWorld world, MainCharacter mainCharacter, Shape shape){
            super(world, shape);
            this.addImage(new BodyImage("data/ImagesAndGifs/portal.png",4));
            this.mainCharacter = mainCharacter;
            this.world = world;
            this.addCollisionListener(this);


        }
        public void collide(CollisionEvent e) {
            if (e.getOtherBody() instanceof MainCharacter){
                if (world.isCompleted()){
                    Game.gotoNextLevel();
                    System.out.println("Active");
                }
            }
            if (e.getOtherBody() instanceof Bullets){
                e.getOtherBody().destroy();
            }
        }
    }


