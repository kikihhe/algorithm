package 单子428;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    // 学院管理端
    public static void menu1(List<Department> departments) {
        System.out.println("-----请选择-----------------------");
        System.out.println("1: 查看所有学院");
        System.out.println("2: 增加学院");
        System.out.println("3: 修改学院信息");
        System.out.println("4: 查看所属班级");
        System.out.println("5: 删除该学院");
        System.out.println("6: 添加班级");
        System.out.println("---------------------------------");
        int n = scanner.nextInt();
        if(n == 1) {
            for (int i = 0; i < departments.size(); i++) {
                System.out.println(departments.get(i));
            }
        } else if(n == 2) {
            System.out.println("请输入 学院号码 学院名称 学院简介:");
            departments.add(new Department(scanner.nextInt(), scanner.next(), scanner.next()));
        } else {
            System.out.println("请输入想要操作的学院的号码: ");
            int no = scanner.nextInt();

            switch (n){
                case 3:
                    departments.remove(new Department(no));
                    System.out.println("请输入 学院名称 学院简介:");
                    departments.add(new Department(no, scanner.next(), scanner.next()));
                    break;
                case 4:
                    for (int i = 0; i < departments.size(); i++) {
                        Department department = departments.get(i);
                        if (department.getId() == no) {
                            List<Classes> classes = department.getClasses();
                            for (int j = 0; j < classes.size(); j++) {
                                System.out.println(classes.get(j));
                            }
                        }
                    }
                case 5:
                    departments.remove(new Department(no));
                    break;
                case 6:
                    System.out.println("请输入 年级 班级编号: ");
                    Classes classes = new Classes(no, scanner.nextInt(), scanner.nextInt());
                    for (int i = 0; i < departments.size(); i++) {
                        Department department = departments.get(i);
                        if (department.getId() == no) {
                             department.getClasses().add(classes);
                        }
                    }
                    break;
            }
        }
    }
    // 班级管理端
    public static void menu2(List<Department> departments) {
        System.out.println("-----请选择-----------------------");
        System.out.println("1: 查看班级所属学生");
        System.out.println("2: 增加学生");
        System.out.println("3: 删除学生");
        System.out.println("4: 删除该班级");
        System.out.println("---------------------------------");
        int n = scanner.nextInt();
        System.out.println("请输入要操作的班级的id: ");
        int no = scanner.nextInt();
        Classes target = null;
        for (int i = 0; i < departments.size(); i++) {
            List<Classes> classes = departments.get(i).getClasses();
            for (int j = 0; j < classes.size(); j++) {
                if(classes.get(j).getId() == no) {
                    target = classes.get(j);
                }
            }
        }
        switch (n){
            case  0:
                System.out.println("请输入班级的基本信息: ");
                break;
            case 1:
                for (int i = 0; i < target.getStudents().size(); i++) {
                    System.out.println(target.getStudents().get(i));
                }
                break;
            case 2:
                System.out.println("请输入学生的基本信息: 姓名、性别、生日、地址、学号、学院");
                Student student = new Student(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
                target.addStudent(student);
                break;

            case 3:
                System.out.println("请输入要删除的学生的学号");
                target.deleteStudent(scanner.next());
                break;
            case 4:
                departments.remove(target);
                break;
        }
    }
    // 学生管理端
    public static void menu3(List<Department> departments) {
        System.out.println("-----请选择-----------------------");
        System.out.println("1: 查询学生信息(输入学号/姓名)");
        System.out.println("2: 添加课程");
        System.out.println("3: 添加成绩");
        System.out.println("4: 成绩查询(请输入课程号/课程名)");
        System.out.println("5: 删除学生");
        System.out.println("---------------------------------");
        int n = scanner.nextInt();
        System.out.println("请输入该学生的学号: ");
        String str = scanner.next();
        Student student = null;
        Classes classes2 = null;
        for (int i = 0; i < departments.size(); i++) {
            List<Classes> classes = departments.get(i).getClasses();
            for (int j = 0; j < classes.size(); j++) {
                Classes classes1 = classes.get(j);
                classes2 = classes1;
                student = classes1.searchStudent(str).get(0);
            }
        }
        switch (n){
            case 1:
                List<Student> result = new ArrayList<>();
                for (int i = 0; i < departments.size(); i++) {
                    List<Classes> classes = departments.get(i).getClasses();
                    for (int j = 0; j < classes.size(); j++) {
                        Classes classes1 = classes.get(j);
                        result.addAll(classes1.searchStudent(str));
                    }
                }

                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i));
                }

                break;
            case 2:

                System.out.println("请输入添加的课程的信息: 课程名称 课程编号 课程学分");
                student.getCourses().add(new Course(scanner.next(), scanner.next(), scanner.next()));
                break;
            case 3:
                System.out.println("请输入成绩: ");
                student.getScores().add(scanner.nextInt());
                break;
            case 4:
                System.out.println("请输入要查询的课程id");
                String id = scanner.next();
                for (int i = 0; i < student.getCourses().size(); i++) {
                    if (student.getCourses().get(i).equals(id)) {
                        System.out.println("该课程成绩为" + student.getScores().get(i));
                    }
                }
                break;
            case 5:
                System.out.println("请输入要删除的学生的学号: ");
                String a = scanner.next();
                classes2.deleteStudent(a);
                break;
        }
    }


    public static void main(String[] args) {
        List<Department> departments = new ArrayList<>();
        while (true) {
            System.out.println("--------欢迎来到学生管理系统---------");
            System.out.println("--------1. 学院管理端 ---------");
            System.out.println("--------2. 班级管理端 ---------");
            System.out.println("--------3. 学生管理端 ---------");
            System.out.println("--------4. 退出 ---------");
            System.out.println("---------------------------------");
            System.out.print("请输入所选业务的数字编号：");
            int n = scanner.nextInt();
            if (n == 4) {
                break;
            }
            switch (n){
                case 1:
                    menu1(departments);
                    break;
                case 2:
                    menu2(departments);
                    break;
                case 3:
                    menu3(departments);
                    break;
            }
        }
        System.out.println("感谢使用!");
    }
}