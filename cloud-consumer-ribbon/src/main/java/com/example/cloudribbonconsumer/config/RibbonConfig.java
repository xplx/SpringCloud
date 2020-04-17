package com.example.cloudribbonconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
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
     * 实例检查策略
     * @return
     */
//    @Bean
//    public IPing ribbonPing(){
//        return new PingUrl();
//    }
    /**
     * 负载均衡策略:
     * RandomRule: 随机选择一个server。
     * RoundRobinRule: 轮询选择server。
     * RetryRule: 对选定的负载均衡策略机上重试机制。
     * WeightedResponseTimeRule: 根据响应时间去分配一个weight ，weight越低，被选择的可能性就越低。
     * ClientConfigEnabledRoundRobinRule : 和轮询类似。
     * BestAvailableRule: 选择最小请求数，逐个考察Server，如果Server被tripped了，则忽略，在选择其中ActiveRequestsCount最小的server
     * ZoneAvoidanceRule: 根据server的zone区域和可用性来轮询选择
     * AvailabilityFilteringRule : 过滤掉那些因为一直连接失败的被标记为circuit tripped的后端server，并过滤掉那些高并发的的后端server（active connections 超过配置的阈值） | 使用一个AvailabilityPredicate来包含过滤server的逻辑，其实就就是检查status里记录的各个server的运行状态
     */
    @Bean
    public IRule ribbonRule(){
        return new RoundRobinRule();
    }
}   