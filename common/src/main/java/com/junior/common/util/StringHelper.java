package com.junior.common.util;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * The type String helper.
 *
 * @author wangyiwen
 * @version 1.0 Created in 2019-10-10 17:36
 */
public class StringHelper {
    private StringHelper() {
    }

    /**
     * Gets object value.
     *
     * @param obj the obj
     * @return the object value
     */
    public static String getObjectValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * 使用符号分隔集合
     *
     * @param coll    the coll 集合
     * @param delimit the delimit 分隔符
     * @return the string
     */
    public static String collectionToDelimitedString(@Nullable Collection<?> coll, String delimit) {

        return StringUtils.collectionToDelimitedString(coll, delimit);
    }


    /**
     * 逗号分隔的字符串转 List
     *
     * @param commaDelimitedString the comma delimited string
     * @return the list
     */
    public static List<String> commaDelimitedStringToStringList(String commaDelimitedString) {
        return Arrays.asList(StringUtils.commaDelimitedListToStringArray(commaDelimitedString));
    }

}
