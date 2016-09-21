package www.springweb.hello.repository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import www.springweb.hello.entity.User;

/**
 * 
 * @author Mr.Zhang
 * @Date 2016年9月21日
 * @Email zhangjun150429@qq.com
 */
public interface UserRepository extends JpaRepository<User, String> {

    @Async
    Future<User> findByUsername(String username);

    @Async
    CompletableFuture<User> findById(String id);

    @Async
    ListenableFuture<User> findByMobile(String mobile);

    //返回流
    @Query("select u from User u")
    Stream<User> findAllByCustomQueryAndStream();

}
