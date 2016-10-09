package www.springweb.hello.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
public class BaseEntityIntegerId implements Serializable {

    private static final long serialVersionUID = -2963618002145345835L;

    @Id
    @GeneratedValue
    private Integer id;

    // @CreatedBy
    @Column(name = "created_by", length = 32)
    private String createdBy;

    @CreatedDate
    @Column(name = "created", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createdDate;

    // @LastModifiedBy
    @Column(name = "modified_by", length = 32)
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "modified", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间'")
    private Date lastModifiedDate;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}