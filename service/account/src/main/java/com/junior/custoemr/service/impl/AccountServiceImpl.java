package com.junior.custoemr.service.impl;

import com.junior.custoemr.mapper.accountMapper;
import com.junior.custoemr.model.account;
import com.junior.custoemr.service.accountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 9:49
 */
@Service
public class AccountServiceImpl implements accountService {
    @Resource
    accountMapper accountMapper;

    @Override
    public List<account> list() {
        List<account>lists=accountMapper.list();
        return lists;
    }
}
