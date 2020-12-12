package com.junior.common.context;

import com.junior.common.util.DateUtil;
import com.junior.common.util.StringHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.core.io.buffer.DefaultDataBufferFactory.DEFAULT_INITIAL_CAPACITY;

/**
 * @author wangyiwen
 */
public class BaseContextHandler {
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_PHONE = "currentPhone";
    public static final String CONTEXT_KEY_TOKEN = "currentUserToken";
    public static final String HTTP_SERVLET_REQUEST = "httpServletRequest";
    public static final String HTTP_SERVLET_RESPONSE = "httpServletResponse";
    public static final String REQUEST_TIME = "request_time";

    public static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(DEFAULT_INITIAL_CAPACITY);
            THREAD_LOCAL.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(DEFAULT_INITIAL_CAPACITY);
            THREAD_LOCAL.set(map);
        }
        return map.get(key);
    }

    public static Long getUid() {
        Object value = get(CONTEXT_KEY_USER_ID);
        if (value != null) {
            return Long.valueOf(returnObjectValue(value));
        } else {
            return null;
        }
    }

    public static String getPhone() {
        Object value = get(CONTEXT_KEY_PHONE);
        return returnObjectValue(value);
    }

    public static String getToken() {
        Object value = get(CONTEXT_KEY_TOKEN);
        return StringHelper.getObjectValue(value);
    }

    public static void setRequestTime() {
        //存入当前时间
        set(REQUEST_TIME, DateUtil.now());
    }

    public static Long getRequestTime() {
        return (Long) get(REQUEST_TIME);
    }

    public static void setToken(String token) {
        set(CONTEXT_KEY_TOKEN, token);
    }

    public static void setHttpServletRequest(HttpServletRequest request) {
        set(HTTP_SERVLET_REQUEST, request);
    }

    public static HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) get(HTTP_SERVLET_REQUEST);
    }

    public static void setHttpServletResponse(HttpServletResponse response) {
        set(HTTP_SERVLET_RESPONSE, response);
    }

    public static HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse) get(HTTP_SERVLET_RESPONSE);
    }

    public static void setUid(String userId) {
        set(CONTEXT_KEY_USER_ID, userId);
    }

    public static void setPhone(String phone) {
        set(CONTEXT_KEY_PHONE, phone);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
