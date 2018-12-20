package com.example.cloudribbonconsumer.util;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiaopeng
 * @create 2018-07-13 14:09
 * 此时 RestTemplate 就结合了阳Ribbon 开启了负载均衡功能
 **/
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 路由策略:
     * BestAvailableRule 选择最小请求数
     * ClientConfigEnabledRoundRobinRule 轮询
     * RandomRule 随机选择一个server
     * RoundRobinRule 轮询选择server
     * RetryRule 根据轮询的方式重试
     * WeightedResponseTimeRule 根据响应时间去分配一个weight ，weight越低，被选择的可能性就越低
     * ZoneAvoidanceRule 根据server的zone区域和可用性来轮询选择
     */
    @Bean
    public IRule ribbonRule(){
        //负载均衡改为随机。
        return new RetryRule();
    }
}   