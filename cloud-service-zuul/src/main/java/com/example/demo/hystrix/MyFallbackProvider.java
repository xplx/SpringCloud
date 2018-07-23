package com.example.demo.hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *  Created by fangzhipeng on 2017/6/28.
 *  在Zuul上配置熔断器
 *  Zuul 作为 Netflix 组件，可以 与 Ribbon 、 Eureka 和 Hystrix 等组件相结合，实现负载均衡、熔断器的功能
 */
@Component
class MyFallbackProvider implements ZuulFallbackProvider {
    /**
     * 用于指定熔断功能应用于哪些路由的服务
     * @return
     */
    @Override
    public String getRoute() {
        //如果需要所有的路由服务都加熔断功能，只需要在 getRoute（）方法上返回川”的匹配符，代码如下：
        // return "eureka-client";
        return "*";
    }


    /**
     * 进入熔断功能时执行的逻辑 。
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("oooops!error, i'm the fallback.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
