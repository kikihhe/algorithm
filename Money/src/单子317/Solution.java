package 单子317;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-17 16:08
 */
public class Solution implements CommandRunner {
    /**
     * N - FutureTask
     */
    private static ConcurrentHashMap<Integer, FutureTask<Void>> map = new ConcurrentHashMap<>();
    /**
     * FutureTask - SlowCalculator
     */
    private static ConcurrentHashMap<FutureTask<Void>, SlowCalculator> map1 = new ConcurrentHashMap<>();
    public Solution() {
    }

    @Override
    public String runCommand(String command) throws InterruptedException {
        String[] commands = command.split(" ");
        if (!check(commands)) {
            return "Invalid command";
        }
        String result = "";
        int N = 0;
        if (commands.length > 1) {
            N = Integer.parseInt(commands[1]);
        }
        switch (commands[0]) {
            case "start" :
                start(N);
                result = "started " + N;
                break;
            case "running" :
                List<Integer> runningTasks = running();
                if (runningTasks.isEmpty()) {
                    result = "no calculations running";
                } else {
                    for (Integer runningTask : runningTasks) {
                        result = result + " " + runningTask;
                    }
                    result = runningTasks.size() + " calculations running: " + result;
                }
                break;
            case "get" :
                result = get(N);
                break;
            case "cancel" :
                cancel(N);
                result = "cancelled " + N;
                break;
            case "finish" :
                finish();
                result = "finished";
                break;
            case "after" :
                int M = Integer.parseInt(commands[2]);
                after(N, M);
                result = M + " will start after " + N;
            case "abort" :
                abort();
                result = "aborted";
                break;
            default:
                return "Invalid command";
        }

        return result;
    }
    public boolean check(String[] str) {
        for (int i = 1; i < str.length; i++) {
            try {
                Integer.parseInt(str[i]);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
    public void start(Integer N) {
        SlowCalculator slowCalculator = new SlowCalculator(N);
        FutureTask<Void> futureTask = new FutureTask<>(slowCalculator, null);
        map.put(N, futureTask);
        map1.put(futureTask, slowCalculator);
        new Thread(futureTask).start();
    }
    // 查看正在运行的任务
    public List<Integer> running() {
        List<Integer> runningTasks = new ArrayList<>();

        for (Map.Entry<Integer, FutureTask<Void>> entry : map.entrySet()) {
            FutureTask<Void> value = entry.getValue();
            if (!value.isDone() && !value.isCancelled()) {
                runningTasks.add(entry.getKey());
            }
        }
        return runningTasks;
    }
    // 获取任务的运行结果
    public String get(Integer N) {
        FutureTask<Void> futureTask = map.get(N);
        if (futureTask.isCancelled()) {
            return "cancelled";
        } else if (!futureTask.isDone()) {
            return "calculating";
        } else {
            SlowCalculator slowCalculator = map1.get(futureTask);
            return "result is " + slowCalculator.getResult();
        }
    }

    public void cancel(Integer N) {
        FutureTask<Void> futureTask = map.get(N);
        if (futureTask == null || futureTask.isCancelled() || futureTask.isDone()) {
            return;
        } else {
            futureTask.cancel(true);
        }
    }
    // 等待所有任务执行结束
    public void finish() {
        for (Map.Entry<Integer, FutureTask<Void>> entry : map.entrySet()) {
            FutureTask<Void> futureTask = entry.getValue();
            try {
                futureTask.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // 让 M 在 N 的后面运行
    public void after(Integer N, Integer M) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // 等待N的结果
            FutureTask<Void> futureTask = map.get(N);
            try {
                futureTask.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // N结束之后开始M的计算
            start(M);
        });
        thread.join();
        thread.start();

    }
    // 停止所有的任务
    public void abort() {
        for (Map.Entry<Integer, FutureTask<Void>> entry : map.entrySet()) {
            FutureTask<Void> futureTask = entry.getValue();
            futureTask.cancel(true);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        while (scanner.hasNext()) {
            String s = solution.runCommand(scanner.nextLine());
            System.out.println(s);
        }
    }
}
