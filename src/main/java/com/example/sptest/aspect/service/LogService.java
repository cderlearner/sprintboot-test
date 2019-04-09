package com.example.sptest.aspect.service;

import com.example.sptest.bean.dto.OrderCreateRequest;
import com.example.sptest.bean.dto.OrderCreateResponse;
import com.example.sptest.transaction.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: linjx
 * Date: 2019/4/8
 */
@Service
public class LogService extends LogServiceParent{
    @Autowired
    private LogService self;

    //@LogEvent
    public OrderCreateResponse foo(OrderCreateRequest param) throws Exception{
        //System.out.println(param.toJson());
        System.err.println(this.getClass());
        insertThenRollback(param);
        return OrderCreateResponse.builder().buyDays(1).mobile("+86").status("sucess").build();
    }

    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback(OrderCreateRequest param) throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

}
