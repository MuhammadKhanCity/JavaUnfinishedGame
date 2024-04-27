package game.ContolPanelActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsDisplay implements ActionListener {
    Component frame;


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "W - Move Up\n"
                + "Left Arrow Key - Move Left\n"
                + "Right Arrow Key - Move Right\n"
                + "Up Arrow Key - Jump\n"
                + "S - Shoot\n");
    }
}
