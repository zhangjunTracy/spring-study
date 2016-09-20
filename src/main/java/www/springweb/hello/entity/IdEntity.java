package www.springweb.hello.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/** 
 * @author:Json 2015年9月30日下午5:12:37 
 *  
 */
@MappedSuperclass
public abstract class IdEntity {	
	@Id
	//jpa的主键生成器的名称，属性通常和ORM框架相关,例如,Hibernate可以指定uuid等主键生成方式. 
    @GeneratedValue(generator = "sys-uuid")
	//自定义主键生成策略，由@GenericGenerator实现。
	//hibernate在JPA的基础上进行了扩展，可以用一下方式引入hibernate独有的主键生成策略，就是通过@GenericGenerator加入的。
    @GenericGenerator(name = "sys-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;

    // 审计: 创建者
    @Column(name = "created_by", updatable = false, length = 32)
    private String createdBy;

    // 审计: 创建时间
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    // 审计: 最后修改者
    @Column(name = "last_modified_by", length = 32)
    private String lastModifiedBy;

    // 审计: 最后修改时间
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public void setCreatedDate(Date createdDate) {
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

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
    
    

}
