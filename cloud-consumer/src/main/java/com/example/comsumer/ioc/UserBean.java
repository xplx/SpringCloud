package com.example.comsumer.ioc;

/**
 * @Description:自定义的组件,让ioc容器扫描带有指定注解的类,将当前类装配到ioc容器中
 * @author:wuxiaopeng
 * @create: 2019-06-04 19:13
 **/
@Component
public class UserBean {

    //自定义的注入注解
    @Autowired
    private Service service;

    public UserBean() {
        System.out.println("UserBean -> instance");
    }

    public void getUser(){
        //接口的方法,如果注入失败,将报空指针异常
        service.test();
        System.out.println("service：注入成功");
    }
}
