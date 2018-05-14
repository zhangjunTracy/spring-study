package springweb;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import www.springweb.hello.repository.KillItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Procedure {

    @Autowired
    private KillItemRepository killItemRepository;

    // @Test
    public void test() {

        Integer integer = killItemRepository.explicitlyNamedPlus1inout("1", "10", "13552960783", new Date());

        System.out.println(integer);

    }

    public static void main(String[] args) {
        // Integer aa = 1;
        // String aa = "Hello";
        // func(aa);
        // System.out.println(aa);
        Person zhangsan = new Person("ZHANG San");
        changePerson(zhangsan);
        zhangsan.printName();
    }

    public static int func(Integer a) {
        a = a + 1;
        return a;
    }

    public static String func(String a) {
        a = "hello";
        return a;
    }

    public static void changePerson(Person person) {
        // person = new Person("LI Si");
        person.changeName("dd");
    }
}

class Person {
    String name = "default";

    public Person(String name) {
        this.name = name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    void printName() {
        System.out.println(this.name);
    }
}
