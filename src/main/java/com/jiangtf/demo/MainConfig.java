package com.jiangtf.demo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan({"com.jiangtf.demo.mapping","com.jiangtf.demo.dao"})
@ComponentScan(basePackages = {"com.jiangtf.demo.*"})
public class MainConfig {
}
