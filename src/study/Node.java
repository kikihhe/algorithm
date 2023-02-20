package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的节点
 */
public class Node {
    // 点的值
    public Integer value;
    // 有几个点指向这个点
    public Integer in;
    // 这个点指向几个点
    public Integer out;
    // 这个点指向的所有后继节点
    public ArrayList<Node> nexts;
    // 这个点拥有的所有边
    public ArrayList<Edge> edges;

    public Node(Integer value) {
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<Edge>();
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public ArrayList<Node> getNexts() {
        return nexts;
    }

    public void setNexts(ArrayList<Node> nexts) {
        this.nexts = nexts;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
}
