package SimpleParts.TransformMatrix;

import MatrixPack.Matrix;

import static java.lang.Math.toRadians;
import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class AcsonomProjection extends Matrix {

    public AcsonomProjection(double fi, double psi) {
        super(4,4);
        RotateMatrix rotateMatrix1 = new RotateMatrix(0,-psi,0);
        RotateMatrix rotateMatrix2 = new RotateMatrix(fi,0,0);
        Matrix matrix = new Matrix(Matrix.multiplication(rotateMatrix1,rotateMatrix2));
        setValues(matrix.getValues());
    }
}
