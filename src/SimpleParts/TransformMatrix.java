package SimpleParts;

import MatrixPack.Matrix;

public class TransformMatrix extends Matrix {

    public TransformMatrix(double x, double y, double z){
        super(4,4,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                x, y, z, 0);
    }

}
