package com.junior.custoemr.rpc;

import com.junior.common.msg.Result;
import com.junior.custoemr.model.account;
import com.junior.custoemr.service.accountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 9:50
 */
@Slf4j
@RestController
@RequestMapping("/rpc/account")
public class AccountRpc {
  @Resource(name = "accountServiceImpl")
  accountService accountService;

  @RequestMapping(value = "/list" ,method = RequestMethod.GET)
  public Result<List<account>> list(){
    return  Result.success(accountService.list());
  }



}
