package com.junior.custoemr.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

/**
 * @author caozedong
 * @date 2020/12/9 13:03
 */
@Data
public class customer {
    private int id ;
    private int uid;
    private BigDecimal money;


}
