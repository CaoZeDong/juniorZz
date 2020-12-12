package com.junior.customer.mapper;

import com.junior.customer.model.customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 10:26
 */
@Mapper
public interface customerMapper {

    List<customer> list();

    customer getId(@Param(value = "uid") Integer uid);


}
