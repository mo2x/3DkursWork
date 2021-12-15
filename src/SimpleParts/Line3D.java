package SimpleParts;

public class Line3D {
    public int firstPointInList;
    public int secondPointInList;

    public Line3D(int p1, int p2){
        firstPointInList = p1;
        secondPointInList = p2;
    }

    public int getFirstPointInList() {
        return firstPointInList;
    }

    public int getSecondPointInList() {
        return secondPointInList;
    }

    public void setFirstPointInList(int firstPointInList) {
        this.firstPointInList = firstPointInList;
    }

    public void setSecondPointInList(int secondPointInList) {
        this.secondPointInList = secondPointInList;
    }
}
