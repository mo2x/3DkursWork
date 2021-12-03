package bjects;

import MainPack.Controller;
import MainPack.Painter;
import SimpleParts.Line3D;
import SimpleParts.Loc;
import SimpleParts.Obj3D;
import SimpleParts.Point3D;

import java.awt.*;
import java.util.ArrayList;

public class Cords extends Obj3D {

    public Cords(){
        super();
        setName("Cords");
        setStroke(1);
        setStrokeColor(Color.RED);
        addPoint(new Point3D(0,0,0));
        addPoint(new Point3D(10,0,0));
        addPoint(new Point3D(0,10,0));
        addPoint(new Point3D(0,0,10));
        addLine(new Line3D(0,1));
        addLine(new Line3D(0,2));
        addLine(new Line3D(0,3));
    }

    @Override
    public void draw(Graphics2D graphics2D, double objToWin) {
        double val = graphics2D.getClip().getBounds().width / Painter.getObjToWinPx() / 4;
        //getPoints().get(1).setValue(3,0, val);
        //getPoints().get(2).setValue(3,1, val);
        //getPoints().get(3).setValue(3,2, val);

        super.draw(graphics2D, objToWin);
    }
}
