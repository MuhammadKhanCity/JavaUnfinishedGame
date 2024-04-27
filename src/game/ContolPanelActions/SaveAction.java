package game.ContolPanelActions;

import game.Characters.MainCharacter;
import game.GameLevels.GameWorld;
import game.Other.GameSaverLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveAction implements ActionListener {
    GameWorld level;
    MainCharacter mainCharacter;
    String filename;

    public SaveAction(GameWorld level, MainCharacter mainCharacter, String filename){
        this.level = level;
        this.mainCharacter = mainCharacter;
        this.filename = filename;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            GameSaverLoader.Save(level, mainCharacter, filename);
        }catch(IOException E){
            E.printStackTrace();
        }
    }
}
