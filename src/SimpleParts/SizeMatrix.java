package SimpleParts;

import MatrixPack.Matrix;

public class SizeMatrix extends Matrix {

    public SizeMatrix(double x, double y, double z){
        super(4,4,
                x, 0, 0, 0,
                0, y, 0, 0,
                0, 0, z, 0,
                0, 0, 0, 1);
    }

}
