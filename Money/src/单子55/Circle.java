package 单子55;


public class Circle extends Shape{
    // 半径
    private int r;

    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getLength() {
        return  2 * Math.PI * r;
    }

}
