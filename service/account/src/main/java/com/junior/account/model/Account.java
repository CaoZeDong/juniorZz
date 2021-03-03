package com.junior.account.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author caozedong
 * @date 2020/12/9 10:24
 * indexName 数据库
 * type 表名
 */
@Data
@Document(indexName = "junior",type = "Account")
public class Account implements Serializable {
    private int id;
    private String name;
    private String address;
}
