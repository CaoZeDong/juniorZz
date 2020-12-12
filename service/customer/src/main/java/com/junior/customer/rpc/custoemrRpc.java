package com.junior.customer.rpc;

import com.junior.common.msg.Result;
import com.junior.service.customer.client.dto.customerDto;
import com.junior.service.customer.client.feign.customerFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/rpc/custoemr")
public class custoemrRpc implements customerFeign {
  @Resource(name = "customerServiceImpl")
  com.junior.customer.service.customerService customerService;

  @Override
  @GetMapping(value = "/list", produces = "application/json; charset=utf-8")
  public Result<List<customerDto>> list() {
    return Result.success(customerService.list());
  }

  @Override
  @GetMapping(value = "/getId", produces = "application/json; charset=utf-8")
  public Result<customerDto> getId(Integer uid) {
    return Result.success(customerService.getId(uid));
  }
}
