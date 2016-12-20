package springweb.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import springweb.jdk8.Person;

/**
 * Comparable And Comparator对比
 * 
 * @author Mr.Zhang
 * @Date 2016年12月18日
 * @Email zhangjun150429@qq.com
 */
public class ComparableAndComparator {
    /**
     * Comparable可排序的 若一个类实现了该接口意味着该类支持排序.
     * 如果有一个实现Comparable接口的类的对象的List或数组,则该List 或数组可以通过 Collections.sort或
     * Arrays.sort进行排序.如List<Integer>(Integer String已经默认实现了Comparable接口)
     * 用于一个对象的不同实例去比较.Comparable接口只有一个方法 public int compareTo(T o);返回值<0 =0 >0
     * 
     */
    /**
     * Comparator
     * 是比较器接口.如果要控制某个类的次序而此类本身不支持排序(即没有实现Comparable接口),我们可以建立一个“该类的比较器”
     * 来进行排序.这个“比较器”只需要实现Comparator接口即可.jdk8之后Comparator变成了函数式接口,实现起来更方便.
     */
    // @Test
    public void test() {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(i + new Random().nextInt(20));
        }
        System.out.println(list);
        // 不需要提供额外比较器 因为Integer默认已经实现了Comparable接口
        Collections.sort(list);
        System.out.println(list);
    }

    @Test
    public void test2() {

        List<Person> list = new ArrayList<>();
        Person person = null;
        for (int i = 0; i < 5; i++) {
            person = new Person();
            person.setName("" + i);
            person.setAge(i + new Random().nextInt(20));
            list.add(person);
        }

        System.out.println(list.toString());
        // 因为person并没有实现Comparable接口 所以我们要定义一个比较器 jdk8中lambda的写法
        Collections.sort(list, (a, b) -> a.getAge() - b.getAge());
        System.out.println(list.toString());

    }

}
