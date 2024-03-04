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
    static int a = 0, b = 0;
    static int x, y;
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        // 添加第10条数据
        list.add(new Object());
        list.add(new Object());
        Collections.synchronizedList(list);
//        Collections.synchronizedMap();


        FutureTask<Integer> task = new FutureTask<>(() -> {

        }, 1);


    }
}
