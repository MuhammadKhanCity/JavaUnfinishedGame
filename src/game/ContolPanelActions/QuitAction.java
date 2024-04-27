package game.ContolPanelActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitAction implements ActionListener {
    public QuitAction(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(1);
    }
}
