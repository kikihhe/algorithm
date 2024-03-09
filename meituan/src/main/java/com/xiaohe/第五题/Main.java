package com.xiaohe.第五题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-09 10:27
 */
class User {
    public int id;

    public User(int id) {
        this.id = id;
    }

    public List<User> friends = new ArrayList<>();

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public void deleteFriend(User friend) {
        friends.remove(friend);
    }

    public boolean hasFriend(User friend) {
        return friends.contains(friend);
    }

    @Override
    public boolean equals(Object obj) {
        return id == ((User) obj).id;
    }
}

class MyList {
    User[] users = new User[10002];

    public User getUser(int id) {
        return users[id];
    }

    public void addUser(User user) {
        users[user.id] = user;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总人数
        int n = scanner.nextInt();

        // 初始的朋友关系数量
        int m = scanner.nextInt();

        // 发生的事件数量
        int q = scanner.nextInt();

        // 所有的人
        MyList list = new MyList();

        // 朋友关系注册
        for (int i = 0; i < m; i++) {
            int id = scanner.nextInt();
            int friendId = scanner.nextInt();
            User idUser = list.getUser(id);
            User friendUser = list.getUser(friendId);
            if (idUser == null) {
                idUser = new User(id);
                list.addUser(idUser);
            }
            if (friendUser == null) {
                friendUser = new User(friendId);
                list.addUser(friendUser);
            }

            idUser.addFriend(friendUser);
            friendUser.addFriend(idUser);

        }

        // 开始查询
        for (int i = 0; i < q; i++) {
            // 操作
            int op = scanner.nextInt();
            // 能否认识的两个人
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            boolean success = false;
            if (op == 1) {
                forgetFriend(u, v, list);
            } else {
                success = findFriend(u, v, list);
                System.out.println(success ? "Yes" : "No");
            }
        }
    }

    private static boolean used[] = new boolean[10005];

    // 介绍
    private static boolean findFriend(int u, int v, MyList list) {
        User user1 = list.getUser(u);
        if (user1 == null) return false;
        List<User> friends = user1.friends;
        if (friends.contains(new User(v))) {
            return true;
        }
        if (used[u]) {
            return false;
        }
        boolean success = false;
        for (User user : friends) {
            if (used[user.id]) {
                continue;
            }
            used[user.id] = true;
            success |= findFriend(user.id, v, list);
            used[user.id] = false;
            if (success) return success;
        }
        return success;
    }

    // id 为 u 和 v 的人互相淡忘
    private static boolean forgetFriend(int u, int v, MyList list) {
        User uUser = list.getUser(u);
        User vUser = list.getUser(v);
        // 如果有朋友关系就可以淡忘
        if (vUser.hasFriend(uUser) && uUser.hasFriend(vUser)) {
            vUser.deleteFriend(uUser);
            uUser.deleteFriend(vUser);
            return true;
        } else {
            return false;
        }
    }
}
