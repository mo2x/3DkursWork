package bjects;

import SimpleParts.Line3D;
import SimpleParts.Obj3D;
import SimpleParts.Point3D;

import java.util.ArrayList;

public class SimpleStore {
    public static ArrayList<Obj3D> objs;

    public static void init(){
        objs = new ArrayList<>();
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
