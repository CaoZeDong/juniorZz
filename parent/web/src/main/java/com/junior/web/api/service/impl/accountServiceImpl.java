package com.junior.web.api.service.impl;

import com.junior.service.customer.client.dto.customerDto;
import com.junior.web.api.vo.accountVo;
import com.junior.service.account.client.feign.accountFeign;
import com.junior.service.customer.client.feign.customerFeign;
import com.junior.web.api.service.accountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caozedong
 * @date 2020/12/11 14:42
 */
@Slf4j
@Service
public class accountServiceImpl implements accountService {
    @Resource
    accountFeign accountFeign;
    @Resource
    customerFeign customerFeign;

    @Override
    public List<accountVo> list() {
        List<accountVo> list =accountFeign.list().getData().stream().map(
                   ls->{
                       accountVo vo =new accountVo();
                       BeanUtils.copyProperties(ls,vo);
                       customerDto cusList=customerFeign.getId(ls.getId()).getData();
                       vo.setMoney(cusList.getMoney());
                       return vo;
                   }

        ).collect(Collectors.toList());
        return list;
    }
}
