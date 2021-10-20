import MatrixPack.Matrix;
import SimpleParts.Point3D;
import SimpleParts.RotateMatrix;
import SimpleParts.SizeMatrix;
import SimpleParts.TransformMatrix;

import java.awt.*;

public class Controller {

    static MainFrame mainFrame = new MainFrame();

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static void transform(double[][] inputV){
        Point3D center = SimpleStore.Points.get(0);
        TransformMatrix toCent = new TransformMatrix(-center.getX(),-center.getY(),-center.getZ());
        TransformMatrix back = new TransformMatrix(center.getX()+inputV[0][0], center.getY()+inputV[0][1],center.getZ()+inputV[0][2] );
        SizeMatrix sizeMatrix = new SizeMatrix(inputV[1][0],inputV[1][1],inputV[1][2]);
        RotateMatrix rotateMatrix = new RotateMatrix(inputV[2][0],inputV[2][1],inputV[2][2]);
        Matrix allMatrix = Matrix.multiplication(sizeMatrix,rotateMatrix);
        for (Point3D point:SimpleStore.Points) {
            point.setValues((Matrix.sum(Matrix.multiplication(Matrix.sum(point,toCent),allMatrix),back)).getValues());
        }
    }

    public static void main(String[] args) {
        SimpleStore.init();
    }
}
