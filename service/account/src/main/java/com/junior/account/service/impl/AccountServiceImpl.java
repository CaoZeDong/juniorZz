package com.junior.account.service.impl;

import com.junior.account.mapper.accountMapper;
import com.junior.account.model.account;
import com.junior.account.service.accountService;
import com.junior.service.account.client.dto.accountDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caozedong
 * @date 2020/12/9 9:49
 */
@Service
public class AccountServiceImpl implements accountService {
    @Resource
    accountMapper accountMapper;

    @Override
    public List<accountDto> list() {
        List<account>lists=accountMapper.list();
        List<accountDto> dto=lists.stream().map(
                ls -> {
                    accountDto dtos=new accountDto();
                    BeanUtils.copyProperties(ls,dtos);
                    return dtos;
                }
        ).collect(Collectors.toList());

        return dto;
    }
}
