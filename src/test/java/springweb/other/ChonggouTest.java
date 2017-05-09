package springweb.other;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ChonggouTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("数学");
        list.add("语文");
        Student student = new Student("张三", list);
        // 获得学生课程list， 可以直接进行修改和删除 但是student却不知道，这不符合面向对象编程的习惯。
        List<String> list1 = new ArrayList<>();
        list1 = student.getCourses();
        list1.add("dd");
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("数学");
        list.add("语文");
        Student1 student = new Student1("张三", list);
        // 重构后 添加学科会报错 因为返回的是不可更改的集合

        // 只有学科拥有者才可以添加学科
        student.addCourse("ddd");
        List<String> list1 = new ArrayList<>();
        list1 = student.getCourses();
        System.out.println(list1.toString());
    }

}
