package com.junior.custoemr.service.impl;

import com.junior.custoemr.mapper.customerMapper;
import com.junior.custoemr.model.customer;
import com.junior.custoemr.service.customerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 9:49
 */
@Service
public class customerServiceImpl  implements customerService {
    @Resource
    customerMapper customerMapper;


    @Override
    public List<customer> list() {
        return customerMapper.list();
    }

    @Override
    public customer getId(Integer uid) {
        return customerMapper.getId(uid);
    }
}
