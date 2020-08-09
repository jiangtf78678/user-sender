package com.jiangtf.demo.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import com.jiangtf.demo.entity.UserTtest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class KeyUtil {
    /**
     * @Author jiangtf
     * @Description 主键生成策略类
     * @Date 14:40 2020/3/19
     * @Param []
     * @return java.lang.String
     **/
    public static  String generatorUUID(){
        TimeBasedGenerator timeBasedGenerator= Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        return  timeBasedGenerator.generate().toString();
    }
    public static void main(String[] args) {
        List<UserTtest> lists=new ArrayList<UserTtest>();
//        List list=new ArrayList();
        List listadd=new ArrayList();
        for (int i=0;i<10;i++){
            String str=String.valueOf(i);
            lists=getList(str);
            listadd.addAll(lists);
        }
        for (int i = 0; i < listadd.size(); i++) {

            if (!listadd.get(i).equals("")){
                System.out.println("ALL"+listadd.get(i));
            }

        }


    }
    public static  List<UserTtest> getList(String callid){
        List<UserTtest> reslist=new ArrayList<UserTtest>();
        UserTtest u1=new UserTtest();
        UserTtest u2=new UserTtest();
        UserTtest u3=new UserTtest();
        UserTtest u4=new UserTtest();
        UserTtest u5=new UserTtest();
        UserTtest u6=new UserTtest();

        if (callid.equals("1")){
           u1.setName("姜腾飞");
           u1.setAge(1);
           u2.setName("岳瑞瑞");
           u2.setAge(1);
           u3.setName("人人人");
           u3.setAge(1);
           reslist.add(u1);
           reslist.add(u2);
           reslist.add(u3);
        }
        if (callid.equals("2")){
            u4.setName("图图");
            u4.setAge(88);
            u5.setName("大个");
            u5.setAge(99);
            u6.setName("橙子");
            u6.setAge(100);
            reslist.add(u4);
            reslist.add(u5);
            reslist.add(u6);
        }

        return reslist;
    }


}
