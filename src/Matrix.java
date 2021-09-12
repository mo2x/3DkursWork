public class Matrix {

    private int lines, columns;
    private double[][] values;

    Matrix(){
        this(1,1);
    }
    Matrix(int lines, int columns){
        this.lines = lines;
        this.columns = columns;
        values = new double[lines][columns];
    }
    Matrix(int lines, int columns , double... values){
        this.lines = lines;
        this.columns = columns;
        if ((lines * columns) != values.length){
            throw new IllegalArgumentException("количество элементов несоответствует количествулиний и колонок");
        }
        this.values = new double[lines][columns];
        for (int i = 0; i < lines; i++)
            if (columns >= 0) System.arraycopy(values, i * columns, this.values[i], 0, columns);
    }
    Matrix(double[][] values){
        lines = values.length;
        columns = values[0].length;
        this.values = new double[lines][columns];
        for (int i = 0; i < lines; i++)
            System.arraycopy(values[i], 0, this.values[i], 0, lines);
    }

    public void Print(){
        for (int i = 0; i<lines; i++)
            for (int j = 0; j<columns; j++)
                System.out.print(values[i][j]);
    }
    public static Matrix multiplication(Matrix matrix1, Matrix matrix2){
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

    public double[][] getValues() {
        return values;
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
