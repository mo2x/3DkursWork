package Listeners.ProjectionListeners;

import MainPack.PaintPanel;
import MainPack.Painter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObliqueDimetrProj implements ActionListener {
    PaintPanel paintPanel;
    JTextField angle;

    public ObliqueDimetrProj(PaintPanel paintPanel, JTextField jTextField){
        angle = jTextField;
        this.paintPanel = paintPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            MainPack.Painter.setOblique(true);
            MainPack.Painter.angleOblique = Double.parseDouble(angle.getText());
            Painter.l = 0.5f;
            paintPanel.repaint();
        } catch  (Exception exception){
            System.out.print(exception);
        }
    }
}
