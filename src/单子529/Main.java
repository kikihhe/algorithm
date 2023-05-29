package 单子529;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description
 * @Author 何
 * @Date 2023-05-29 14:37
 * @Version 1.0
 */
class Student {
    String name;
    List<Float> scores = new ArrayList<>();
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            students.add(student);
            System.out.println("请输入第" + (i + 1) + "位学生的姓名");
            String name = scanner.next();
            student.name = name;
            System.out.println("请输入" + name + "的成绩(以空格隔开): ");
            for (int j = 0; j < 5; j++) {
                int score = scanner.nextInt();
                student.scores.add((float)(score*1.0));
            }
            student.scores.sort(null);
        }


        System.out.println("本次比赛的结果如下: ");
        for(int i = 0; i < 5; i++) {
            Student student = students.get(i);
            float sum = 0;
            List<Float> scores = student.scores;
            for (int j = 1; j <= 3; j++) {
                sum += scores.get(j);
            }
            System.out.println("第" + (i+1) +"个参赛者:" + student.name + " : 去掉最高分: "
                    + student.scores.get(4) + ",去掉最低分:" + scores.get(0) + " 平均成绩: " + sum / 5);
        }
    }
}
