package 单子55;


public class Line extends Shape{
    private int x2;
    private int y2;

    public Line(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getLength() {
        double a = Math.abs(x - x2);
        double b = Math.abs(y - y2);

        return Math.sqrt(a * a + b * b);
    }
}
