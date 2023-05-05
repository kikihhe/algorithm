package 单子55;


// 三角形
public class Triangle extends Polygon {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Triangle(int x, int y, int x1, int y1, int x2, int y2) {
        super(x, y);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // 定义一个方法，计算两点之间的距离
    public static double distance(int x1, int y1, int x2, int y2) {
        // 使用勾股定理
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    // 定义一个方法，计算三角形的周长
    public double getLength() {
        // 计算三条边的长度
        double a = distance(x, y, x1, y1);
        double b = distance(x1, y1, x2, y2);
        double c = distance(x2, y2, x, y);
        // 使用周长公式
        return a + b + c;
    }

    // 定义一个方法，计算三角形的面积
    public double getArea() {
        // 计算三条边的长度
        double a = distance(x, y, x1, y1);
        double b = distance(x1, y1, x2, y2);
        double c = distance(x2, y2, x, y);
        // 使用海伦公式
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // 获取内角和
    @Override
    public int getInnerAngles() {
        return 180;
    }




}
