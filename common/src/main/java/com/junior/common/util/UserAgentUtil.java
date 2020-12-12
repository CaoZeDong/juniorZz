package com.junior.common.util;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyiwen
 * @version 1.0 Created in 2019-10-22 14:15
 */
public class UserAgentUtil {
    public static final String ANDROID = "Android";
    public static final String IPHONE = "iPhone";
    public static final String NO_DEVICE = "未知设备";


    // 获取用户UA信息
    public static String getUserAgent(HttpServletRequest request) {

        if (null == request) {
            return "";
        }
        return request.getHeader("User-Agent");
    }

    // 获取用户Browser信息
    public static String getBrowser(String ua) {

        if (null == ua) {
            return "";
        }
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        Browser browser = userAgent.getBrowser();
        return browser.toString();
    }

    // 获取用户os信息
    public static String getOS(String ua) {

        if (null == ua) {
            return NO_DEVICE;
        }
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        OperatingSystem os = userAgent.getOperatingSystem();
        return os.toString();
    }

    // 获取移动用户操作系统
    public static String getMobileOS(String userAgent) {
        if (userAgent.contains(ANDROID)) {
            return ANDROID;
        } else if (userAgent.contains(IPHONE)) {
            return IPHONE;
        } else {
            return "others";
        }
    }

    // 获取用户手机型号
    public static String getPhoneModel(String userAgent) {

        if (null == userAgent || "".equals(userAgent)) {
            return NO_DEVICE;
        }

        String OS = UserAgentUtil.getMobileOS(userAgent);
        switch (OS) {
            case ANDROID: {
                String rex = "[()]+";
                String[] str = userAgent.split(rex);
                str = str[1].split("[;]");
                String[] res = null;
                for (String string : str) {
                    if (!string.contains("Build/")) {
                        continue;
                    }
                    res = string.split("Build/");
                }
                return res == null ? "" : res[0].trim();
            }
            case IPHONE: {
                String[] str = userAgent.split("[()]+");
                return "IPHONE" + str[1].split("OS")[1].split("like")[0];
            }
            default:
                return getOS(userAgent);
        }
    }

    public static String getPhoneVersion(String userAgent) {
        if (null == userAgent || "".equals(userAgent)) {
            return "";
        }

        String OS = UserAgentUtil.getMobileOS(userAgent);
        if (OS.equals(ANDROID)) {
            String rex = "[()]+";
            String[] str = userAgent.split(rex);
            str = str[1].split("[;]");
            String[] res = null;
            for (String string : str) {
                if (!string.contains("Android")) {
                    continue;
                }
                res = string.trim().split("Android");
            }
            return res == null ? "" : res[1].trim();
        } else if (OS.equals(IPHONE)) {
            String[] str = userAgent.split("[()]+");
            String res = str[1].split("OS")[1].split("like")[0];
            return res.trim();
        } else {
            return "";
        }
    }
}
