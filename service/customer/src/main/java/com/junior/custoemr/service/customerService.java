package com.junior.custoemr.service;

import com.junior.custoemr.model.customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 9:48
 */

public interface customerService {


    List<customer> list();
    customer getId(@Param(value = "uid")Integer uid);
}
