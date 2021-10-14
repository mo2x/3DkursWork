import SimpleParts.Line3D;
import SimpleParts.Point3D;

public class MainObj {

    public static void createObj(){
        SimpleStore.Points.add(new Point3D(0,0,0));
        SimpleStore.Points.add(new Point3D(100,100,100));
        SimpleStore.Lines.add(new Line3D(0,1));
    }
}
