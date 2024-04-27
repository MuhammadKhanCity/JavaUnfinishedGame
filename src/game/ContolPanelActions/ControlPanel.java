package game.ContolPanelActions;

import game.Characters.MainCharacter;
import game.GameLevels.GameWorld;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private MainCharacter mainCharacter;
    private GameWorld level;
    private String fileName;


    public ControlPanel(GameWorld level, MainCharacter mainCharacter, String fileName){
        this.mainCharacter = mainCharacter;
        this.level = level;
        this.fileName = fileName;
        setSize(new Dimension(750, 200));

        JButton ControlDisplayButton = new JButton("Controls");
        ControlDisplayButton.addActionListener(new ControlsDisplay());

        JButton QuitButton = new JButton("Quit");
        QuitButton.addActionListener(new QuitAction());

        JButton SaveButton = new JButton("Save");
        SaveButton.addActionListener(new SaveAction(level, mainCharacter, fileName));

        JButton LoadButton = new JButton("Load");
        LoadButton.addActionListener(new LoadAction(fileName));

        this.add(ControlDisplayButton);
        this.add(QuitButton);
        this.add(SaveButton);
        this.add(LoadButton);

        setVisible(true);


    }
}
