public class Cell {

    private int x;
    private int y;
    private int g;
    private int h;

    public Cell(int x, int y, int g, int h) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
        return new Point(this.x, this.y);
    }
}
