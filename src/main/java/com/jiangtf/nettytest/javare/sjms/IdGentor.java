package com.jiangtf.nettytest.javare.sjms;

public class IdGentor {
   //饿汉模式
//    private  static  final  IdGentor instance=new IdGentor();
//    private  IdGentor(){}
//    public static  IdGentor getInstance(){
//        return  instance;
//    }

    //懒汉模式
//    private  static   IdGentor instance;
//    private  IdGentor(){}
//    public static synchronized IdGentor getInstance(){
//        if (instance==null){
//            instance=new IdGentor();
//        }
//        return  instance;
//    }
    //双重检测
//    private  static   IdGentor instance;
//    private  IdGentor(){}
//    public static  IdGentor getInstance(){
//        if (instance==null){
//            synchronized (IdGentor.class){
//                if (instance==null){
//                    instance=new IdGentor();
//                }
//            }
//        }
//        return  instance;
//    }
  //静态内部类
    private  IdGentor(){}
    private static  class SingleHolder{
        //这个类是静态内部类，IdGentor被加载的时候
        //.并不会创建SingleHolder实例对象，这有当调用getInstance()方法时，
        // SingleHolder才会被加载，这个时候才会创建instance
        //instance的唯一性，创建过程的安全性，都由jvm来保证，
        private static final IdGentor instance=new IdGentor();
    }
    public static IdGentor getInstance(){
        return  SingleHolder.instance;
    }
}
