package www.springweb.hello.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import www.springweb.hello.entity.User;
import www.springweb.hello.repository.UserRepository;
import www.springweb.hello.util.ResponseBodyPayload;

/**
 * @author:Json 2015年9月30日下午5:25:48
 * 
 */
@RequestMapping("/")
@Controller
public class UserController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("test")
    public String test() {
        LOGGER.info("===============================MQ测试");

        // rabbitTemplate.convertAndSend("spring-boot", "Hello from RabbitMQ!");
        // rabbitTemplate.convertAndSend("spring-boot", "111111111",
        // correlationData );
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("1", "1", "1", correlationId);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                // TODO Auto-generated method stub

            }
        });
        // rabbitTemplate.setConfirmCallback(new ConfirmCallback());
        // rabbitTemplate.sendAndReceive(routingKey, message, correlationData);
        // rabbitTemplate.setConfirmCallback();
        return "home";
    }

    @ResponseBody
    @RequestMapping("test1")
    public ResponseBodyPayload test1() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ResponseBodyPayload r = new ResponseBodyPayload();
        List<User> list = new ArrayList<User>();
        User user = null;
        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setUsername("zhangsan" + i);
            user.setPassword("lisi" + i);
            list.add(user);
        }
        r.setSuccess(true);
        r.setSucceResData(list);

        return r;
    }

    @ResponseBody
    @RequestMapping("test2")
    public ResponseBodyPayload test2(@RequestBody List<User> list, String classId) {
        ResponseBodyPayload r = new ResponseBodyPayload();
        System.out.println(list.size() + ">>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + classId);
        r.setSuccess(true);

        return r;

    }

    @ResponseBody
    @RequestMapping("test3")
    public String test3() {
        User user = null;
        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setUsername("zhangsan" + i);
            user.setPassword("lisi" + i);
            userRepository.save(user);
        }
        return "ok";

    }

    @ResponseBody
    @RequestMapping("test4")
    public List<User> test4() {

        return userRepository.findAll();

    }

}
