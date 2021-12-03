package Listeners;

import MainPack.PaintPanel;
import MatrixPack.Matrix;
import SimpleParts.Obj3D;
import SimpleParts.TransformMatrix.RepositionMatrix;
import bjects.SimpleStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RePosApplyListener implements ActionListener {

    JTextField posX;
    JTextField posY;
    JTextField posZ;
    PaintPanel paintPanel;

    public RePosApplyListener(PaintPanel paintPanel, JTextField posX, JTextField posY, JTextField posZ){
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.paintPanel = paintPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double x = Double.parseDouble(posX.getText());
            double y = Double.parseDouble(posY.getText());
            double z = Double.parseDouble(posZ.getText());
            RepositionMatrix matrix= new RepositionMatrix(x,y,z);
            Obj3D obj3D = SimpleStore.getObjByName("MainObj");
            assert obj3D != null;
            obj3D.matrixSum(matrix);
            paintPanel.repaint();
        } catch (Exception exception) {
            System.out.print(exception);
        }
    }
}
