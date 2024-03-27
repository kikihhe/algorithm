package 集合去重;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-24 18:39
 */
public class Main {
    public static void main(String[] args) {
        // 给定一个 User 集合，根据 User.id 进行去重
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1, "小明"));
        list.add(new User(1, "小亮"));
        list.add(new User(2, "小红"));
        list.add(new User(2, "小兰"));

        List<User> distinct = distinct(list);
        System.out.println(distinct);
    }
    public static List<User> distinct(ArrayList<User> list) {
        HashSet<Integer> set = new HashSet();
        List<User> collect = list.stream().filter(user -> {
            if (set.contains(user.id)) {
                return true;
            } else {
                set.add(user.id);
                return false;
            }
        }).collect(Collectors.toList());
        return collect;
    }
}
