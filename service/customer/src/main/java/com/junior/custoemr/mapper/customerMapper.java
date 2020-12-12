package com.junior.custoemr.mapper;

import com.junior.custoemr.model.customer;
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

    customer getId(@Param(value = "uid")Integer uid);


}
