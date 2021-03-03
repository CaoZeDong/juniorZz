package com.junior.account.mapper;

import com.junior.account.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 10:26
 */
@Mapper
@Component
public interface accountMapper extends ElasticsearchRepository<Account,Long> {

    List<Account> list();

}
