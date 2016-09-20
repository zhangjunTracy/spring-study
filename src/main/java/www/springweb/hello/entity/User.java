package www.springweb.hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:Json 2015年9月30日下午5:11:14
 * 
 */
@Entity
@Table(name = "json_user")
public class User extends IdEntity {
    @Column(name = "username", nullable = false, length = 32)
    private String username;
    @Column(name = "password", nullable = false, length = 32)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
