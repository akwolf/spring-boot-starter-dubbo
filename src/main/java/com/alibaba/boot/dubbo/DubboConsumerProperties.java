package com.alibaba.boot.dubbo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zhanghua on 2018/3/20 0020
 */
@ConfigurationProperties(prefix = "spring.dubbo.consumer")
public class DubboConsumerProperties {

    private String check = "";

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
