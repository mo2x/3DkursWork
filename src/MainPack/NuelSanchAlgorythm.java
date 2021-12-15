package MainPack;

import SimpleParts.Point3D;
import SimpleParts.Poly3D;
import bjects.SimpleStore;

import java.util.ArrayList;
import java.util.Comparator;

public class NuelSanchAlgorythm {
    private static ArrayList<Poly3D> buf = new ArrayList<>();

    private static Poly3D getMinZPoint(Poly3D poly3D1, Poly3D poly3D2){
        int count1 = poly3D1.points.length, count2 = poly3D2.points.length;
        double min1 = SimpleStore.points.get(poly3D1.points[0]).getZ(), min2 = SimpleStore.points.get(poly3D2.points[0]).getZ();
        for (int i = 1; i<count1; i++){
            min1 = Math.min(min1,SimpleStore.points.get(poly3D1.points[i]).getZ());
        }
        for (int i = 1; i < count2; i++){
            min2 = Math.min(min2,SimpleStore.points.get(poly3D2.points[i]).getZ());
        }
        if (min1<min2){
            return poly3D1;
        } else {
            return poly3D2;
        }
    }

    private static int getAxisNum(char axis){
        return switch (axis) {
            case 'X' -> 0;
            case 'Y' -> 1;
            case 'Z' -> 2;
            default -> -1;
        };
    }

    private static Point3D getMinPointByAxis(Poly3D poly3D1, char axis){
        int axisNum = getAxisNum(axis);
        Point3D min = SimpleStore.points.get(poly3D1.points[0]);
        for (int i = 1; i<poly3D1.points.length; i++){
            if (min.getValue(3,axisNum) > SimpleStore.points.get(poly3D1.points[i]).getValue(3,axisNum)){
                min = SimpleStore.points.get(poly3D1.points[i]);
            }
        }
        return min;
    }

    private static Point3D getMaxPointByAxis(Poly3D poly3D1, char axis){
        int axisNum = getAxisNum(axis);
        Point3D max = SimpleStore.points.get(poly3D1.points[0]);
        for (int i = 1; i<poly3D1.points.length; i++){
            if (max.getValue(3,axisNum) < SimpleStore.points.get(poly3D1.points[i]).getValue(3,axisNum)){
                max = SimpleStore.points.get(poly3D1.points[i]);
            }
        }
        return max;
    }

    private static void sortByZ(ArrayList<Poly3D> poly3DS){
        poly3DS.sort(new Comparator<Poly3D>() {
            @Override
            public int compare(Poly3D o1, Poly3D o2) {
                Poly3D min = getMinZPoint(o1,o2);
                if (min==o1) {
                    return -1;
                } else if (min==o2){
                    return 1;
                }
                return 0;
            }
        });
    }

    private static boolean checkByX(Poly3D p1, Poly3D p2){
        double p1x1 = getMinPointByAxis(p1,'X').getX();
        double p1x2 = getMaxPointByAxis(p1,'X').getX();
        double p2x1 = getMinPointByAxis(p2,'X').getX();
        double p2x2 = getMaxPointByAxis(p2,'X').getX();
        if ((p1x1 < p2x1) && (p1x2 > p2x1)){
            return true;
        }
        if ((p2x1 < p1x1) && (p2x2 > p1x1)){
            return true;
        }
        return false;
    }

    private static boolean checkByY(Poly3D p1, Poly3D p2){
        double p1y1 = getMinPointByAxis(p1,'Y').getY();
        double p1y2 = getMaxPointByAxis(p1,'Y').getY();
        double p2y1 = getMinPointByAxis(p2,'Y').getY();
        double p2y2 = getMaxPointByAxis(p2,'Y').getY();
        if ((p1y1 < p2y1) && (p1y2 > p2y1)){
            return true;
        }
        if ((p2y1 < p1y1) && (p2y2 > p1y1)){
            return true;
        }
        return false;
    }

    private static int[] sortByClock(int[] points){
        int[] rez = new int[points.length];
        double x = 0;
        double y = 0;
        for (int i = 0; i < points.length; i++){
            rez[i]=points[i];
            x += SimpleStore.points.get(points[i]).getX();
            y += SimpleStore.points.get(points[i]).getY();
        }
        x /= 3;
        y /= 3;
        double[] a = new double[points.length];
        for (int i = 0; i < points.length; i++){
            a[i] = Math.atan2(SimpleStore.points.get(rez[i]).getX() - x, SimpleStore.points.get(rez[i]).getY() - y);
            for (int j = i; j > 0; j--){
                if (a[j] < a[j-1]){
                    double t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                    int t2 = rez[j];
                    rez[j] = rez[j-1];
                    rez[j-1] = t2;
                }
            }
        }
        return rez;
    }

    private static double[] getPlaneK(Poly3D poly3D){
        if (poly3D.points.length<3)
            return null;
        poly3D.setPoints(sortByClock(poly3D.points));
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

    private static boolean checkByPlace1(Poly3D P, Poly3D Q) {
        double[] k = getPlaneK(P);
        for (int i = 0; i < Q.points.length; i++) {
            Point3D point3D = SimpleStore.points.get(Q.points[i]);
            double R = k[0] * point3D.getX() + k[1] * point3D.getY() + k[2] * point3D.getZ() + k[3];
            if (Math.abs(R) < 0.01){
                R = 0;
            }
            if (R < 0) {
                System.out.println(R);
                return false;
            }
        }
        return true;
    }
    private static boolean checkByPlace2(Poly3D Q, Poly3D P){
        double[] k = getPlaneK(Q);
        for (int i = 0; i < P.points.length; i++){
            Point3D point3D = SimpleStore.points.get(P.points[i]);
            double R = k[0]*point3D.getX() + k[1]*point3D.getY() + k[2]*point3D.getZ() + k[3];
            if (Math.abs(R) < 0.01){
                R = 0;
            }
            if (R > 0){
                System.out.println(R);
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Poly3D> run(ArrayList<Poly3D> poly3DS){
        boolean notBuf;
        buf = new ArrayList<>();
        sortByZ(poly3DS);
        for (int i = 0; i<poly3DS.size()-1; i++){
            notBuf = true;
            Poly3D P = poly3DS.get(i);
            Poly3D Q = poly3DS.get(i+1);
            double maxZ = getMaxPointByAxis(P,'Z').getZ();
            int j = 1;
            while (notBuf) {
                if (maxZ<=getMinPointByAxis(Q,'Z').getZ()){
                    buf.add(P);
                    notBuf = false;
                } else {
                    boolean xCheck = checkByX(P,Q);
                    boolean yCheck = checkByY(P,Q);
                    boolean placeCheck1 = checkByPlace1(P,Q);
                    boolean placeCheck2 = checkByPlace2(Q,P);
                    if (xCheck||yCheck||placeCheck1||placeCheck2){
                        j++;
                        if (i+j>= poly3DS.size()){
                            buf.add(P);
                            notBuf = false;
                        } else {
                            Q = poly3DS.get(i + j);
                        }
                    } else {
                        Poly3D W = poly3DS.get(i);
                        poly3DS.set(i, poly3DS.get(i+j));
                        poly3DS.set(i+j,W);
                        j = 1;
                        i = 0;
                        Q = poly3DS.get(i+j);
                        P = poly3DS.get(i);
                        maxZ = getMaxPointByAxis(P,'Z').getZ();
                        break;
                    }
                }
            }
        }
        if (poly3DS.size()>0)
            buf.add(poly3DS.get(poly3DS.size()-1));
        return buf;
    }
}
