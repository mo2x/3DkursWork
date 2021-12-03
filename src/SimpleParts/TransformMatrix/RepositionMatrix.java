package SimpleParts.TransformMatrix;

import MatrixPack.Matrix;

public class RepositionMatrix extends Matrix {

    public RepositionMatrix(double x, double y, double z){
        super(4,4,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                x, y, z, 0);
    }

}
