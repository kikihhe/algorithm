package 单子428;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String sno;//学号
    private String department; // 学院(name)
    private List<Course> courses = new ArrayList<>(); // 课程
    private List<Integer> scores = new ArrayList<>(); // 分数

    public Student() {

    }

    public Student(String name, String sex, String birthday, String address, String sno, String department) {
        super(name, sex, birthday, address);
        this.sno = sno;
        this.department = department;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    // 重写equals，只要学号相等->两个学生相等
    @Override
    public boolean equals(Object obj) {
        Student student = (Student)obj;
        if (student.getSex().equals(sno)) {
            return true;
        } else {
            return false;
        }
    }

    public Student(String sno, String department, List<Course> courses, List<Integer> scores) {
        this.sno = sno;
        this.department = department;
        this.courses = courses;
        this.scores = scores;
    }

    public Student(String name, String sex, String birthday, String address, String sno, String department, List<Course> courses, List<Integer> scores) {
        super(name, sex, birthday, address);
        this.sno = sno;
        this.department = department;
        this.courses = courses;
        this.scores = scores;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", department='" + department + '\'' +
                ", courses=" + courses +
                ", scores=" + scores +
                '}';
    }
}
