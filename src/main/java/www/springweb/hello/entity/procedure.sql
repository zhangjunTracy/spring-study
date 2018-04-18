--生成存储过程
DECLARE insert_count INT DEFAULT 0;
声明变量

update delete  insert 语句改变的行数 并赋值给insert_count
SELECT ROW_COUNT() INTO insert_count;
--

DELIMITER $$
CREATE PROCEDURE `execute_seckill`
    (IN v_id VARCHAR(36),IN v_kill_product_id VARCHAR(36),IN v_mobile VARCHAR(11),IN v_kill_time TIMESTAMP,OUT r_result INT)
    BEGIN
        DECLARE insert_count INT DEFAULT 0;
        
    START TRANSACTION;
    
    INSERT IGNORE INTO kill_item(id,kill_product_id,mobile) VALUES(v_id,v_kill_product_id,v_mobile);
    
    SELECT ROW_COUNT() INTO insert_count;
    
        IF(insert_count = 0) THEN
            ROLLBACK;
            SET r_result = -1;
        ELSEIF(insert_count < 0) THEN
            ROLLBACK;
            SET r_result = -2;
        ELSE
            UPDATE kill_product SET number = number - 1
            WHERE id = v_kill_product_id AND number >= 1 AND end_time > v_kill_time AND start_time < v_kill_time;
            SELECT ROW_COUNT() INTO insert_count;
            IF(insert_count = 0) THEN
                ROLLBACK;
                SET r_result = 0;
            ELSEIF(insert_count < 0) THEN
                ROLLBACK;
                SET r_result = -2;
            ELSE
                COMMIT;
                SET r_result = 1;
            END IF;
        END IF;
    END;
$$
DELIMITER ;

DROP PROCEDURE IF EXISTS execute_seckill
SHOW PROCEDURE STATUS 

UPDATE kill_product SET number = number - 1
            WHERE id = v_kill_product_id AND number >= 1 AND end_time > v_kill_time AND start_time < v_kill_time;
            SELECT ROW_COUNT() INTO insert_count;