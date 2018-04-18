package www.springweb.hello.init;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import www.springweb.hello.entity.User;
import www.springweb.hello.repository.UserRepository;

@Component
public class InitDataSerivce {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initUser() {
        User user = null;
        for (int i = 0; i < 10; i++) {
            user = new User();
            user.setUsername(i + "");
            user.setPassword(DigestUtils.md5Hex(i + ""));
            // userRepository.save(user);
        }

    }

}
