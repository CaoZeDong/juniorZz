package com.junior.customer.configuration;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

/**
 * 这是流量守卫配置 nacos 数据源，使用 nacos 进行配置文件修改
 *
 * @author caozedong
 * @version 1.0 Created in 2020/12/12
 */
@Slf4j
@Component
public class SentinelConfiguration implements CommandLineRunner {

    @Value("${spring.application.name}-${spring.profiles.active}-sentinel")
    private String dataId;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.group-id}")
    private String groupId;
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.namespace}")
    private String namespace = "";
    @Value("${spring.cloud.sentinel.datasource.ds1.nacos.server-addr}")
    private String serverAddr;

    @Override
    public void run(String... args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("namespace", namespace);
        properties.setProperty("serverAddr", serverAddr);
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(properties, groupId, dataId,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }

}
