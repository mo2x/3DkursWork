public class Matrix {

    private int lines, columns;
    private double values[][];

    Matrix(){
        this(1,1);
    }
    Matrix(int lines, int columns){
        values = new double[lines][columns];
    }
    Matrix(int lines, int columns , double... values){
        if ((lines * columns) != values.length){
            throw new IllegalArgumentException("количество элементов несоответствует количествулиний и колонок");
        }
        this.values = new double[lines][columns];
        for (int i = 0; i < lines; i++)
            for (int j = 0; j < columns; j++){
                this.values[i][j] = values[i*columns+columns];
            }
    }
    Matrix(double[][] values){
        lines = values.length;
        columns = values[0].length;
        this.values = new double[lines][columns];
        for (int i = 0; i < lines; i++)
            System.arraycopy(values[i], 0, this.values[i], 0, lines);
    }


    public double getValue(int column, int line) {
        return values[column][line];
    }
    public void setValue(int column, int line, double value) {
        values[column][line] = value;
    }
    public int getColumns() {
        return columns;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }
    public int getLines() {
        return lines;
    }
    public void setLines(int lines) {
        this.lines = lines;
    }
}
