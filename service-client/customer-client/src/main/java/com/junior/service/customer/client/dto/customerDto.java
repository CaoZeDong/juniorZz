package com.junior.service.customer.client.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author caozedong
 * @date 2020/12/9 16:41
 */
@Data
public class customerDto {
    private int id;
    private int uid;
    private BigDecimal money;
}
