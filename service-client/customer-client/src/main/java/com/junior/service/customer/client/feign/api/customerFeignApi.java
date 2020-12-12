package com.junior.service.customer.client.feign.api;

import com.junior.common.msg.Result;
import com.junior.service.customer.client.dto.customerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * @author caozedong
 * @date 2020/12/9 16:35
 */
@RequestMapping(value = "/rpc/customer")
public interface customerFeignApi {
    @GetMapping(value = "/list", produces = "application/json; charset=utf-8")
     Result<List<customerDto>> list();

    @GetMapping(value = "/getId", produces = "application/json; charset=utf-8")
    Result<customerDto> getId(@Valid @RequestParam(value = "uid")Integer uid);
}
