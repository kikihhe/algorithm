package com.xiaohe.demo.pojo;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-10-02 19:13
 */
public class ShoppingCart {
    @Getter
    private HashMap<String, Integer> items = new HashMap<>();

    private int number;

    public void addItem(String item) {
        Integer count = items.get(item);
        if (count == null) {
            count = new Integer(0);
        }
        count += 1;
        items.put(item, count);
    }

    public int getNumber() {
        int count = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            count += entry.getValue();
        }
        return count;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    public String toString() {
        String result = "";
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String book = entry.getKey();
            Integer count = entry.getValue();
            result += book + " : " + count + "本\n";
        }
        return result;
    }
}
