package MainPack;

import bjects.SimpleStore;

import java.math.BigDecimal;

public class Controller {

    public static int doubleToInt(double v){
        if (v>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if (v<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else {
            return (int) v;
        }
    }

    static MainFrame mainFrame = new MainFrame();

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static PaintPanel getPaintPanel() {
        return mainFrame.getPaintPanel();
    }

    public static void main(String[] args) {
        SimpleStore.init();
    }
}
