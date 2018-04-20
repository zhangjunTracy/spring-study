package www.springweb.hello.controller;

import java.util.Date;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.springweb.hello.entity.User;
import www.springweb.hello.repository.KillItemRepository;
import www.springweb.hello.repository.UserRepository;

@RestController
@RequestMapping("/18")
public class TestController {

    @Autowired
    private KillItemRepository killItemRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test() {

        for (int i = 0; i < 100; i++) {
            Integer plus1inout = killItemRepository.explicitlyNamedPlus1inout(i + "", "10", "13552960783", new Date());
            System.out.println(plus1inout + "========================================" + i);
        }

        return "ok";
    }

    @GetMapping("/test1")
    public String test1(@RequestParam("m") String m) throws InterruptedException {
        User user = null;
        try {
            user = userRepository.findOne("297e9bca62e1d0f40162e1d0fe0d0000");
            user.setMobile(m);
            Thread.sleep(5000);
            user = userRepository.save(user);
        } catch (StaleObjectStateException e) {

            return e.getMessage();
            // TODO Auto-generated catch block
        }
        return user.toString();

    }

    @GetMapping("/test2")
    public String test2(@RequestParam("m") String m) throws InterruptedException {
        User user = userRepository.findOne("297e9bca62e1d0f40162e1d0fe0d0000");
        user.setMobile(m);
        user = userRepository.save(user);
        return user.toString();

    }

}
