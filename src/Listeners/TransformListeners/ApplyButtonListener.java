package Listeners.TransformListeners;

import MainPack.Controller;
import MainPack.Painter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyButtonListener implements ActionListener {

    JTextField wightCount;

    public ApplyButtonListener(JTextField wightCount){
        this.wightCount = wightCount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            Painter.wightCount = Integer.parseInt(wightCount.getText());
            Controller.getPaintPanel().repaint();

        } catch (Exception exception) {
            System.out.print("Неправильно введены данные");
        }
    }
}
