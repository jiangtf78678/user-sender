package com.jiangtf.demo.utils;


/*
* redis工具类
* */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
public class RediesService {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * @Author jiangtf
     * @Description  写入缓存
     * @Date 16:01 2020/6/2
     * @Param [key, value]
     * @return boolean
     **/
    public boolean set(final String key,Object value){
        boolean result=false;
        try{
           ValueOperations<Serializable,Object> operations =redisTemplate.opsForValue();
            operations.set(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    /**
     * @Author jiangtf
     * @Description 写入缓存设置失效时间
     * @Date 16:01 2020/6/2
     * @Param [key, value, expireTime]
     * @return boolean
     **/
      public  boolean setEx(final String key,Object value,Long expireTime){
          boolean result=false;
          try{
              ValueOperations<Serializable,Object> operations =redisTemplate.opsForValue();
              operations.set(key,value);
              redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
              result=true;
          }catch (Exception e){
              e.printStackTrace();
          }
          return  result;
      }

      /**
       * @Author jiangtf
       * @Description 判断缓存中是否有对应的value
       * @Date 16:03 2020/6/2
       * @Param [key]
       * @return boolean
       **/
      public boolean exists(final String key){
          return  redisTemplate.hasKey(key);
      }


      /**
       * @Author jiangtf
       * @Description 读取缓存
       * @Date 16:04 2020/6/2
       * @Param [key]
       * @return java.lang.Object
       **/
      public Object get(final String key){
          Object result=null;
          ValueOperations<Serializable,Object> operations =redisTemplate.opsForValue();
          result=operations.get(key);
          return  result;
      }
      /**
       * @Author jiangtf
       * @Description 删除对应的vaule
       * @Date 16:05 2020/6/2
       * @Param [key]
       * @return boolean
       **/
      public boolean remove(final String key){
          if (exists(key)){
              Boolean delete=redisTemplate.delete(key);
              return  delete;
          }
          return  false;
      }




}
