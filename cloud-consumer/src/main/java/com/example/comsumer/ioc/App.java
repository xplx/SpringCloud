package com.example.comsumer.ioc;

import com.example.comsumer.server.HelloRemote;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-06-04 19:21
 **/
public class App {
    public static void main( String[] args ) {
        //包路径
        Application app = new ApplicationImpl("com.example.comsumer.ioc");
        //获取在容器中实例化对象
        UserBean userBean = (UserBean) app.getBean("userBean");
        userBean.getUser();
        Map map =new HashMap();
    }
}
