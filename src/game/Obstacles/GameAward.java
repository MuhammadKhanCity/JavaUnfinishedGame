package game.Obstacles;

import city.cs.engine.*;
import game.Characters.MainCharacter;

public class GameAward extends StaticBody implements CollisionListener{
    private static final  Shape gameawardShape = new CircleShape(0.3f);
    private final MainCharacter mainCharacter;
    public GameAward(World w, MainCharacter mainCharacter) {
        super(w, gameawardShape);
        this.addImage(new BodyImage("data/ImagesAndGifs/GameAwardGif1.gif"));
        this.mainCharacter = mainCharacter;
        this.addCollisionListener(this);
    }
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof MainCharacter) {
            ((MainCharacter) e.getOtherBody()).CoinIncrement();
            e.getReportingBody().destroy();
        }
    }
}
