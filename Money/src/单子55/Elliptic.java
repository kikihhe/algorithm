package 单子55;


public class Elliptic extends Circle{
    // 长轴
    private int a;
    // 短轴
    private int b;

    public Elliptic(int x, int y) {
        super(x, y);
    }

    // 定义一个方法，计算椭圆的周长
    public  double getLength() {
        // 使用近似公式
        return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }

    // 定义一个方法，计算椭圆的面积
    public  double getArea() {
        // 使用面积公式
        return Math.PI * a * b;
    }
}
