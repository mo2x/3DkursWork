import SimpleParts.Line3D;
import SimpleParts.Point3D;

public class MainObj {

    static Point3D center;

    public static void createObj(double h1, double r, int k, double h2, double a){
        center = new Point3D(0,0,0);
        SimpleStore.Points.add(center);
        //пирамида
        SimpleStore.Points.add(new Point3D(a/2,0,a/2));
        SimpleStore.Points.add(new Point3D(-a/2,0,a/2));
        SimpleStore.Points.add(new Point3D(-a/2,0,-a/2));
        SimpleStore.Points.add(new Point3D(a/2,0,-a/2));
        SimpleStore.Points.add(new Point3D(0,-h2,0));
        for (int i = 1; i < 5; i++){
            SimpleStore.Lines.add(new Line3D(i,5));
            if (i!=1) {
                SimpleStore.Lines.add(new Line3D(i,i-1));
            }else{
                SimpleStore.Lines.add(new Line3D(i,4));
            }
        }
        //конус
        SimpleStore.Points.add(new Point3D(0,h1,0));
        double angle = (360f/k)*(Math.PI/180f);
        for (int i = 0; i<k; i++){
            SimpleStore.Points.add(new Point3D(Math.cos(angle*i)*r,0,Math.sin(angle*i)*r));
            SimpleStore.Lines.add(new Line3D(6,7+i));
            if (i>0){
                SimpleStore.Lines.add(new Line3D(6+i,7+i));
            }
            if (i == k-1){
                SimpleStore.Lines.add(new Line3D(7+i,7));
            }
        }

    }
}
