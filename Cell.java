public class Cell {

    private Point pos;
    private int g;
    private int h;
    private Cell previous;

    public Cell(Point pos, int g, int h, Cell previous) {
        this.pos = pos;
        this.g = g;
        this.h = h;
        this.previous = previous;
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
        return pos.toString() + " F: " + getF();
    }

    public Cell getPrevious() {
        return previous;
    }

}
