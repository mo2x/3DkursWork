import SimpleParts.Line3D;
import SimpleParts.Loc;

import java.awt.*;

public class Painter {

    static Loc centerWinLoc = new Loc();
    static int pixInStep;
    static int wightCount = 30;

    public static Loc getCenterWinCord(){
        int h = Controller.getMainFrame().paintPanel.getSize().height / 2;
        int w = Controller.getMainFrame().paintPanel.getSize().width / 2;
        Loc loc = new Loc(w,h);
        return loc;
    }

    public static Loc paperToWinCord(Loc loc){
        Loc res = new Loc();
        res.setX(centerWinLoc.getDoubleX() + (loc.getDoubleX() * pixInStep));
        res.setY(centerWinLoc.getDoubleY() - (loc.getDoubleY() * pixInStep));
        return res;
    }

    private static void drawStep(Graphics g, int wightCount){
        int point = 0;
        while (true){
            int ex = 0;
            point += pixInStep;
            if (centerWinLoc.getX()+point<centerWinLoc.getX()*2) {
                g.drawLine(centerWinLoc.getX() + point, centerWinLoc.getY() - 1,
                        centerWinLoc.getX() + point, centerWinLoc.getY() + 1);
                g.drawLine(centerWinLoc.getX() - point, centerWinLoc.getY() - 1,
                        centerWinLoc.getX() - point, centerWinLoc.getY() + 1);
            }
            else {
                ex++;
            }
            if (centerWinLoc.getY()+point<centerWinLoc.getY()*2) {
                g.drawLine(centerWinLoc.getX() + 1, centerWinLoc.getY() - point,
                        centerWinLoc.getX() - 1, centerWinLoc.getY() - point);
                g.drawLine(centerWinLoc.getX() + 1, centerWinLoc.getY() + point,
                        centerWinLoc.getX() - 1, centerWinLoc.getY() + point);
            } else {
                ex++;
            }
            if (ex==2){
                break;
            }
        }
    }

    public static void drawCord(Graphics g){
        centerWinLoc = getCenterWinCord();
        g.drawLine(centerWinLoc.getX(),0,centerWinLoc.getX(), (int) Controller.getMainFrame().paintPanel.getSize().height);
        g.drawLine(0,centerWinLoc.getY(), (int) Controller.getMainFrame().paintPanel.getSize().width, centerWinLoc.getY());
        pixInStep = centerWinLoc.getX()/wightCount;
        drawStep(g,wightCount);
    }

    public static void drawLines(Graphics2D graphics2D){
        graphics2D.setStroke(new BasicStroke(2));
        for (Line3D line : SimpleStore.Lines) {
            int p1 = line.getFirstPointInList();
            int p2 = line.getSecondPointInList();
            Loc l1 = new Loc( SimpleStore.Points.get(p1).getX(),
                     SimpleStore.Points.get(p1).getY());
            Loc l2 = new Loc( SimpleStore.Points.get(p2).getX(),
                     SimpleStore.Points.get(p2).getY());
            l1 = Painter.paperToWinCord(l1);
            l2 = Painter.paperToWinCord(l2);
            graphics2D.drawLine( l1.getX(),  l1.getY(),
                     l2.getX(),  l2.getY());
        }
    }
}
