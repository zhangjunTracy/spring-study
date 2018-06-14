package springweb.test;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Demo3 {

    public static void main(String[] args) {

        Person person = new Person(1, "11");

        Person person2 = new Person(1, "22");

        System.out.println(person.equals(person2));
        System.out.println(person.compareTo(person2) == 0);

        SortedSet<Person> set = new TreeSet<>();
        set.add(person);
        set.add(person2);
        System.out.println(set.size());
        System.out.println(set.toString());

        Map<String, String> map = new HashMap<String, String>();
        map.put("dd", "ddd");
        map.put("dd", "dd");
        System.out.println(map.toString());

    }

}
