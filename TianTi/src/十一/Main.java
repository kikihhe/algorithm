package 十一;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-16 14:46
 */
class S {
    Set<Node> set = new HashSet<>();
    public Node getNode(String name) {
        for (Node node : set) {
            if (node.name.equals(name)) {
                return node;
            }
        }
        return null;
    }
    public boolean contains(String name) {
        for (Node node : set) {
            if (node.name.equals(name)) {
                return true;
            }
        }
        return false;
    }
    public boolean contains(Node node1) {
        for (Node node : set) {
            if (node.equals(node1)) {
                return true;
            }
        }
        return false;
    }
    // 将i号老人转到str管理
    public void zhuan(int i, String str) {
        // 遍历所有节点找到这个老人
        for (Node node : set) {
            if (node.elders.contains(i)) {
                node.elders.remove(i);
            }
        }
        Node node = getNode(str);
        node.elders.add(i);

    }
    // 计算某个节点中所有老人的数量
    public int jisuan(String name) {
        Node node = getNode(name);
        int result = node.elders.size();
        for (String str : node.nodes) {
            result += jisuan(str);
        }
        return result;
    }
}
class Node {
    public String name;
    // 此节点管理的老人
    public Set<Integer> elders = new HashSet<>();
    // 此节点的下属节点
    public Set<String> nodes = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (name.equals(((Node)o).name)) {
            return true;
        } else {
            return false;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总结点
        S set = new S();
        // 老人的总数量，序号为: 1 - N
        int N = scanner.nextInt();
        // 归属关系的总数
        int M = scanner.nextInt();

        for (int i = 0; i < M; i++) {
            String A = scanner.next();
            String B = scanner.next();
            // 如果是老人的附属关系
            if (A.charAt(0) - '0' <= N && A.charAt(0) - '0' >= 0) {
                Node node = set.getNode(B);
                // 没有这个节点，创建并把A(老人装进去)
                if (node == null) {
                    node = new Node();
                    node.name = B;
                    node.elders.add(Integer.valueOf(A));
                    set.set.add(node);
                } else {
                    // 有这个节点，把A(老人)装进去
                    node.elders.add(Integer.valueOf(A));
                }
            } else {
                // 如果是节点与节点之间的附属关系
                Node node1 = set.getNode(A);
                Node node2 = set.getNode(B);
                if (node1 == null) {
                    node1 = new Node();
                    node1.name = A;
                    set.set.add(node1);
                }
                if (node2 == null) {
                    node2 = new Node();
                    node2.name = B;
                    set.set.add(node2);
                }
                node2.nodes.add(A);


            }
        }
        // 开始统计
        boolean f = true;
        while (true) {
            String zl = scanner.next();
            // 指令为E, 退出
            if (zl.equals("E")) {
                break;
            }
            // 指令为T, 有老人要入院/转院
            if (zl.equals("T")) {

                int a = scanner.nextInt();
                String str = scanner.next();
                set.zhuan(a, str);
            }
            // 指令为Q, 统计某个节点中的老人数量
            if (zl.equals("Q")) {
                if (!f) {
                    System.out.println();
                }
                f = false;
                String next = scanner.next();
                int jisuan = set.jisuan(next);
                System.out.print(jisuan);
            }


        }

    }
}
