package com.junior.starters.feign.interceptor;


import com.junior.common.context.BaseContextHandler;

import com.junior.common.util.IpUtil;
import com.junior.common.util.UserAgentUtil;
import com.junior.starters.feign.util.FeignHeaderEnum;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Base context feign request interceptor.
 *
 * @author wangyiwen
 * @version 1.0 Created in 2020/3/3 13:32
 */
@Slf4j
@Component
public class BaseContextFeignRequestInterceptor implements RequestInterceptor {
    /**
     * Called for every request. Add data using methods on the supplied {@link RequestTemplate}.
     *
     * @param requestTemplate requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest httpServletRequest = BaseContextHandler.getHttpServletRequest();
        //如果程序内部调用则为空
        if (httpServletRequest != null) {
            //ip
            String ipAddr = IpUtil.getIpAddr(httpServletRequest);

            String[] ipArray = ipAddr.split(",");
            if (ipArray.length > 0) {
                requestTemplate.header(FeignHeaderEnum.REAL_IP.toString(), ipArray[0]);
            } else {
                //找不到 ip 地址
                requestTemplate.header(FeignHeaderEnum.REAL_IP.toString(), "127.0.0.1");
            }
            requestTemplate.header(FeignHeaderEnum.REAL_USER_AGENT.toString(), UserAgentUtil.getUserAgent(httpServletRequest));
            requestTemplate.header(FeignHeaderEnum.REAL_REQUEST_TIME.toString(), String.valueOf(BaseContextHandler.getRequestTime()));
            requestTemplate.header(FeignHeaderEnum.UID.toString(), String.valueOf(BaseContextHandler.getUid()));
            requestTemplate.header(FeignHeaderEnum.PHONE.toString(), BaseContextHandler.getPhone());
            requestTemplate.header(FeignHeaderEnum.TOKEN.toString(), BaseContextHandler.getToken());
        }
    }
}
