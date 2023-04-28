package 单子428;

import java.util.ArrayList;
import java.util.List;

public class Classes {
    private int department;//所属学院
    private int grade;//年级
    private int id;//班级编号
    private List<Student> students = new ArrayList<>();



    public Classes(){

    }

    public Classes( int grade, int id) {

        this.grade = grade;
        this.id = id;

    }
    public Classes(int department, int grade, int id) {
        this.department = department;
        this.grade = grade;
        this.id = id;
    }

    //添加学生
    public void addStudent(Student student){
        students.add(student);
    }

    //删除学生(按照学号删除)
    public void deleteStudent(String sno){
        students.remove(sno);
    }
    // 根据学号查找学生
    public List<Student> searchStudent(String target){
        List<Student> result = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSno().equals(target) ) {
                result.add( students.get(i));
            }
        }
        return result;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Classes)obj).getId();
    }

    @Override
    public String toString() {
        return "Classes{" +
                "department=" + department +
                ", grade=" + grade +
                ", id=" + id +
                ", students=" + students +
                '}';
    }
}
