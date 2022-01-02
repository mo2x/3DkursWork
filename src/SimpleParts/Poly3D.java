package SimpleParts;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Poly3D {
    public int[] points;
    public Color color = new Color(Color.BLUE.getRGB());
    public double bright = 1;

    public Poly3D(int... point3DS){
        this.points = new int[point3DS.length];
        System.arraycopy(point3DS, 0, this.points, 0, points.length);
    }

    public Poly3D(Poly3D poly3D){
        this.points = new int[poly3D.points.length];
        System.arraycopy(poly3D.points, 0, this.points, 0, poly3D.points.length);
        bright = poly3D.bright;
        color = poly3D.color;
    }
    public int get(int i){
        return points[i];
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public Color getColor() {
        return color;
    }

    public int[] getPoints() {
        return points;
    }
}
