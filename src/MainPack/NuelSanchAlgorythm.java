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

    private static boolean isPeres(Poly3D poly3D1, Poly3D poly3D2){
        boolean isIn = false;
        boolean isOut = false;
        boolean rez = false;
        int lines = 0;
        for (int i = 0; i < poly3D1.points.length; i++){
            Point3D P1 = SimpleStore.points.get(poly3D1.points[i]);
            Point3D P2 = SimpleStore.points.get(poly3D1.points[(i + 1) % poly3D1.points.length]);
            double b = (P2.getY()-P1.getY())/(P2.getX()- P1.getX());
            double d = b * P1.getX() + P1.getY();
            for (int j = 0; j < poly3D2.points.length; j++){
                Point3D P3 = SimpleStore.points.get(poly3D2.points[j]);
                Point3D P4 = SimpleStore.points.get(poly3D2.points[(j + 1) % poly3D2.points.length]);
                double fT1 = P3.getY() - P3.getX()*b - d;
                double fT2 = P4.getY() - P4.getX()*b - d;
                if ((fT1 > 0) && (fT2 > 0)){
                    isIn = true;
                }
                if ((fT1 < 0) && (fT2 < 0)){
                    isIn = true;
                }
                if (!(((fT1 >= 0) && (fT2 >= 0))||((fT1 <= 0) && (fT2 <= 0)))) {

                    double b2 = (P4.getY() - P3.getY()) / (P4.getX() - P3.getX());
                    double d2 = b * P3.getX() + P3.getY();
                    double fT3 = P1.getY() - P1.getX() * b2 - d2;
                    double fT4 = P2.getY() - P2.getX() * b2 - d2;

                    if (!(((fT3 >= 0) && (fT4 >= 0)) || ((fT3 <= 0) && (fT4 <= 0)))) {
                        lines++;
                    }
                }
            }
        }
        if (lines >= 2){
            rez = true;
        }
        if (isIn ^ isOut){
            rez = true;
        }
        return rez;
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
        double PXmax = Math.max(p1x1,p1x2);
        double PXmin = Math.min(p1x1,p1x2);
        double QXmax = Math.max(p2x1,p2x2);
        double QXmin = Math.min(p2x1,p2x2);
        return (PXmax<=QXmin) || (PXmin>=QXmax);
    }

    private static boolean checkByY(Poly3D p1, Poly3D p2){
        double p1y1 = getMinPointByAxis(p1,'Y').getY();
        double p1y2 = getMaxPointByAxis(p1,'Y').getY();
        double p2y1 = getMinPointByAxis(p2,'Y').getY();
        double p2y2 = getMaxPointByAxis(p2,'Y').getY();
        double PYmax = Math.max(p1y1,p1y2);
        double PYmin = Math.min(p1y1,p1y2);
        double QYmax = Math.max(p2y1,p2y2);
        double QYmin = Math.min(p2y1,p2y2);
        return (PYmax<=QYmin) || (PYmin>=QYmax);
    }

    private static int getPart(double x, double y){
        if (x>=0){
            if (y>0){
                return 1;
            } else {
                return 2;
            }
        } else if (y<0){
            return 3;
        } else {
            return 4;
        }
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
        x /= points.length;
        y /= points.length;
        double[] a = new double[points.length];
        for (int i = 0; i < points.length; i++){
            a[i] = Math.atan2(SimpleStore.points.get(rez[i]).getY() - y,SimpleStore.points.get(rez[i]).getX() - x);
            for (int j = i; j > 0; j--){
                if (a[j] > a[j-1]){
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

    private static boolean checkPar(Poly3D P, Poly3D Q){
        double[] k = getPlaneK(P);
        double[] k1 = getPlaneK(Q);
        for (int i = 0; i < 4; i++){
            if (k[i]!=k1[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean checkByPlace1(Poly3D P, Poly3D Q) {
        double[] k = getPlaneK(P);
        for (int i = 0; i < Q.points.length; i++) {
            Point3D point3D = SimpleStore.points.get(Q.points[i]);
            double R = k[0] * point3D.getX() + k[1] * point3D.getY() + k[2] * point3D.getZ() + k[3];
            if (Math.abs(R) < 0.01){
                R = 0;
            }
            if (R > 0) {
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
            if (R < 0){
                return false;
            }
        }
        return true;
    }

    public static class Pair {
        private static class ChangeObj {

            int num = 0;
            boolean[] chWith;

            ChangeObj(int num, int l) {

                this.num = num;
                chWith = new boolean[l];
            }

        }

        ChangeObj[] data;
        int l;

        public Pair(int l) {
            data = new ChangeObj[l];
            this.l = l;
            for (int i = 0; i < l; i++) {
                ChangeObj changeObj = new ChangeObj(i, l);
                data[i] = changeObj;
            }
        }

        public ChangeObj getByNum(int index) {
            for (int i = 0; i < l; i++) {
                if (data[i].num == index) {
                    return data[i];
                }
            }
            return null;
        }

        public void replase(int f, int s) {
            ChangeObj changeObj = data[f];
            data[f] = data[s];
            data[s] = changeObj;
        }

        public boolean change(int f, int s) {
            if (!data[f].chWith[data[s].num]) {
                data[f].chWith[data[s].num] = true;
                data[s].chWith[data[f].num] = true;
                replase(f, s);
                return false;
            }
            return true;
        }
    }

    public static ArrayList<Poly3D> run(ArrayList<Poly3D> poly3DS){
        ArrayList<Poly3D> changeble = new ArrayList<>();

        int currentNum = 0;

        boolean notBuf;
        buf = new ArrayList<>();
        ArrayList<Poly3D> poly3DSBuf = new ArrayList<>();
        for (int i = 0; i < poly3DS.size(); i++) {
            poly3DSBuf.add(new Poly3D(poly3DS.get(i)));
            poly3DS.get(i).setPoints(sortByClock(poly3DS.get(i).points));
        }
        sortByZ(poly3DS);
        while (poly3DS.size()>1) {
            Pair pair = new Pair(poly3DS.size());
            currentNum = 0;
            int i = 0;
            changeble.clear();
            changeble.addAll(poly3DS);
            notBuf = true;
            Poly3D P = changeble.get(i);
            Poly3D Q = changeble.get(i + 1);
            double maxZ = getMaxPointByAxis(P, 'Z').getZ();
            int j = 1;
            while (notBuf) {

                if (maxZ <= getMinPointByAxis(Q, 'Z').getZ()) {
                    buf.add(P);
                    poly3DS.remove(P);
                    notBuf = false;
                } else {

                    boolean notChange = false;
                    if (checkByX(P, Q)) {
                        notChange = true;
                    } else if (checkByY(P, Q)) {
                        notChange = true;
                    } else if (checkByPlace1(P, Q)) {
                        notChange = true;
                    } else if (checkByPlace2(Q, P)) {
                        notChange = true;
                    } else if (!isPeres(P, Q)) {
                        notChange = true;
                    }
                    if (notChange) {
                        j++;
                        if (i + j >= changeble.size()) {
                            buf.add(P);
                            poly3DS.remove(P);
                            notBuf = false;
                        } else {
                            Q = changeble.get(i + j);
                        }
                    } else {
                        if (pair.change(i,i+j)) {
                            if (P == getMinZPoint(P, Q)) {

                                buf.add(P);
                                poly3DS.remove(P);
                                notBuf = false;
                                continue;
                            }
                        }

                        Poly3D W = changeble.get(i);
                        changeble.set(i, changeble.get(i + j));
                        changeble.set(i + j, W);
                        j = 1;
                        Q = changeble.get(i + j);
                        P = changeble.get(i);
                        maxZ = getMaxPointByAxis(P, 'Z').getZ();
                    }
                }
            }
        }
        if (poly3DS.size()>0)
            buf.add(poly3DS.get(poly3DS.size()-1));
        poly3DS = poly3DSBuf;
        return buf;
    }
}
