package com.example.sptest.aspect.service;

import com.example.sptest.transaction.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: linjx
 * Date: 2019/4/9
 */
public abstract class LogServiceParent {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    private LogServiceParent self;

    public void execute() throws Exception{
        System.err.println(this.getClass());
        self.logParent();
    }

    @Transactional(rollbackFor = RollbackException.class)
    public void logParent() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('CCC')");
        throw new RollbackException();
    }
}
