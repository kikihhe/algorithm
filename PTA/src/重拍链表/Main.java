package 重拍链表;

import java.util.*;
class Node {
    public int data;
    public String address;
    public String next;

    public Node() {
    }

    public Node( String address, int data, String next) {
        this.data = data;
        this.address = address;
        this.next = next;
    }

    @Override
    public String toString() {
        return address+" "+data+" "+next;
    }
    public Node(Node node) {
        this.data = node.data;
        this.address = node.address;
        this.next = node.next;
    }
}
public class Main {
    private static List<Node> newList(String head, List<Node> list) {
        List<Node> nodes = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).address.equals(head)) {
                nodes.add(new Node(head, list.get(i).data, list.get(i).next));
                list.remove(i);
                break;
            }
        }
        int index = 0;
        while(list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).address.equals(nodes.get(index).next)) {
                    nodes.add(new Node(list.get(i).address, list.get(i).data, list.get(i).next));
                    list.remove(i);
                    break;
                }
            }
            index++;

        }
        return nodes;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String head = scanner.next();
        int N = scanner.nextInt();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N;i++) {
            Node node = new Node();
            node.address = scanner.next();
            node.data = scanner.nextInt();
            node.next = scanner.next();
            list.add(node);
        }
        // 将链表构建为正常顺序
        List<Node> nodes = newList(head, list);
        // 将正常顺序的链表重新排序.
        List<Node> result = creatList(nodes);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }



    }

    private static List<Node> creatList(List<Node> nodes) {
        List<Node> result = new ArrayList<>(nodes.size());
        int N = nodes.size();
        for (int i = 0; i < N/2; i++) {

                Node nodeH = nodes.get(N - i - 1);
                Node nodeQ = nodes.get(i);

                result.add(new Node(nodeH));
                result.add(new Node(nodeQ));


        }
        if(N%2 == 1) {
            result.add(new Node(nodes.get(N/2)));
        }
        for (int i = 0; i < N - 1; i++) {
            result.get(i).next = result.get(i+1).address;
        }
        result.get(N-1).next = "-1";
        return result;
    }
}