package com.template.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.template.springboot.mapper"})
public class MariaDBConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));

/*
        Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(myBatisConfig);
*/

        return sqlSessionFactoryBean.getObject();
    }

}
