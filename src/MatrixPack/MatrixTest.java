package MatrixPack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix testMatrix1;
    private Matrix testMatrix2;
    private Matrix multiplicationAns;

    @Before
    public void setUp() throws Exception{
        testMatrix1 = new Matrix(3,3,
                2345,765,636,
                1,4543,2345,
                98,-56,13);
        testMatrix2 = new Matrix(3,3,
                4,2245,0,
                687,-976,-987,
                235,78,35);
        multiplicationAns = new Matrix(3,3,
                684395,	4567493,	-732795,
                3672120,	-4248813,	-4401866,
                -35025,	275680,	55727);
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