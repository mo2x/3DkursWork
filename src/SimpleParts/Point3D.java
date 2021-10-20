package SimpleParts;

import MatrixPack.Matrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Point3D extends Matrix {

    final int PLACES = 2;

    public Point3D(Matrix matrix){
        super(matrix);
    }
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
        BigDecimal bd = new BigDecimal(Double.toString(getValue(3,0)));
        bd = bd.setScale(PLACES, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public double getY(){
        BigDecimal bd = new BigDecimal(Double.toString(getValue(3,1)));
        bd = bd.setScale(PLACES, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public double getZ(){
        BigDecimal bd = new BigDecimal(Double.toString(getValue(3,2)));
        bd = bd.setScale(PLACES, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
