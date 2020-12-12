package com.junior.account.mapper;

import com.junior.account.model.account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 10:26
 */
@Mapper
public interface accountMapper {

    List<account> list();

}
