package com.alibaba.boot.dubbo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zhanghua on 2018/3/20 0020
 */
@ConfigurationProperties(prefix = "spring.dubbo.provider")
public class DubboProviderProperties {

    private String timeout ;

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
}
