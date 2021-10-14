import SimpleParts.Line3D;
import SimpleParts.Point3D;

import java.util.ArrayList;

public class SimpleStore {
    static ArrayList<Line3D> Lines;
    static ArrayList<Point3D> Points;

    public static void init(){
        Lines = new ArrayList<>();
        Points = new ArrayList<>();
    }
}
