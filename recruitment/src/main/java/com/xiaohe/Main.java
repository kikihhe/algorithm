package com.xiaohe;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-02-19 18:20
 */
public class Main {
    public static class User {
        @Override
        public int hashCode() {
            return 101;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        HashMap<User, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(new User(), i);
        }

    }
}
