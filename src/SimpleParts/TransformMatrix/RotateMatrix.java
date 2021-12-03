package SimpleParts.TransformMatrix;

import MatrixPack.Matrix;

public class RotateMatrix extends Matrix {

    public RotateMatrix(double x, double y, double z){
        super(4,4);
        double grX = x*(Math.PI/180);
        double grY = y*(Math.PI/180);
        double grZ = z*(Math.PI/180);
        Matrix rotX = new Matrix(4,4,
                1,0,0,0,
                0,Math.cos(grX),Math.sin(grX),0,
                0,-Math.sin(grX),Math.cos(grX),0,
                0,0,0,1);
        Matrix rotY = new Matrix(4,4,
                Math.cos(grY),0,-Math.sin(grY),0,
                0,1,0,0,
                Math.sin(grY),0,Math.cos(grY),0,
                0,0,0,1);
        Matrix rotZ = new Matrix(4,4,
                Math.cos(grZ),Math.sin(grZ),0,0,
                -Math.sin(grZ),Math.cos(grZ),0,0,
                0,0,1,0,
                0,0,0,1);
        Matrix rez;
        rez = Matrix.multiplication(rotX,rotY);
        rez = Matrix.multiplication(rez,rotZ);
        setValues(rez.getValues());
    }
}
