package com.alibaba.boot.dubbo;

import com.alibaba.boot.dubbo.endpoint.DubboEndpoint;
import com.alibaba.boot.dubbo.endpoint.DubboOperationEndpoint;
import com.alibaba.boot.dubbo.health.DubboHealthIndicator;
import com.alibaba.boot.dubbo.metrics.DubboMetrics;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Dubbo common configuration
 *
 * @author xionghui
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(value = {DubboProperties.class, DubboProviderProperties.class})
public class DubboAutoConfiguration {
    @Autowired
    private DubboProperties properties;

    @Autowired
    private DubboProviderProperties dubboProviderProperties;

    @Bean
    @ConditionalOnMissingBean({ApplicationConfig.class})
    public ApplicationConfig dubboApplicationConfig() {
        ApplicationConfig appConfig = new ApplicationConfig();
        appConfig.setName(this.properties.getAppname());
        return appConfig;
    }

    @Bean
    @ConditionalOnMissingBean({ProtocolConfig.class})
    public ProtocolConfig dubboProtocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(this.properties.getProtocol());
        protocolConfig.setPort(this.properties.getPort());
        protocolConfig.setThreads(this.properties.getThreads());
        return protocolConfig;
    }

    @Bean
    @ConditionalOnMissingBean({RegistryConfig.class})
    public RegistryConfig dubboRegistryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(this.properties.getRegistry());
        registryConfig.setGroup(this.properties.getGroup());
        return registryConfig;
    }


    @Bean
    public DubboHealthIndicator dubboHealthIndicator() {
        return new DubboHealthIndicator();
    }

    @Bean
    public DubboEndpoint dubboEndpoint() {
        return new DubboEndpoint();
    }

    @Bean
    public DubboMetrics dubboConsumerMetrics() {
        return new DubboMetrics();
    }


    @Bean
    public DubboOperationEndpoint dubboOperationEndpoint() {
        return new DubboOperationEndpoint();
    }

}
