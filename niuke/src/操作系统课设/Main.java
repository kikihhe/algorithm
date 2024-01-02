package 操作系统课设;


import java.io.*;
import java.util.*;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-12-30 13:33
 */
public class Main {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * 先进先出页面置换算法
     *
     * @param pages  访问页面的顺序
     * @param memory 现有内存
     * @param n      访问次数
     */
    public static boolean[] FIFO(Queue<Integer> pages, Queue<Integer> memory, int n, int memorySize) {
        // 是否缺页，isPageMiss[i] 代表第i次访问是否缺页
        printTitle(memorySize);
        boolean[] isPageMiss = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 第 i+1 次要访问的页面是哪一个
            Integer poll = pages.poll();
            // 如果当前内存中不存在这个页面, 需要进行替换
            if (!memory.contains(poll)) {
                // 将队列中最前面的替换掉
                if (memory.size() == memorySize) {
                    memory.poll();
                }
                // 将这个页面放入队列尾部
                memory.offer(poll);
                isPageMiss[i] = true;
            }
            printLine(poll, new ArrayList<>(memory), memorySize, isPageMiss[i]);
        }
        return isPageMiss;
    }

    private static void printTitle(int memorySize) {
        String str = "页面序列\t\t";
        for (int i = 1; i <= memorySize; i++) {
            str = str + "页面" + i + "\t\t";
        }
        str = str + "是否缺页";
        System.out.println(str);
    }

    private static void printLine(int page, List<Integer> memory, int memorySize, boolean isPageMiss) {
        String str = page + "\t\t\t";
        for (int i = 0; i < memorySize; i++) {
            if (memory.size() > i) {
                Integer memoryId = memory.get(i);
                str = str + memoryId + "\t\t\t";
            } else {
                str = str + " " + "\t\t\t";
            }
        }

        String isMiss = isPageMiss ? "√" : "×" + "\t\t\t";
        str += isMiss;
        System.out.println(str);
    }

    private static double statistic(String algorithm, boolean[] isPageMiss) {
        int count = 0;
        for (int i = 0; i < isPageMiss.length; i++) {
            if (isPageMiss[i]) {
                count++;
            }
        }
        System.out.println(algorithm + "算法, 页面访问次数: " + isPageMiss.length + ", 缺页次数: " + count + ", " + "缺页率: " + count * 1.0 / isPageMiss.length);
        return count * 1.0 / isPageMiss.length;
    }

    public static boolean[] LRU(Queue<Integer> pages, LinkedHashMap<Integer, Integer> lru, int n, int memorySize) {
        printTitle(memorySize);
        // 是否缺页，isPageMiss[i] 代表第i次访问是否缺页
        boolean[] isPageMiss = new boolean[n];
        for (int i = 0; i < n; i++) {
            Integer poll = pages.poll();
            // 此次访问的元素是否在内存中，如果在，将它提到前面来
            if (lru.containsKey(poll)) {
                lru.get(poll);
            } else {
                // 如果不在，将元素放入，人家会自动删除最近最久未使用
                lru.put(poll, poll);
                isPageMiss[i] = true;
            }
            printLine(poll, new ArrayList<>(lru.keySet()), memorySize, isPageMiss[i]);
        }
        return isPageMiss;
    }

    public static boolean[] Clock(Queue<Integer> pages, ClockQueue clockQueue, int n, int memorySize) {
        printTitle(memorySize);
        // 是否缺页，isPageMiss[i] 代表第i次访问是否缺页
        boolean[] isPageMiss = new boolean[n];
        for (int i = 0; i < n; i++) {
            Integer poll = pages.poll();
            // 如果包含，只需要将其访问位置为1
            // 如果不包含，有两种情况:
            // 1. 现在还没装满，那么直接往里面放就行了
            // 2. 装满了，缺页了，将currentPage修改掉
            if (clockQueue.containsPage(poll)) {
                clockQueue.setConfirm(poll);
            } else {
                if (!clockQueue.containsPage(poll) && clockQueue.size() < memorySize) {
                    clockQueue.addPage(poll);
                } else {
                    clockQueue.putAtCurrent(poll);
                }
                isPageMiss[i] = true;
            }
            printLine(poll, clockQueue.getPages(), memorySize, isPageMiss[i]);
        }
        return isPageMiss;
    }

    public static boolean[] improveClockQueue(Queue<ImproveClockQueue.In> pages, ImproveClockQueue clockQueue, int n, int memorySize) {
        printTitle(memorySize);
        boolean[] isPageMiss = new boolean[n];
        for (int i = 0; i < n; i++) {
            ImproveClockQueue.In poll = pages.poll();
            int pageId = poll.pageId;
            int type = poll.type;
            // 如果包含，根据读/写规则将对应的标志位改变即可。
            // 如果不包含，有两种情况:
            // 1. 现在还没装满，那么直接往里面放就行了
            // 2. 装满了，缺页了，将currentPage修改掉
            if (clockQueue.containsPage(pageId)) {
                clockQueue.setConfirm(pageId, type);
            } else {
                if (clockQueue.size() < memorySize) {
                    clockQueue.addPage(pageId, type);
                } else {
                    clockQueue.setCurrent(pageId, type);
                }
                isPageMiss[i] = true;
            }
            printLine(pageId, clockQueue.getPages(), memorySize, isPageMiss[i]);
        }

        return isPageMiss;
    }

    public static boolean[] OPT(Queue<Integer> pages, List<Integer> memory, int n, int memorySize) {
        printTitle(memorySize);
        // 是否缺页，isPageMiss[i] 代表第i次访问是否缺页
        boolean[] isPageMiss = new boolean[n];
        for (int i = 0; i < n; i++) {
            Integer poll = pages.poll();
            if (!memory.contains(poll)) {
                // 如果现在内存还没有装满，直接放进去
                if (memory.size() < memorySize) {
                    memory.add(poll);
                } else {
                    int index = findIndex(pages, memory);
                    memory.remove(index);
                    memory.add(poll);
                }
                isPageMiss[i] = true;
            }
            printLine(poll, memory, memorySize, isPageMiss[i]);
        }
        return isPageMiss;
    }

    /**
     * 寻找替换目标，返回值为pageId
     *
     * @param pages  剩下的需要访问的页
     * @param memory 内存中含有的页
     */
    private static int findIndex(Queue<Integer> pages, List<Integer> memory) {
        // 剩下的需要访问的页
        List<Integer> next = new ArrayList<>(pages);
        // 内存中含有的页
        List<Integer> tempMemory = new ArrayList<>(memory);
        int index = 0;
        for (int i = 0; i < tempMemory.size(); i++) {
            if (!next.contains(tempMemory.get(i))) {
                return i;
            }
            if (next.contains(tempMemory.get(i))) {
                int flag = next.indexOf(tempMemory.get(i));
                index = Math.max(index, flag);
            }
        }
        return tempMemory.indexOf(next.get(index));

    }

    public static boolean[] LFU(Queue<Integer> pages, LFUCache<Integer, Integer> lfu, int n, int memorySize) {
        printTitle(memorySize);
        // 是否缺页，isPageMiss[i] 代表第i次访问是否缺页
        boolean[] isPageMiss = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 此次要操纵的页
            Integer poll = pages.poll();
            // 如果拿到的为空，说明不存在，可以放进去
            if (lfu.get(poll) == null) {
                lfu.put(poll, poll);
                isPageMiss[i] = true;
            } else {
                // 如果拿到的不为空
            }
            printLine(poll, new ArrayList<>(lfu.getValues().keySet()), memorySize, isPageMiss[i]);
        }
        return isPageMiss;
    }

    public static void main(String[] args) {
        while (true) {
            printAlgorithm();
            int algorithm = scanner.nextInt();
            if (algorithm == 7) return;
            System.out.println("请输入内存块大小: ");
            int memorySize = scanner.nextInt();
            printReadChoice();
            int readChoice = scanner.nextInt();
            printRemind();
            // 读入页面序列号
            Queue<Integer> pagesPre = new LinkedList<>(readPages(readChoice));
            if (pagesPre.size() % 2 != 0) {
                System.out.println("输入格式错误，请检查后重新输入");
                continue;
            }
            int n = pagesPre.size() / 2;
            switch (algorithm) {
                case 0:
                    all(pagesPre, n, memorySize);
                    break;
                case 1:
                    boolean[] opt = OPT(toPages(pagesPre, 1), new ArrayList<>(), n, memorySize);
                    statistic("OPT", opt);
                    break;
                case 2:
                    boolean[] fifo = FIFO(toPages(pagesPre, 2), new LinkedList<>(), n, memorySize);
                    statistic("FIFO", fifo);
                    break;
                case 3:
                    boolean[] lru = LRU(toPages(pagesPre, 3), new LRUCache(memorySize), n, memorySize);
                    statistic("LRU", lru);
                    break;
                case 4:
                    boolean[] lfu = LFU(toPages(pagesPre, 4), new LFUCache<>(memorySize), n, memorySize);
                    statistic("LFU", lfu);
                    break;
                case 5:
                    boolean[] clock = Clock(toPages(pagesPre, 5), new ClockQueue(memorySize), n, memorySize);
                    statistic("Clock", clock);
                    break;
                case 6:
                    boolean[] improveClock = improveClockQueue(toPages(pagesPre, 6), new ImproveClockQueue(memorySize), n, memorySize);
                    statistic("改进Clock", improveClock);
                    break;
            }
        }


    }


    public static void printAlgorithm() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("您想要使用的页面置换算法: ");
        System.out.println("0. 选择全部并对比");
        System.out.println("1. 最佳置换算法 (OPT)");
        System.out.println("2. 先进先出算法 (FIFO)");
        System.out.println("3. 最近最久未使用算法 (LRU)");
        System.out.println("4. 最少使用算法 (LFU)");
        System.out.println("5. 简单Clock算法");
        System.out.println("6. 改进型Clock页面置换算法");
        System.out.println("7. 退出");

        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void printReadChoice() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("请选择页面序列号的输入方式: ");
        System.out.println("1. 控制台输入");
        System.out.println("2. 随机生成");
        System.out.println("3. 文件读取");
        System.out.println("4. 退出");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void printRemind() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-------输入格式: 页面号 + 读/写，0:读，1:写。");
        System.out.println("-------如 : 1 0 2 0 3 0 4 0 1 0 2 0 5 0 4 0 2 0 ，该序列全部页面为读");
        System.out.println("-------如 : 1 0 2 1 3 1 4 0 1 0 2 0 5 0 4 0 2 0 ，该序列的第一个2和第一个3都为写");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static List<Integer> readPages(int readChoice) {
        List<Integer> pages = new ArrayList<>();
        switch (readChoice) {
            case 1:
                pages = readFromConsole();
                break;
            case 2:
                pages = readFromRandom();
                break;
            case 3:
                System.out.println("请输入文件路径: ");
                String filePath = scanner.next();
                pages = readFromFile(filePath);
                break;
        }
        return pages;
    }

    public static List<Integer> readFromConsole() {
        List<Integer> pages = new ArrayList<>();
        scanner.nextLine();
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        for (String s : strings) {
            pages.add(Integer.valueOf(s));
        }
        return pages;
    }

    public static List<Integer> readFromRandom() {
        Random random = new Random(System.currentTimeMillis());
        List<Integer> pages = new ArrayList<>();
        int n = random.nextInt(5) + 5;
        for (int i = 0; i < n; i++) {
            // 生成序列号
            int pageId = random.nextInt(n - 2);
            int type = random.nextInt(2);
            pages.add(pageId);
            pages.add(type);
        }
        System.out.print("生成的序列号为: ");
        pages.forEach(i -> {
            System.out.printf("%d ", i);
        });
        return pages;
    }

    public static List<Integer> readFromFile(String filePath) {
        List<Integer> pages = new ArrayList<>();

        try(Scanner sc = new Scanner(new FileReader(filePath))) {
            while (sc.hasNextLine()) {
                String string = sc.nextLine();
                String[] strings = string.split(" ");
                for (String s : strings) {
                    pages.add(Integer.valueOf(s));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pages;
    }

    /**
     * 根据用户的选择，将输入变成真正的页面
     * 只有改进型分读写。
     *
     * @param queue
     * @param choice
     */
    public static Queue toPages(Queue<Integer> queue, int choice) {
        if (choice == 6) {
            Queue<ImproveClockQueue.In> pages = new LinkedList<>();
            while (!queue.isEmpty()) {
                Integer pageId = queue.poll();
                Integer poll = queue.poll();
                ImproveClockQueue.In in = new ImproveClockQueue.In(pageId, poll);
                pages.offer(in);
            }
            return pages;
        } else {
            Queue<Integer> pages = new LinkedList<>();
            while (!queue.isEmpty()) {
                Integer pageId = queue.poll();
                queue.poll();
                pages.offer(pageId);
            }
            return pages;
        }
    }

    public static void all(Queue pagesPre, int n, int memorySize) {
        boolean[] opt = OPT(toPages(new LinkedList<>(pagesPre), 1), new ArrayList<>(), n, memorySize);
        double opt1 = statistic("OPT", opt);

        boolean[] fifo = FIFO(toPages(new LinkedList<>(pagesPre), 2), new LinkedList<>(), n, memorySize);
        double fifo1 = statistic("FIFO", fifo);

        boolean[] lru = LRU(toPages(new LinkedList<>(pagesPre), 3), new LRUCache(memorySize), n, memorySize);
        double lru1 = statistic("LRU", lru);

        boolean[] lfu = LFU(toPages(new LinkedList<>(pagesPre), 4), new LFUCache<>(memorySize), n, memorySize);
        double lfu1 = statistic("LFU", lfu);

        boolean[] clock = Clock(toPages(new LinkedList<>(pagesPre), 5), new ClockQueue(memorySize), n, memorySize);
        double clock1 = statistic("Clock", clock);

        boolean[] improveClock = improveClockQueue(toPages(new LinkedList<>(pagesPre), 6), new ImproveClockQueue(memorySize), n, memorySize);
        double improveClock1 = statistic("改进Clock", improveClock);


        ArrayList<Algorithm> list = new ArrayList<>();
        list.add(new Algorithm("OPT", opt1));
        list.add(new Algorithm("FIFO", fifo1));
        list.add(new Algorithm("LRU", lru1));
        list.add(new Algorithm("LFU", lfu1));
        list.add(new Algorithm("Clock", clock1));
        list.add(new Algorithm("改进型Clock", improveClock1));
        list.sort(new Comparator<Algorithm>() {
            @Override
            public int compare(Algorithm o1, Algorithm o2) {
                if (o1.a == o2.a) return 0;
                return o1.a > o2.a ? 1 : -1;
            }
        });
        list.forEach(System.out::println);
    }
    static class Algorithm  {
        public String name;
        public double a;

        public Algorithm(String name, double a) {
            this.name = name;
            this.a = a;
        }

        @Override
        public String toString() {
            return "[" + name + ":" + a + "]\n";
        }
    }
}
