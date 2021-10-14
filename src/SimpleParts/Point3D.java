package SimpleParts;

import MatrixPack.Matrix;

public class Point3D extends Matrix {

    public Point3D(){
        super(4,4,
                1, 0, 0, 0,
                       0, 1, 0, 0,
                       0, 0, 1, 0,
                       0, 0, 0, 1);
    }
    public Point3D(double x, double y, double z){
        super(4,4,
                1, 0, 0, 0,
                       0, 1, 0, 0,
                       0, 0, 1, 0,
                       x, y, z, 1);
    }

    public double getX(){
        return getValue(3,0);
    }
    public double getY(){
        return getValue(3,1);
    }
    public double getZ(){
        return getValue(3,2);
    }
}
