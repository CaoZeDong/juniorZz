package com.junior.service.customer.client.feign;

import com.junior.service.customer.client.feign.api.customerFeignApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author caozedong
 * @date 2020/12/9 16:32
 */
@FeignClient(value = "customer",url = "127.0.0.1:8003")
public interface customerFeign extends customerFeignApi {


}
