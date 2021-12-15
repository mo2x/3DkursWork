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
        setCenter(new Point3D(0,0,0));
        addPoint(new Point3D(0,0,0));
        addPoint(new Point3D(10,0,0));
        addPoint(new Point3D(0,10,0));
        addPoint(new Point3D(0,0,10));
        addLine(new Line3D(0,1));
        addLine(new Line3D(0,2));
        addLine(new Line3D(0,3));
    }
}
