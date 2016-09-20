package www.springweb.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import www.springweb.hello.entity.User;

/** 
 * @author:Json 2015年9月30日下午5:24:05 
 *  
 */
public interface UserRepository extends JpaRepository<User, String>{

}
