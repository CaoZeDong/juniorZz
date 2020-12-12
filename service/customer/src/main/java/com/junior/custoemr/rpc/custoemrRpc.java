package com.junior.custoemr.rpc;

import com.junior.custoemr.model.customer;
import com.junior.custoemr.service.customerService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 9:50
 */
@Slf4j
@RestController
@RequestMapping("/rpc/custoemr")
public class custoemrRpc {
  @Resource(name = "customerServiceImpl")
    customerService customerService;

  @GetMapping(value = "/list", produces = "application/json; charset=utf-8")
    private List<customer>list(){
      return  customerService.list();
    }

  @GetMapping(value = "/getId", produces = "application/json; charset=utf-8")
  private customer getId(@RequestParam(value = "uid")Integer uid){
    return  customerService.getId(uid);
  }

}
