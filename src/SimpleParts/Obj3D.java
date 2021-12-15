package SimpleParts;

import MainPack.Painter;
import MatrixPack.Matrix;
import bjects.SimpleStore;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Obj3D{


    public static int num = 0;
    private Point3D center;
    private String name;
    protected Color strokeColor;
    protected Stroke stroke;
    protected int[] points;
    protected int[] lines;
    protected int[] polys;

    public Obj3D() {
        Random random = new Random();
        name = String.valueOf(random.nextInt());
        stroke = new BasicStroke(1);
        strokeColor = new Color(Color.BLACK.getRGB());
        points = new int[0];
        lines = new int[0];
        polys = new int[0];
    }

    public Obj3D(Obj3D obj3D){
        this.center = obj3D.center;
        this.name = obj3D.name;
        this.strokeColor = obj3D.strokeColor;
        this.stroke = obj3D.stroke;
        points = obj3D.points;
        lines = obj3D.lines;
        polys = obj3D.polys;
    }


    public void draw(Graphics2D graphics2D,double objToWin){
        graphics2D.setColor(strokeColor);
        graphics2D.setStroke(stroke);
        int j = 0;
        for (int value : polys) {
            j++;
            if (j==num) {
                break;
            }
            Poly3D poly = SimpleStore.polys.get(value);
            int[] x = new int[poly.points.length];
            int[] y = new int[poly.points.length];
            for (int i = 0; i < poly.points.length; i++) {
                Loc loc = Painter.getWinCords(SimpleStore.points.get(poly.points[i]));
                x[i] = loc.getX();
                y[i] = loc.getY();
            }
            graphics2D.setColor(new Color(Color.blue.getRGB()));
            graphics2D.fillPolygon(x, y, poly.points.length);
            graphics2D.setColor(strokeColor);
            graphics2D.drawPolygon(x, y, poly.points.length);
        }
        if (name.equals("Cords"))
        for (int k : lines) {
            Line3D line = SimpleStore.lines.get(k);
            Point3D point1 = SimpleStore.points.get(points[line.firstPointInList]);
            Point3D point2 = SimpleStore.points.get(points[line.secondPointInList]);
            Loc loc1 = Painter.getWinCords(point1);
            Loc loc2 = Painter.getWinCords(point2);
            graphics2D.drawLine(loc1.getX(), loc1.getY(), loc2.getX(), loc2.getY());
        }
    }

    public void matrixMulty(Matrix matrix){
        for (int i = 0; i < points.length; i++) {
            Matrix newMatrix =  Matrix.multiplication(SimpleStore.points.get(points[i]),matrix);
            SimpleStore.points.set(points[i],new Point3D(newMatrix));
        }
    }

    public void matrixSum(Matrix matrix){
        for (int i = 0; i < points.length; i++) {
            Matrix newMatrix =  Matrix.sum(SimpleStore.points.get(points[i]),matrix);
            SimpleStore.points.set(points[i],new Point3D(newMatrix));
        }
    }

    public Point3D getCenter() {
        return center;
    }

    public void setCenter(Point3D center) {
        this.center = center;
    }

    public void setStroke(int width) {
        this.stroke = new BasicStroke(width);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int[] getPointsRefs() {
        return points;
    }

    public void addPoint(Point3D point3D){
        int[] pointsBuf = new int[points.length + 1];
        System.arraycopy(points, 0, pointsBuf, 0, points.length);
        points = pointsBuf;
        SimpleStore.points.add(point3D);
        points[points.length-1] = SimpleStore.points.size()-1;
    }

    public void addLine(Line3D line3D){
        int[] linesBuf = new int[lines.length + 1];
        System.arraycopy(lines, 0, linesBuf, 0, lines.length);
        lines = linesBuf;
        SimpleStore.lines.add(line3D);
        lines[lines.length-1] = SimpleStore.lines.size()-1;
    }

    public void addPoly(Poly3D poly3D){
        int[] polysBuf = new int[polys.length + 1];
        System.arraycopy(polys, 0, polysBuf, 0, polys.length);
        for (int i = 0; i < poly3D.points.length; i++){
            poly3D.points[i] = points[poly3D.points[i]];
        }
        polys = polysBuf;
        SimpleStore.polys.add(poly3D);
        polys[polys.length-1] = SimpleStore.polys.size()-1;
    }
}
