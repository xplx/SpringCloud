package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Created by fangzhipeng on 2017/6/26.
 */
@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    /*
     * 过滤器的类型
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤顺序
     * 它为一个Int 类型的值,值越小,越早执行该过滤器
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示该过滤器是否过滤逻辑，如果为 true ，则执行 run（）方法：如果为 false ，则不执行 run（）方法。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run （）方法写具体的过滤的逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //获取请求URL打印log
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        //获取指定参数
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
            return null;
        }
        log.info("ok");
        return null;
    }
}