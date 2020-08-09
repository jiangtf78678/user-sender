package com.jiangtf.demo.lisener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFactory implements ApplicationContextAware {
    private  static ApplicationContext ctx=null;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationFactory.ctx==null){
            ApplicationFactory.ctx=ctx;
        }
    }
    /**
     * @Author jiangtf
     * @Description 获取applicationConext
     * @Date 18:13 2020/3/18
     * @Param []
     * @return org.springframework.context.ApplicationContext
     **/
    public static ApplicationContext getApplicationContext(){
            return ctx;
    }
    /**
     * @Author jiangtf
     * @Description 通过Bean获取name
     * @Date 18:15 2020/3/18
     * @Param [name]
     * @return java.lang.Object
     **/
    public  static  Object getBean(String name){
        return  getApplicationContext().getBean(name);
    }

    /**
     * @Author jiangtf
     * @Description 通过class获取bean
     * @Date 18:21 2020/3/18
     * @Param [clazz]
     * @return T
     **/
    public static  <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
    /**
     * @Author jiangtf
     * @Description 通过name,以及Clazz返回指定的Bean
     * @Date 18:22 2020/3/18
     * @Param [name, clazz]
     * @return T
     **/
    public static  <T> T getBean(String name, Class<T> clazz){
        return getApplicationContext().getBean(name,clazz);
    }
}
