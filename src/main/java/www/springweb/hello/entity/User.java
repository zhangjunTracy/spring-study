package www.springweb.hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author:Json 2015年9月30日下午5:11:14
 * 
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "username", nullable = false, length = 32)
    private String username;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @Column
    private String mobile;

    // 乐观锁 会根据版本进行判定 版本号
    @Version
    @Column
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

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

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", mobile=" + mobile + ", version=" + version
                + "]";
    }

}
