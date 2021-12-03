package Listeners;

import MainPack.PaintPanel;
import SimpleParts.Obj3D;
import SimpleParts.TransformMatrix.RepositionMatrix;
import SimpleParts.TransformMatrix.RotateMatrix;
import SimpleParts.TransformMatrix.SizeMatrix;
import bjects.SimpleStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotateApplyListener implements ActionListener {

    JTextField rotX;
    JTextField rotY;
    JTextField rotZ;
    PaintPanel paintPanel;

    public RotateApplyListener(PaintPanel paintPanel, JTextField rotX, JTextField rotY, JTextField rotZ){
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
        this.paintPanel = paintPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double x = Double.parseDouble(rotX.getText());
            double y = Double.parseDouble(rotY.getText());
            double z = Double.parseDouble(rotZ.getText());
            RotateMatrix matrix= new RotateMatrix(x,y,z);
            Obj3D obj3D = SimpleStore.getObjByName("MainObj");
            assert obj3D != null;
            double centerX = obj3D.getPoints().get(0).getX();
            double centerY = obj3D.getPoints().get(0).getY();
            double centerZ = obj3D.getPoints().get(0).getZ();
            RepositionMatrix repositionMatrix = new RepositionMatrix(-centerX,-centerY,-centerZ);
            obj3D.matrixSum(repositionMatrix);
            obj3D.matrixMulty(matrix);
            repositionMatrix = new RepositionMatrix(centerX, centerY ,centerZ);
            obj3D.matrixSum(repositionMatrix);
            paintPanel.repaint();
        } catch (Exception exception) {
            System.out.print(exception);
        }
    }
}
