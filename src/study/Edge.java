package study;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-11 17:29
 */
public class Edge {
    // 这条边的权重(距离)
    public Integer weight;
    // 边的起点
    public Node from;
    // 边的终点
    public Node to;

    public Edge(Node from, Node to,Integer weight) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
