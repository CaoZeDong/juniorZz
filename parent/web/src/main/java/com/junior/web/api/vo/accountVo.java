package com.junior.web.api.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author caozedong
 * @date 2020/12/11 14:05
 */
@Data
public class accountVo {

    private int id;
    private String name;
    private String address;
    private BigDecimal money;
}
