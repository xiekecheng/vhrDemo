package com.xiekc.vhr.exception;

// import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.xiekc.vhr.bean.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @description: 全局异常处理
 * @author: Kecheng Xie
 * @since: 2019-11-07 18:12
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据库有关联数据,操作失败");
        }else {
            return RespBean.error("数据库异常,操作失败");
        }

    }
}
