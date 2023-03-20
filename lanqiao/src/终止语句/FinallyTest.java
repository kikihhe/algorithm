package 终止语句;




public class FinallyTest {
    private static int process() {
        try {
            System.out.println("开始执行try语句");
            int i = 0;
            int a = 0;
            int b = 0;
            int c = 0;
            int ab = 1/0;
            System.out.println("异常处理结束");
            return 3;
        } catch (Exception e) {
            System.out.println("执行");
        } finally {
            System.out.println("开始执行finally语句");
            return 4;
        }
    }


    public static void main(String[] args) {
        System.out.println(process());


    }
}
