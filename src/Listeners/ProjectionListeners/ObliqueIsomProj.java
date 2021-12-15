package Listeners.ProjectionListeners;

import MainPack.PaintPanel;
import MainPack.Painter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObliqueIsomProj implements ActionListener {
    PaintPanel paintPanel;
    JTextField angle;

    public ObliqueIsomProj(PaintPanel paintPanel, JTextField jTextField){
        angle = jTextField;
        this.paintPanel = paintPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Painter.setOblique(true);
            Painter.angleOblique = Double.parseDouble(angle.getText());
            Painter.l = 1;
            paintPanel.repaint();
        } catch  (Exception exception){
            System.out.print(exception);
        }
    }
}
