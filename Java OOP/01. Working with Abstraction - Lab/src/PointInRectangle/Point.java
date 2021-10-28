package PointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean greaterOrEqual(Point a) {
        return this.x >= a.x && this.y >= a.y;
    }

    public boolean lessOrEqual(Point b) {
        return this.x <= b.x && this.y <= b.y;
    }
}
