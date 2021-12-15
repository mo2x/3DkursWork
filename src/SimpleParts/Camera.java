package SimpleParts;

public class Camera{

    private boolean pointProjection = false;
    private Point3D position = new Point3D(0,0,10);

    public Point3D getPosition() {
        return position;
    }

    public void setPosition(Point3D position) {
        this.position = position;
    }

    public boolean isPointProjection(){
        return pointProjection;
    }

    public void setPointProjection(){
        pointProjection = true;
    }

    public void setParallProjection(){
        pointProjection = false;
    }
}
