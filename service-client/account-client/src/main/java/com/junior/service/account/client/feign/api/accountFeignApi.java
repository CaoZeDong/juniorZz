package com.junior.service.account.client.feign.api;

import com.junior.common.msg.Result;
import com.junior.service.account.client.dto.accountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 16:35
 */
@RequestMapping("/rpc/account")
public interface accountFeignApi {
    @GetMapping(value = "/list" , produces = "application/json; charset=utf-8")
     Result<List<accountDto>> list();
}
