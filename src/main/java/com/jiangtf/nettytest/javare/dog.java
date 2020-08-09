package com.jiangtf.nettytest.javare;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// abstract class a {
//
//
//   static  abstract  class B{
//       //static 定义的内部类属于外部类
//       public int age;
//
//       public B(){
//           System.out.println("-------b构造，司马王晔");
//       }
//
//       public abstract void getme();
//   }
//}
//
//class C extends a.B{
//    public void getme() {
//        System.out.println("-------getme");
//    }
//}
public  class dog implements dgg{
    public static void main(String[] args) {
        dog d=new dog();
        d.getm();

        Map map=new HashMap();
        map.put("name","jtf");

        map.put("age","12");
        map.put("age1","12");
        map.put("age2","12");
        map.put("age3","12");
        map.put("age4","12");
        map.put("age5","12");
        Iterator it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            Object key=entry.getKey();
            Object value=entry.getValue();
            int hashcodes=entry.getKey().hashCode();
            //int index = hash % Entry[].length
            int ids=hashcodes%map.size();
            System.out.println("key:"+key+",value"+value+"hashcodes:;;"+hashcodes+"map.size():"+map.size()+",id:"+ids);
        }
    }
    @Override
    public void getm() {
        System.out.println("22222");
    }



}