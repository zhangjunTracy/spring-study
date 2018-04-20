package www.springweb.hello.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.springweb.hello.entity.User;
import www.springweb.hello.repository.UserRepository;

// 基于redis的redisson 分布式锁
@RestController
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test(@RequestParam("m") String m) {
        System.out.println("开始进入.......................m" + m);
        Config config = new Config();
        // 必须加redis:// 否则报错
        config.useSingleServer().setAddress("redis://192.168.1.250:6379");
        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("myLock");
        lock.lock();
        User user = userRepository.findOne("297e9bca62e1d0f40162e1d0fe0d0000");
        user.setMobile("1355296" + m);
        userRepository.save(user);

        try {
            if (m.equals("tt")) {
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        lock.unlock();
        return "ok";

    }

}
