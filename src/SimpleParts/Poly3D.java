package SimpleParts;

import java.util.ArrayList;
import java.util.Collections;

public class Poly3D {
    public int[] points;

    public Poly3D(int... point3DS){
        this.points = new int[point3DS.length];
        System.arraycopy(point3DS, 0, this.points, 0, points.length);
    }
    public int get(int i){
        return points[i];
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public int[] getPoints() {
        return points;
    }
}
