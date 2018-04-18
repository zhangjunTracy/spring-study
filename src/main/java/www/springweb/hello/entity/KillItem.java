package www.springweb.hello.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class KillItem extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "kill_product_id")
    private String killProductId;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "kill_time")
    private Date killTime;

    public String getKillProductId() {
        return killProductId;
    }

    public void setKillProductId(String killProductId) {
        this.killProductId = killProductId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getKillTime() {
        return killTime;
    }

    public void setKillTime(Date killTime) {
        this.killTime = killTime;
    }

}
