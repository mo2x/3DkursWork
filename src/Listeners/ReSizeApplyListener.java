package Listeners;

import MainPack.PaintPanel;
import SimpleParts.Obj3D;
import SimpleParts.TransformMatrix.RepositionMatrix;
import SimpleParts.TransformMatrix.SizeMatrix;
import bjects.SimpleStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReSizeApplyListener implements ActionListener {

    JTextField sizeX;
    JTextField sizeY;
    JTextField sizeZ;
    PaintPanel paintPanel;

    public ReSizeApplyListener(PaintPanel paintPanel, JTextField sizeX, JTextField sizeY, JTextField sizeZ){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.paintPanel = paintPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double x = Double.parseDouble(sizeX.getText());
            double y = Double.parseDouble(sizeY.getText());
            double z = Double.parseDouble(sizeZ.getText());
            SizeMatrix matrix= new SizeMatrix(x,y,z);
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
