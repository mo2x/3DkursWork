import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix testMatrix1;
    private Matrix testMatrix2;
    private Matrix multiplicationAns;

    @Before
    public void setUp() throws Exception{
        testMatrix1 = new Matrix(4,4,
                1,2,3,4,
                       5,6,7,8,
                       9,10,11,12,
                       13,14,15,16);
        testMatrix2 = new Matrix(4,4,
                17,18,19,20,
                        21,22,23,24,
                        25,26,27,28,
                        29,30,31,32);
        multiplicationAns = new Matrix(4,4,
                250, 260, 270, 280,
                618, 644, 670, 696,
                986, 1028, 1070, 1112,
                1354, 1412, 1470, 1528);
    }

    @Test
    public void multiplication() {
        Matrix rez = Matrix.multiplication(testMatrix1,testMatrix2);
        assertArrayEquals(rez.getValues()[0], multiplicationAns.getValues()[0], 0.001);
    }

    @Test
    public void getValue() {
    }

    @Test
    public void setValue() {
    }

    @Test
    public void getColumns() {
    }

    @Test
    public void getLines() {
    }
}