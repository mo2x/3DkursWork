package Listeners.TransformListeners;

import MainPack.MainFrame;
import MainPack.PaintPanel;
import bjects.Cords;
import bjects.MainObj;
import bjects.SimpleStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeObjButtonListener implements ActionListener {

    PaintPanel paintPanel;
    JTextField h1TF;
    JTextField rTF;
    JTextField kTF;
    JTextField h2TF;
    JTextField aTF;

    public MakeObjButtonListener(PaintPanel paintPanel,
                                 JTextField h1TF,
                                 JTextField rTF,
                                 JTextField kTF,
                                 JTextField h2TF,
                                 JTextField aTF){
        this.paintPanel = paintPanel;
        this.h1TF = h1TF;
        this.rTF = rTF;
        this.kTF = kTF;
        this.h2TF = h2TF;
        this.aTF = aTF;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double h1 = Double.parseDouble(h1TF.getText());
            double r = Double.parseDouble(rTF.getText());
            int k = Integer.parseInt(kTF.getText());
            double h2 = Double.parseDouble(h2TF.getText());
            double a = Double.parseDouble(aTF.getText());
            SimpleStore.objs.clear();
            SimpleStore.points.clear();
            SimpleStore.polys.clear();
            Cords cords = new Cords();
            MainObj mainObj = new MainObj(h1, r, k, h2, a);
            SimpleStore.objs.add(cords);
            SimpleStore.objs.add(mainObj);
            paintPanel.repaint();
        } catch (Exception exception) {
            System.out.print("Неправильно введены данные");
        }
    }
}
