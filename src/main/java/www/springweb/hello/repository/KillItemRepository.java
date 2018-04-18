package www.springweb.hello.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import www.springweb.hello.entity.KillItem;

public interface KillItemRepository extends JpaRepository<KillItem, String> {

    // 调用存储过程
    @Procedure("execute_seckill")
    Integer explicitlyNamedPlus1inout(String v_id, String v_kill_product_id, String v_mobile, Date v_kill_time);
}
