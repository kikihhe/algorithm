package 单子428;

public class Course {
    private String cname;//课程名称
    private String id;//课程编号
    private String credit;//课程学分

    public Course(){

    }

    public Course(String cname, String cno, String credit) {
        this.cname = cname;
        this.id = cno;
        this.credit = credit;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                ", cno='" + id + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
