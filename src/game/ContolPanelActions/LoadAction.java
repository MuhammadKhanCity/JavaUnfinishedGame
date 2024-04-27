package game.ContolPanelActions;

import game.Characters.MainCharacter;
import game.Other.GameSaverLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadAction implements ActionListener {
    String fileName;

    public LoadAction(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            GameSaverLoader.Load(fileName);
        }catch (IOException E){}
    }
}
