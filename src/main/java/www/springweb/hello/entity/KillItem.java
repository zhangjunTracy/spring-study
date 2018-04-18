package www.springweb.hello.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
// 声明存储过程
@NamedStoredProcedureQuery(name = "executeSeckill", procedureName = "execute_seckill", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "v_id", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "v_kill_product_id", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "v_mobile", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "v_kill_time", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "r_result", type = Integer.class) })
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
