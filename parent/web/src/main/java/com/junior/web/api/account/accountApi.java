package com.junior.web.api.account;

import com.junior.common.msg.Result;
import com.junior.service.account.client.dto.accountDto;
import com.junior.web.api.service.accountService;
import com.junior.web.api.vo.accountVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/11 14:39
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class accountApi {

    @Resource(name = "accountServiceImpl")
    accountService accountService;

    @GetMapping(value = "/list",produces = "application/json; charset=utf-8")
   public Result<List<accountVo>>list(){
       return  Result.success(accountService.list());
   }

}
