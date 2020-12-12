package com.junior.account.rpc;

import com.junior.common.msg.Result;
import com.junior.account.service.accountService;
import com.junior.service.account.client.dto.accountDto;
import com.junior.service.account.client.feign.api.accountFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class AccountRpc implements accountFeignApi {
  @Resource(name = "accountServiceImpl")
  accountService accountService;


  @Override
  @GetMapping(value = "/list" , produces = "application/json; charset=utf-8")
  public Result<List<accountDto>> list() {
    List<accountDto> list= accountService.list();
    return Result.success(list);
  }
}
