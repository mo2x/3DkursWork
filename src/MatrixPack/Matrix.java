package MatrixPack;

import java.util.ArrayList;

public class Matrix {

    private int lines, columns;
    private double[][] values;

    public Matrix(Matrix matrix){
        this(matrix.getLines(),matrix.getColumns());
        for (int i = 0; i< values.length; i++){
            for (int j = 0; j< values[i].length; j++){
                values[i][j] = matrix.getValues()[i][j];
            }
        }
    }
    public Matrix(){
        this(1,1);
    }
    public Matrix(int lines, int columns){
        this(lines,columns,new double[lines * columns]);
    }
    public Matrix(int lines, int columns , double... values){
        this.lines = lines;
        this.columns = columns;
        if ((lines * columns) != values.length){
            throw new IllegalArgumentException("количество элементов несоответствует количествулиний и колонок");
        }
        this.values = new double[lines][columns];
        for (int i = 0; i < lines; i++)
            if (columns >= 0) System.arraycopy(values, i * columns, this.values[i], 0, columns);
    }
    public Matrix(double[][] values){
        lines = values.length;
        columns = values[0].length;
        this.values = new double[lines][columns];
        for (int i = 0; i < lines; i++)
            System.arraycopy(values[i], 0, this.values[i], 0, lines);
    }

    public void Print(){
        for (int i = 0; i<lines; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print(values[i][j]+" ");
            System.out.print("\n");
        }
    }
    public static Matrix multiplication(Matrix matrix1c, Matrix matrix2c){
        Matrix matrix1 = new Matrix(matrix1c);
        Matrix matrix2 = new Matrix(matrix2c);
        if (matrix1.getColumns() != matrix2.getLines()){
            throw new IllegalArgumentException("введены неумножаемые матрицы");
        }
        Matrix rez = new Matrix(matrix1.getLines(), matrix2.getColumns());
        double element;
        for (int i = 0; i < matrix1.getLines(); i++)
            for (int j = 0; j < matrix2.getColumns(); j++){
                element = 0;
                for (int k = 0; k < matrix1.getColumns(); k++){
                    element = element + matrix1.getValue(i, k) * matrix2.getValue(k, j);
                }
                rez.setValue(i,j,element);
            }
        return rez;
    }

    public static Matrix sum(Matrix matrix1, Matrix matrix2){
        if ((matrix1.getColumns() == matrix2.getColumns())&&(matrix1.getLines() == matrix2.getLines())){
            Matrix rez = new Matrix(matrix1.getLines(), matrix1.getColumns());
            for (int i = 0; i < matrix1.getLines(); i++){
                for (int j = 0; j < matrix1.getColumns(); j++){
                    rez.setValue(i,j,matrix1.getValue(i,j)+matrix2.getValue(i,j));
                }
            }
            return rez;
        }else {
            throw new IllegalArgumentException("нельзя сложить данные матрицы");
        }
    }

    public double[][] getValues() {
        return values;
    }
    public void setValues(double[][] values) {
        this.values = values;
    }
    public double getValue(int line, int column) {
        return values[line][column];
    }
    public void setValue(int line, int column, double value) {
        values[line][column] = value;
    }
    public int getColumns() {
        return columns;
    }
    public int getLines() {
        return lines;
    }
}
