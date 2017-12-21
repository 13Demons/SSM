package com.tian.ssm.accounting.mapper;

import com.tian.ssm.accounting.bean.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class AccountMapperTest {

    @Resource
    private AccountMapper accountMapper;

    @Test
    public void findAccount() throws Exception {
        Account account = new Account();
        account.setAccid("1005");
        accountMapper.findAccount(account);
    }

}