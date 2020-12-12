package com.junior.customer.service.impl;

import com.junior.customer.model.customer;
import com.junior.customer.service.customerService;
import com.junior.service.customer.client.dto.customerDto;
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
public class customerServiceImpl  implements customerService {
    @Resource
    com.junior.customer.mapper.customerMapper customerMapper;


    @Override
    public List<customerDto> list() {
        List<customer> list =customerMapper.list();
        List<customerDto> dto=list.stream().map(
                ls->{
                    customerDto dtos=new customerDto();
                    BeanUtils.copyProperties(ls,dtos);
                    return dtos;
                }
        ).collect(Collectors.toList());

        return dto;
    }

    @Override
    public customerDto getId(Integer uid) {
        customer list =customerMapper.getId(uid);
        customerDto dtos=new customerDto();
        BeanUtils.copyProperties(list,dtos);
        return dtos;
    }
}
