package com.junior.customer.service;

import com.junior.service.customer.client.dto.customerDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 9:48
 */

public interface customerService {


    List<customerDto> list();
    customerDto getId(@Param(value = "uid") Integer uid);
}
