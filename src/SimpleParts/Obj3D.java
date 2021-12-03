package SimpleParts;

import MainPack.Painter;
import MatrixPack.Matrix;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Obj3D{

    private String name;
    private Color strokeColor;
    private Stroke stroke;
    private ArrayList<Point3D> points;
    private ArrayList<Line3D> lines;
    public Obj3D() {
        Random random = new Random();
        name = String.valueOf(random.nextInt());
        stroke = new BasicStroke(1);
        strokeColor = new Color(Color.BLACK.getRGB());
        points = new ArrayList<>();
        lines = new ArrayList<>();
    }


    public void draw(Graphics2D graphics2D,double objToWin){
        graphics2D.setColor(strokeColor);
        graphics2D.setStroke(stroke);
        for (Line3D line: lines ) {
            Point3D point1 = points.get(line.firstPointInList);
            Point3D point2 = points.get(line.secondPointInList);
            Loc loc1 = Painter.getWinCords(point1);
            Loc loc2 = Painter.getWinCords(point2);
            graphics2D.drawLine(loc1.getX(),loc1.getY(),loc2.getX(),loc2.getY());
        }
    }

    public void matrixMulty(Matrix matrix){
        for (int i = 0; i < points.size(); i++) {
            Matrix newMatrix =  Matrix.multiplication(points.get(i),matrix);
            points.set(i,new Point3D(newMatrix));
        }
    }

    public void matrixSum(Matrix matrix){
        for (int i = 0; i < points.size(); i++) {
            Matrix newMatrix =  Matrix.sum(points.get(i),matrix);
            points.set(i,new Point3D(newMatrix));
        }
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

    public void addPoint(Point3D point3D){
        points.add(point3D);
    }

    public void addLine(Line3D line3D){
        lines.add(line3D);
    }

    public void setLines(ArrayList<Line3D> lines) {
        this.lines = lines;
    }

    public ArrayList<Line3D> getLines() {
        return lines;
    }

    public void setPoints(ArrayList<Point3D> points) {
        this.points = points;
    }

    public ArrayList<Point3D> getPoints() {
        return points;
    }
}
