package bjects;

import SimpleParts.Line3D;
import SimpleParts.Obj3D;
import SimpleParts.Point3D;

import java.awt.*;

public class MainObj extends Obj3D {

    Point3D center;

    public MainObj(double h1, double r, int k, double h2, double a){
        super();
        setName("MainObj");
        setStroke(1);
        center = new Point3D(0,0,0);
        addPoint(center);
        //пирамида
        addPoint(new Point3D(a/2,0,a/2));
        addPoint(new Point3D(-a/2,0,a/2));
        addPoint(new Point3D(-a/2,0,-a/2));
        addPoint(new Point3D(a/2,0,-a/2));
        addPoint(new Point3D(0,-h2,0));
        for (int i = 1; i < 5; i++){
            addLine(new Line3D(i,5));
            if (i!=1) {
                addLine(new Line3D(i,i-1));
            }else{
                addLine(new Line3D(i,4));
            }
        }
        //конус
        addPoint(new Point3D(0,h1,0));
        double angle = (360f/k)*(Math.PI/180f);
        for (int i = 0; i<k; i++){
            addPoint(new Point3D(Math.cos(angle*i)*r,0,Math.sin(angle*i)*r));
            addLine(new Line3D(6,7+i));
            if (i>0){
                addLine(new Line3D(6+i,7+i));
            }
            if (i == k-1){
                addLine(new Line3D(7+i,7));
            }
        }

    }

}
