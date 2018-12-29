package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import serviceImpl.UserServiceImpl;
import util.RedisUtil;

@Configuration
@ComponentScan(basePackageClasses= {RedisUtil.class,UserServiceImpl.class})
@ImportResource("classpath:spring/redis-application.xml")
public class RedisConfigByImportXml {

}
