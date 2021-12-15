package SimpleParts.TransformMatrix;

import MatrixPack.Matrix;

public class PerspectiveProjection extends Matrix {
    public PerspectiveProjection (double d, double p){
        super(4,4,
                1,0,0,0,
                0,1,0,0,
                0,0,1,-1/p,
                0,0,0,1);
    }
}
