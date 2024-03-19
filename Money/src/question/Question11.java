package question;

import java.util.ArrayList;


public class Question11 {
    public static void main(String[] args) {
        School school = new School();

        School.Student s1 = new School.Student("aaa", "aaaa1", 10);
        School.Student s2 = new School.Student("bbb", "bbbb1", 10);
        School.Student s3 = new School.Student("ccc", "cccc1", 10);

        school.students.add(s1);
        school.students.add(s2);
        school.students.add(s3);

        school.display();
    }
}

class School  {
    public ArrayList<Student> students = new ArrayList<>();
    public static class Student {
        public String name;
        public String grade;
        public int age;

        public Student(String name, String grade, int age) {
            this.name = name;
            this.grade = grade;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", grade='" + grade + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public void display() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
