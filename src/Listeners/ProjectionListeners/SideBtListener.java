package Listeners.ProjectionListeners;

import MainPack.PaintPanel;
import MainPack.Painter;
import SimpleParts.TransformMatrix.AcsonomProjection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideBtListener implements ActionListener {
    PaintPanel paintPanel;

    public SideBtListener(PaintPanel paintPanel){
        this.paintPanel = paintPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Painter.setOblique(false);
        Painter.setModMatrix(new AcsonomProjection(0,90));
        paintPanel.repaint();
    }
}
