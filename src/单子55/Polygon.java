package 单子55;


public abstract class Polygon extends Shape {
    // 多边形的边数
    private int n;

    public Polygon(int x, int y) {
        super(x, y);
    }

    // 获取内角和
    public abstract int getInnerAngles();

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
