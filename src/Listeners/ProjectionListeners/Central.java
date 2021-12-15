package Listeners.ProjectionListeners;

import MainPack.Controller;
import MainPack.PaintPanel;
import MainPack.Painter;
import MatrixPack.Matrix;
import SimpleParts.TransformMatrix.AcsonomProjection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Central implements ActionListener {

    PaintPanel paintPanel;
    JTextField cFi;
    JTextField cPsi;
    JTextField cD;
    JTextField cP;

    public Central(PaintPanel paintPanel,
                   JTextField cFi,
            JTextField cPsi,
            JTextField cD,
            JTextField cP){
        this.cFi = cFi;
        this.cPsi = cPsi;
        this.cD = cD;
        this.cP = cP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double fi = Double.parseDouble(cFi.getText());
            double psi = Double.parseDouble(cPsi.getText());
            double d = Double.parseDouble(cD.getText());
            double p = Double.parseDouble(cP.getText());
            Painter.setModMatrix(new AcsonomProjection(fi,psi));
            Painter.setPerspective(true);
            Painter.d = d;
            Painter.p = p;
            Painter.psi = psi;
            Painter.fi = fi;
            Controller.getPaintPanel().repaint();
        } catch (Exception exception) {
            System.out.print("Неправильно введены данные");
        }
    }

}
