package com.example.comsumer.ioc;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-06-04 19:14
 **/
//使用自定义组件
@Component
public class TestService implements Service {
    public TestService() {
        System.out.println("TestService -> instance");
    }

    @Override
    public void test() {
        System.out.println("Service 接口实现方法");
    }
}
