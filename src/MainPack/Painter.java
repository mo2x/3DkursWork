package MainPack;

import SimpleParts.Loc;
import SimpleParts.Obj3D;
import SimpleParts.Point3D;
import bjects.SimpleStore;

import java.awt.*;

public class Painter {

    public static int wightCount = 30;
    public static double objToWinPx;
    static Loc center = new Loc();

    public static Loc getWinCords(Point3D point3D){

        int x =  center.getX() + Controller.doubleToInt(point3D.getX() * objToWinPx);
        int y =  center.getY() - Controller.doubleToInt(point3D.getY() * objToWinPx);
        return  new Loc(x,y);
    }

    public static double getObjToWinPx(){
                return (double) Controller.getMainFrame().getPaintPanel().getSideSize()/(double)wightCount;
    }

    public static void draw(Graphics2D graphics2D){
        if (SimpleStore.objs == null){
            return;
        }
        for (Obj3D obj3D : SimpleStore.objs) {
            center.setX(graphics2D.getClip().getBounds().x +
                    (int) (graphics2D.getClip().getBounds().width / 2));
            center.setY(graphics2D.getClip().getBounds().y +
                    (int) (graphics2D.getClip().getBounds().height / 2));
            obj3D.draw(graphics2D, objToWinPx=getObjToWinPx());
        }
    }
}
