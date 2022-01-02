package SimpleParts.TransformMatrix;

import MatrixPack.Matrix;

public class PerspectiveProjection extends Matrix {
    public PerspectiveProjection (double d){
        super(4,4,
                1,0,0,0,
                0,1,0,0,
                0,0,1,-1/d,
                0,0,0,1);
    }
}
