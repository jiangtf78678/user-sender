package com.jiangtf.demo.netty;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

public class MarshallingCodeFactory {

    /**
     * @Author jiangtf
     * @Description 创建Jboss Marshalling解码器MarshallingDecoder
     * @Date 12:45 2020/3/19
     * @Param []
     * @return io.netty.handler.codec.marshalling.MarshallingDecoder
     **/
    public static MarshallingDecoder buildMarshallingDecoder(){
        //通过Marshalling工具类的静态方法获取Marshalling实例对象，参数serial标示创建的是java序列化工厂对象
        final MarshallerFactory marshallerFactory= Marshalling.getProvidedMarshallerFactory("serial");
        //创建MarshallingConfiguration对象，配置版本号为5
        final MarshallingConfiguration configuration=new MarshallingConfiguration();
        configuration.setVersion(5);
        //根据marshallerFactory和MarshallingConfiguration创建UnmarshallerProvider对象
        UnmarshallerProvider provider=new DefaultUnmarshallerProvider(marshallerFactory,configuration);
        //构建Netty的MarshallingDecoder对象，两个参数分别为provider和单个消息序列化后的最大长度
        MarshallingDecoder decoder=new MarshallingDecoder(provider,1024*1024*1);
        return  decoder;
    }

/**
 * @Author jiangtf
 * @Description 创建Jboss Marshalling编码器MarshallingEncoder
 * @Date 12:54 2020/3/19
 * @Param []
 * @return io.netty.handler.codec.marshalling.MarshallingEncoder
 **/
    public  static MarshallingEncoder buildMarshallingEncoder(){
        final MarshallerFactory marshallerFactory=Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration=new MarshallingConfiguration();
        configuration.setVersion(5);
        MarshallerProvider provider=new DefaultMarshallerProvider(marshallerFactory,configuration);
        //构建netty的MarshallingEncoder对象，MarshallingEncoder用于实现序列化接口的POJO对象序列化为二进制数组
        MarshallingEncoder encoder=new MarshallingEncoder(provider);
        return  encoder;

    }


}
