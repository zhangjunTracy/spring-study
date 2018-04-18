package www.springweb.hello.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class KillProduct extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "product_id")
    private String productId;
    /**
     * 秒杀描述信息
     */
    @Column(name = "kill_description")
    private String killDescription;
    /**
     * 库存数量
     */
    @Column(name = "number")
    private String number;
    /**
     * 秒杀开始时间
     */
    @Column(name = "start_time")
    private Date startTime;
    /**
     * 秒杀结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getKillDescription() {
        return killDescription;
    }

    public void setKillDescription(String killDescription) {
        this.killDescription = killDescription;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
