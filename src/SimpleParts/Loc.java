package SimpleParts;

public class Loc {
    double x;
    double y;
    public Loc(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Loc(){
        this(0,0);
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }


    public double getDoubleX() {
        return x;
    }

    public double getDoubleY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
