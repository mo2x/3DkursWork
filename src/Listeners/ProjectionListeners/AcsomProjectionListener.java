package Listeners.ProjectionListeners;

import MainPack.Controller;
import MainPack.PaintPanel;
import MainPack.Painter;
import SimpleParts.Obj3D;
import SimpleParts.TransformMatrix.AcsonomProjection;
import bjects.SimpleStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcsomProjectionListener implements ActionListener {

    PaintPanel paintPanel;
    JTextField fi;
    JTextField psi;
    public AcsomProjectionListener(PaintPanel paintPanel, JTextField fi, JTextField psi){
        this.paintPanel = paintPanel;
        this.fi = fi;
        this.psi = psi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Painter.setOblique(false);
            double fiD = Double.parseDouble(fi.getText());
            double psiD = Double.parseDouble(psi.getText());
            AcsonomProjection acsonomProjection = new AcsonomProjection(fiD,psiD);
            Painter.setModMatrix(acsonomProjection);
            Painter.fi = fiD;
            Painter.psi = psiD;
            Obj3D.num++;
            Controller.getPaintPanel().repaint();

        } catch (Exception exception) {
            System.out.print("Неправильно введены данные");
        }
    }
}
