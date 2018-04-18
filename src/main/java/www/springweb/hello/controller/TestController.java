package www.springweb.hello.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.springweb.hello.repository.KillItemRepository;

@RestController
@RequestMapping("/18")
public class TestController {

    @Autowired
    private KillItemRepository killItemRepository;

    @GetMapping("/test")
    public String test() {

        for (int i = 0; i < 100; i++) {
            Integer plus1inout = killItemRepository.explicitlyNamedPlus1inout(i + "", "10", "13552960783", new Date());
            System.out.println(plus1inout + "========================================" + i);
        }

        return "ok";
    }

}
