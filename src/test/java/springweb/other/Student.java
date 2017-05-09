package springweb.other;

import java.util.List;

public class Student {

    private String userName;
    private List<String> courses;

    public Student(String userName, List<String> courses) {
        super();
        this.userName = userName;
        this.courses = courses;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

}
