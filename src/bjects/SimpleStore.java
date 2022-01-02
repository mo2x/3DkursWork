package bjects;

import SimpleParts.Line3D;
import SimpleParts.Obj3D;
import SimpleParts.Point3D;
import SimpleParts.Poly3D;

import java.util.ArrayList;

public class SimpleStore {

    public static ArrayList<Obj3D> objs;
    public static ArrayList<Point3D> points;
    public static ArrayList<Line3D> lines;
    public static ArrayList<Poly3D> polys;

    public static ArrayList<Point3D> visBuf;
    public static ArrayList<Poly3D> polyBuf;

    public static void init(){
        objs = new ArrayList<>();
        points = new ArrayList<>();
        lines = new ArrayList<>();
        polys = new ArrayList<>();
        visBuf = new ArrayList<>();
    }

    public static Obj3D getObjByName(String name){
        if (objs != null){
            for (Obj3D obj3D:objs) {
                if (obj3D.getName().equals(name)){
                    return obj3D;
                }
            }
        }
        return null;
    }
}
