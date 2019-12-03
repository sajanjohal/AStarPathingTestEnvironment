public class Cell {

    private Point pos;
    private int g;
    private int h;

    public Cell(Point pos, int g, int h) {
        this.pos = pos;
        this.g = g;
        this.h = h;
    }

    public void setG(int newG) {
        g = newG;
    }

    public int getG() {
        return g;
    }

    public int getF() {
        return this.g + this.h;
    }

    public Point getPoint() {
        return pos;
    }

    public String toString() {
        return pos.toString() + " Distance from start: " + g + " Hscore: " + h;
    }

}
