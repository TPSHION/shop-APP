package com.stm.shop.config;

/**
 * @author:liuxinxing Date:2018/3/20 0020
 * Time:20:42
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan({"com.stm.shop.admin.dao","com.stm.shop.app.dao"})
@Configuration
public class MybatisConfig {
}
