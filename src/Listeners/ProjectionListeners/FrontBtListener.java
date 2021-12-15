package Listeners.ProjectionListeners;

import MainPack.PaintPanel;
import MainPack.Painter;
import SimpleParts.TransformMatrix.AcsonomProjection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontBtListener implements ActionListener {

    PaintPanel paintPanel;

    public FrontBtListener(PaintPanel paintPanel){
        this.paintPanel = paintPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Painter.setOblique(false);
        Painter.setModMatrix(new AcsonomProjection(0,0));
        paintPanel.repaint();
    }
}
