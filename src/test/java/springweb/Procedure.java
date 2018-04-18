package springweb;

import java.util.Date;

import org.junit.Test;
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

    @Test
    public void test() {

        Integer integer = killItemRepository.explicitlyNamedPlus1inout("1", "10", "13552960783", new Date());

        System.out.println(integer);

    }

}
