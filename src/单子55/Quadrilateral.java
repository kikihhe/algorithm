package 单子55;


public class Quadrilateral extends Polygon {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public Quadrilateral(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3) {
        super(x, y);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    // 定义一个方法，计算两点之间的距离
    public static double distance(int x1, int y1, int x2, int y2) {
        // 使用勾股定理
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }


    // 定义一个方法，计算四边形的周长
    public double getLength() {
        // 计算四条边的长度
        double a = distance(x, y, x1, y1);
        double b = distance(x1, y1, x2, y2);
        double c = distance(x2, y2, x3, y3);
        double d = distance(x3, y3, x, y);
        // 使用周长公式
        return a + b + c + d;
    }

    // 定义一个方法，计算四边形的面积
    public double getArea() {
        double a = distance(x, y, x1, y1);
        double b = distance(x1, y1, x2, y2);
        double c = distance(x2, y2, x3, y3);
        double d = distance(x3, y3, x, y);
        // 计算对角线的长度
        double e = distance(x, y, x2, y2);
        double f = distance(x1, y1, x3, y3);
        //
        return 0.25 * Math.sqrt(4 * e * e * f * f - Math.pow((a * a + c * c - b * b - d * d), 2));
    }

    @Override
    public int getInnerAngles() {
        return 360;
    }


}
