package SimpleParts.TransformMatrix;

import MatrixPack.Matrix;
import SimpleParts.Point3D;

public class ObliqueProjection extends Matrix {
    public static Point3D projection(Point3D point3D, double angle,double l){
        Point3D point3D1 = new Point3D();
        point3D1.setValue(3,0,
                point3D.getX() - point3D.getZ()*Math.cos(Math.toRadians(angle))*l);
        point3D1.setValue(3,1,
                point3D.getY() - point3D.getZ()*Math.sin(Math.toRadians(angle))*l);
        point3D1.setValue(3,2, point3D.getZ());
        return point3D1;
    }
}
