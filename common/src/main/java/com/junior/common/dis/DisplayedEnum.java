package com.junior.common.dis;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @author wangyiwen
 * @version 1.0 Created in 2018/7/11 15:04
 */
@SuppressWarnings("unchecked")
public interface DisplayedEnum {
    String DEFAULT_VALUE_NAME = "val";

    String DEFAULT_LABEL_NAME = "des";

    default Integer getValue() {
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_VALUE_NAME);
        if (field == null) {
            return null;
        }
        try {
            field.setAccessible(true);
            return Integer.parseInt(field.get(this).toString());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @JsonValue
    default String getLabel() {
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_LABEL_NAME);
        if (field == null) {
            return null;
        }
        try {
            field.setAccessible(true);
            return field.get(this).toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static <T extends Enum<T>> T valueOfEnum(Class<T> enumClass, Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("DisplayedEnum value should not be null");
        }
        if (enumClass.isAssignableFrom(DisplayedEnum.class)) {
            throw new IllegalArgumentException("illegal DisplayedEnum type");
        }
        T[] enums = enumClass.getEnumConstants();
        for (T t : enums) {
            DisplayedEnum displayedEnum = (DisplayedEnum) t;
            if (displayedEnum.getValue().equals(value)) {
                return (T) displayedEnum;
            }
        }
        throw new IllegalArgumentException("cannot parse integer: " + value + " to " + enumClass.getName());
    }
}
