package 点赞;

import java.util.*;
class A implements Comparable<A> {
    public String name;
    public int count;
    public Set<Integer> set = new HashSet<>();

    public A() {
    }

    public A(String name, int count, Set<Integer> set) {
        this.name = name;
        this.count = count;
        this.set = set;
    }

    @Override
    public int compareTo(A o) {
        if (set.size() != o.set.size()) {
            return set.size() - o.set.size();
        } else {
            return 1;
        }
    }
}


public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int N = scanner.nextInt();
         List<A> list = new ArrayList<>();
         for (int i = 0; i < N; i++) {
             String name = scanner.next();
             int count = scanner.nextInt();
             Set<Integer> set = new HashSet<>();
             for (int j = 0 ; j < N; j++) {
                 set.add(scanner.nextInt());
             }
             list.add(new A(name, count, set));
         }
         list.sort(null);
         if(list.size() < 3) {
             int i = 0;
             for (i = 0; i < list.size(); i++) {
                 System.out.print(list.get(list.size()-1-i).name + " ");
             }
             while(i < 3) {
                 System.out.print("- ");
                 i++;
             }
             System.out.println();
         } else {

         }
//         String[] name = new String[N];
//         int[] count = new int[N];
//         List<Set<Integer>> list = new ArrayList<>();
//         for (int i = 0; i < N; i++) {
//             name[i] = scanner.next();
//             count[i] = scanner.nextInt();
//             Set<Integer> set = list.get(i);
//             for (int j = 0; j < count[i]; j++) {
//                 set.add(scanner.nextInt());
//             }
//         }
        
    }
}