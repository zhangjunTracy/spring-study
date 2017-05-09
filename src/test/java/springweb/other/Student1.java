package springweb.other;

import java.util.Collections;
import java.util.List;

/**
 * 在《重构——改善既有代码的设计》一书中，有一种重构手法叫Encapsulate Collection ，(封装集合)， 常用到的做法：
 * 
 * （1）加入为集合添加/移除元素的函数
 * 
 * （2）将保存的集合的字段初始化一个空的集合
 * 
 * @author Json
 *
 */
public class Student1 {

    private String userName;
    private List<String> courses;

    public Student1(String userName, List<String> courses) {
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

    public void addCourse(String course) {
        courses.add(course);
    }

    public boolean removeCourse(String course) {
        return courses.remove(courses);

    }

    public List<String> getCourses() {
        // 返回不可改变的集合
        return Collections.unmodifiableList(courses);
    }
}
