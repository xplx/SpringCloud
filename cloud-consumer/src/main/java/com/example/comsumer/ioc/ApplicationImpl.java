package com.example.comsumer.ioc;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:容器实现方法
 * @author:wuxiaopeng
 * @create: 2019-06-04 19:18
 **/
public class ApplicationImpl implements Application  {

    //定义存放所有类对象的集合
    private List<Class<?>> classList = new ArrayList<>();

    //定义存放类的实例对象的集合
    private Map<String,Object> instanceMap = new ConcurrentHashMap<>();


    //无参构造
    public ApplicationImpl() {
    }

    /**
     * 有参构造,通过传入的包路径来实现扫描
     * @param basePackage
     */
    public ApplicationImpl(String basePackage) {
        //扫描包路径，获取添加注解类
        doScan(basePackage);
        //获取扫描包类实例化
        doIoc();
        System.out.println(instanceMap);
        //依赖注入
        doDi();
    }

    /**
     * 实例化对象
     */
    private void doIoc() {
        //首先判断一下当前类集合中是否含有元素
        if (classList == null){
            return;
        }
        //遍历集合
        classList.forEach((clz) ->{
            try {
                //通过类对象,实例化一个对象
                Object instance = clz.newInstance();
                //创建key
                String key = getKeyName(clz.getSimpleName());
                //存放到map集合中
                //如果集合中存在则报错
                if (instanceMap.containsKey(key)){
                    throw new RuntimeException("相同的类名");
                }
                //放入ioc容器中
                instanceMap.put(key,instance);
                //判断当前类是否实现了接口
                Class<?>[] interfaces = clz.getInterfaces();
                for (Class<?> inter : interfaces) {
                    instanceMap.put(inter.getName(),instance);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    //改名,获取一个首字母小写的类名
    private String getKeyName(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }


    //依赖注入
    private void doDi() {
        //首先判断实例对象是否有
        if(instanceMap.size() == 0){
            return;
        }
        //遍历所有的实例对象
        instanceMap.forEach((k,v) -> {
            Object instance = v;
            //注入实体对象
            Object injectionInstance = null;
            //通过反射获取类对象
            Class<?> clz = v.getClass();
            //获取当前类对象的所有声明的字段，这样可以获取注解声明
            Field[] fields = clz.getDeclaredFields();
            //循环遍历所有字段
            for (Field field : fields) {
                //判断字段是否含有@Autowired注解
                if(field.isAnnotationPresent(Autowired.class)){
                    String name = field.getType().getName();
                    injectionInstance = this.instanceMap.get(name);
                }
                // 通过反射注入到该属性中
                field.setAccessible(true);
                try {
                    field.set(instance,injectionInstance);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //包扫描方法
    private void doScan(String basePackage) {
        //获取当前包的位置
        URL resource = this.getClass().getClassLoader().getResource(basePackage.replaceAll("\\.", "/"));
        //创建一个文件对象
        File file = new File(resource.getPath());

        //遍历文件
        File[] fileNames = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File childFile) {
                //判断当前文件是否是一个文件夹
                if (childFile.isDirectory()){

                    //如果是文件夹,递归,获取所有的class文件
                    doScan(basePackage+"."+childFile.getName());
                }else {
                    //判断当前文件是否是一个类文件
                    if (childFile.getName().endsWith(".class")){
                        String classPath = basePackage + "." + childFile.getName().replaceAll("\\.class", "");
                        Class<?> clz = null;
                        try {
                            clz = Class.forName(classPath);
                            //判断是否是有@Component注解的类
                            if (clz.isAnnotationPresent(Component.class)){
                                classList.add(clz);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return false;
            }
        });

    }

    @Override
    public Object getBean(String beanName) {
        return this.instanceMap.get(beanName);
    }
}
