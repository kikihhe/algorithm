package study;
import java.util.*;

/**
 * @author : 小何
 * @Description : 邻接表实现无向图
 * @date : 2022-10-10 21:33
 */
public class Graph {
    // 图的所有节点，Integer代表点的编号，Node代表具体的点
    public HashMap<Integer, Node> nodes;
    // 图的所有边
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<Edge>();
    }

    /**
     * 新建一个图
     * @param matrix 数据
     * @return
     */
    public static Graph createGraph(Integer[][] matrix) {
        // matrix : matrix[i][0]起点from、
        //          matrix[i][1]终点to、
        //          matrix[i][2]权重weight
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i ++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            // 如果这个起始节点不存在，新建一个
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            // 如果终点不存在，新建一个终点
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            // 将起始点与终点取出，放入线中
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(fromNode, toNode, weight);
            // 在起始点的后继节点中记录终点
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            // 这里只会记录起点到终点的线，不会记录终点到起点的线，因为要使用有向图实现无向图
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }

        return graph;

    }

    /**
     * 依靠队列进行宽度优先遍历
     * @param node
     */
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        // set为队列服务，每一个进入队列的节点都要在set中登记
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur);
            for (Node next: cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    /**
     * 依靠栈进行深度优先遍历
     * @param node
     */
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            ArrayList<Node> nexts = cur.nexts;
            for (Node next: nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
        Integer[] is = new Integer[3];
         queue.toArray(is);
        for (Integer i : is) {
            System.out.println(i);
        }
    }

}
