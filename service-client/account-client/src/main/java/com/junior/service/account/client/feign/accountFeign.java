package com.junior.service.account.client.feign;

import com.junior.service.account.client.feign.api.accountFeignApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author caozedong
 * @date 2020/12/9 16:32
 */
@FeignClient(value = "account")
public interface accountFeign extends accountFeignApi {


}
