package demo;

/**
 * @author : ZJ
 * @date : 18-9-7 上午10:30
 */
public class Student {

    private String name;

    private String no;

    public Student() {
    }

    public String getName() {
        return this.name;
    }

    public String getNo() {
        return this.no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$no = this.getNo();
        final Object other$no = other.getNo();
        if (this$no == null ? other$no != null : !this$no.equals(other$no)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $no = this.getNo();
        result = result * PRIME + ($no == null ? 43 : $no.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Student;
    }

    public String toString() {
        return "Student(name=" + this.getName() + ", no=" + this.getNo() + ")";
    }
}
