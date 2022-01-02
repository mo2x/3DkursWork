package MainPack;

import MatrixPack.Matrix;
import SimpleParts.Loc;
import SimpleParts.Obj3D;
import SimpleParts.Point3D;
import SimpleParts.Poly3D;
import SimpleParts.TransformMatrix.*;
import bjects.Cords;
import bjects.SimpleStore;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Painter {

    public static double lightID;
    public static double lightIa;
    public static double lightKa;
    public static double[] lightV = new double[3];
    public static boolean hide = false;
    public static boolean light = false;
    public static int wightCount = 30;
    public static double objToWinPx;
    static Loc center = new Loc();
    private static boolean isOblique = false;
    public static double l;
    public  static double angleOblique = 0;
    private static Matrix modMatrix = null;
    private static boolean perspective = false;
    public static double p;
    public static double d;
    public static double fi;
    public static double psi;

    public static Loc getWinCords(Point3D point3D){

        int x =  center.getX() + Controller.doubleToInt(point3D.getX() * objToWinPx);
        int y =  center.getY() - Controller.doubleToInt(point3D.getY() * objToWinPx);
        return  new Loc(x,y);
    }

    public static double getObjToWinPx(){
                return (double) Controller.getMainFrame().getPaintPanel().getSideSize()/(double)wightCount;
    }

    private static Matrix cameraMove(){
        double x = (p)*Math.sin(Math.toRadians(psi))*Math.cos(Math.toRadians(fi));
        double z = (p)*Math.cos(Math.toRadians(psi))*Math.cos(Math.toRadians(fi));
        double y = (p)*Math.sin(Math.toRadians(fi));
        Matrix rez = new Point3D(-x,-y,-z);
        rez = Matrix.multiplication(rez,new RotateMatrix(0,-psi,0));
        rez = Matrix.multiplication(rez,new RotateMatrix(fi,0,0));
        return rez;
    }

    private static void visModification(Obj3D obj3D){
        if (isOblique()) {
            for (int i = 0; i < obj3D.getPointsRefs().length; i++) {
                SimpleStore.points.set(obj3D.getPointsRefs()[i],
                        ObliqueProjection.projection(SimpleStore.points.get(obj3D.getPointsRefs()[i]),angleOblique,l));
            }
        } else if (isPerspective()){
            Matrix cameraPoint = cameraMove();
            obj3D.matrixMulty(cameraPoint);
            for (int i = 0; i < obj3D.getPointsRefs().length; i++) {
                Point3D point3D = new Point3D(Matrix.multiplication(SimpleStore.points.get(obj3D.getPointsRefs()[i])
                        ,new PerspectiveProjection(d)));
                if (point3D.getValue(3,3) != 0) {
                    point3D.setValue(3, 0, point3D.getX() / point3D.getValue(3, 3));
                    point3D.setValue(3, 1, point3D.getY() / point3D.getValue(3, 3));
                    point3D.setValue(3, 2, point3D.getZ() / point3D.getValue(3, 3));
                }
                point3D.setValue(3,3,1);
                SimpleStore.points.set(obj3D.getPointsRefs()[i],point3D);
            }
            } else {
                if (modMatrix != null) {
                    obj3D.matrixMulty(modMatrix);
                }
            }
    }

    private static double[] getPlaneK(Poly3D poly3D){
        if (poly3D.points.length<3)
            return null;

        Point3D point1 = SimpleStore.points.get(poly3D.points[0]);
        Point3D point2 = SimpleStore.points.get(poly3D.points[1]);
        Point3D point3 = SimpleStore.points.get(poly3D.points[2]);

        double A = (point2.getY() - point1.getY()) * (point3.getZ() - point1.getZ()) -
                (point3.getY() - point1.getY()) * (point2.getZ() - point1.getZ());
        double B = - ((point2.getX() - point1.getX()) * (point3.getZ() - point1.getZ()) -
                (point3.getX() - point1.getX()) * (point2.getZ() - point1.getZ()));
        double C = (point2.getX() - point1.getX()) * (point3.getY() - point1.getY()) -
                (point3.getX() - point1.getX()) * (point2.getY() - point1.getY());
        double D = A * point1.getX() + B * point1.getY() + C * point1.getZ();
        return new double[] {A,B,C,-D};
    }

    public static void draw(Graphics2D graphics2D){
        if (SimpleStore.objs == null){
            return;
        }


        center.setX(graphics2D.getClip().getBounds().x +
                (int) (graphics2D.getClip().getBounds().width / 2));
        center.setY(graphics2D.getClip().getBounds().y +
                (int) (graphics2D.getClip().getBounds().height / 2));

        for (int i =0;i<SimpleStore.polys.size();i++){
            double[] k = getPlaneK(SimpleStore.polys.get(i));
            double abss = k[0]*lightV[0]+k[1]*lightV[1]+k[2]*lightV[2];
            double h1 = Math.sqrt(Math.pow(k[0],2)+Math.pow(k[1],2)+Math.pow(k[2],2));
            double h2 = Math.sqrt(Math.pow(lightV[0],2)+Math.pow(lightV[1],2)+Math.pow(lightV[2],2));
            double mod = abss/(h1*h2);
            double R = k[0] * lightV[0] + k[1] * lightV[1] + k[2] * lightV[2] + k[3];
            if (R>0){
                SimpleStore.polys.get(i).bright = mod;
            } else {
                SimpleStore.polys.get(i).bright = 0;
            }
        }

        SimpleStore.visBuf = new ArrayList<>();
        SimpleStore.visBuf.addAll(SimpleStore.points);
        SimpleStore.polyBuf = new ArrayList<>();
        for (Poly3D poly3D : SimpleStore.polys){
            SimpleStore.polyBuf.add(new Poly3D(poly3D));
        }
        for (Obj3D obj3D : SimpleStore.objs) {

            visModification(obj3D);
            try {
                SimpleStore.points.get(11).print();
                SimpleStore.points.get(12).print();
                SimpleStore.points.get(13).print();
            } catch (Exception e){
            }
//          obj3D.draw(graphics2D, objToWinPx=getObjToWinPx());
            if (obj3D.getName().equals("Cords")){
                for (int i = 0; i < obj3D.getPointsRefs().length; i++) {
                    Point3D point3D = SimpleStore.points.get(obj3D.getPointsRefs()[i]);
                    Loc loc1 = Painter.getWinCords(point3D);
                    if (i == 1) {
                        graphics2D.drawString("X", loc1.getX(), loc1.getY());
                    } else if (i == 2) {
                        graphics2D.drawString("Y", loc1.getX(), loc1.getY());
                    } else if (i == 3) {
                        graphics2D.drawString("Z", loc1.getX(), loc1.getY());
                    }
                }
            }
        }

        SimpleStore.polys = NuelSanchAlgorythm.run(SimpleStore.polys);
        for (Obj3D obj3D : SimpleStore.objs) {
            obj3D.draw(graphics2D, objToWinPx = getObjToWinPx());
        }
        SimpleStore.points = SimpleStore.visBuf;
        SimpleStore.polys = SimpleStore.polyBuf;
    }

    public static void  setModMatrix(Matrix modMatrix) {
        setOblique(false);
        setPerspective(false);
        Painter.modMatrix = modMatrix;
    }

    public static Matrix getModMatrix() {
        return modMatrix;
    }

    public static void setOblique(boolean oblique) {
        isOblique = oblique;
        if (isOblique()){
            setPerspective(false);
        }
    }

    public static boolean isOblique() {
        return isOblique;
    }

    public static void setPerspective(boolean perspective) {
        Painter.perspective = perspective;
        if (perspective){
            setOblique(false);
        }
    }

    public static boolean isPerspective() {
        return perspective;
    }
}
