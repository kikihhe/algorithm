package com.xiaohe.排序.非稳定排序;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-10 12:32
 */
public class 堆排序 {
    public static class PriorityQueue {
        private int[] arr;

        private int size;

        private int capacity;
        public PriorityQueue(int capacity) {
            this.capacity = capacity;
            this.arr = new int[capacity + 1];
        }

        public void offer(int value) {
            if (size + 1 > capacity) {
                return;
            }
            arr[++size] = value;
            fixUp(size);
        }
        // 拿到堆顶元素
        public int poll() {
            if (size < 1) {
                throw new RuntimeException();
            }
            int temp = arr[1];
            arr[1] = arr[size];
            arr[size] = temp;
            size--;
            fixDown(1);
            return temp;

        }

        /**
         * 把 arr[index] 提到它应该在的位置，它的父亲如果比它大，就让父亲下来
         */
        public void fixUp(int index) {
            while (index > 1) {
                int leftParent = index >> 1;
                if (arr[leftParent] <= arr[index]) {
                    break;
                }
                int temp = arr[index];
                arr[index] = arr[leftParent];
                arr[leftParent] = temp;

                index = leftParent;
            }
        }

        /**
         * 将 arr[index] 放到它应该在的位置，下沉
         */
        public void fixDown(int index) {
            int leftParent;
            while ((leftParent = index << 1) <= size && leftParent > 0) {
                // 找到两个孩子之间小的那个
                int swapIndex = leftParent;
                if (swapIndex < size && arr[leftParent] > arr[leftParent + 1]) {
                    swapIndex = leftParent + 1;
                }
                // 如果两个孩子里面小的都比它大，不需要再移动了
                if (arr[index] <= arr[swapIndex]) {
                    break;
                }
                // 交换
                int temp = arr[index];
                arr[index] = arr[swapIndex];
                arr[swapIndex] = temp;

                index = swapIndex;

            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};

        PriorityQueue queue = new PriorityQueue(arr.length);
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);;
        }
        for (int i = 0; i < arr.length; i++) {
            int poll = queue.poll();
            System.out.println(poll);
        }
    }
}
