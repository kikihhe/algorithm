package 单子55;


public class Point  extends Shape{

    public Point(int x, int y) {
        super(x, y);
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getLength() {
        return 0;
    }
}
