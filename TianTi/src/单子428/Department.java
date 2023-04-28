package 单子428;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-28 10:39
 */
public class Department {
    private int id;
    // 学院名称
    private String name;
    // 学院简介
    private String description;
    // 学院中所有班级
    private List<Classes> classes = new ArrayList<>();

    public Department() {
    }

    public Department(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public Department(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Department that = (Department) o;
        return id == that.id ;
    }
    public void deleteClasses(Classes classes) {
        this.classes.remove(classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, classes);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", classes=" + classes +
                '}';
    }
}
