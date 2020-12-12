package com.junior.starters.feign.util;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyiwen
 * @version 1.0 Created in 2020/3/3 14:13
 */
@SuppressWarnings("UnusedReturnValue")
public class FeignRequestUtil {
    /**
     * 获取真实IP
     */
    @Nonnull
    public static String getRealIp(HttpServletRequest request) {
        return request.getHeader(FeignHeaderEnum.REAL_IP.toString());
    }

    /**
     * 获取真实UA头
     */
    @Nonnull
    public static String getRealUserAgent(HttpServletRequest request) {
        return request.getHeader(FeignHeaderEnum.REAL_USER_AGENT.toString());
    }

    /**
     * 获取真实请求时间
     */
    @Nonnull
    public static Long getRealRequestTime(HttpServletRequest request) {
        String header = request.getHeader(FeignHeaderEnum.REAL_REQUEST_TIME.toString());
        return Long.valueOf(header);
    }

    /**
     * 获取 uid
     */
    @Nullable
    public static Long getUid(HttpServletRequest request) {
        String uid = request.getHeader(FeignHeaderEnum.UID.toString());
        if (StringUtils.isNotBlank(uid)) {
            return Long.valueOf(uid);
        } else {
            return null;
        }
    }

    /**
     * 获取手机号
     */
    @Nullable
    public static String getPhone(HttpServletRequest request) {
        String phone = request.getHeader(FeignHeaderEnum.PHONE.toString());
        if (StringUtils.isNotBlank(phone)) {
            return phone;
        } else {
            return null;
        }
    }

    /**
     * 获取 token
     */
    @Nullable
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader(FeignHeaderEnum.TOKEN.toString());
        if (StringUtils.isNotBlank(token)) {
            return token;
        } else {
            return null;
        }
    }
}
