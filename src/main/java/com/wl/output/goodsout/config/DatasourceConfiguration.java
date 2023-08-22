package com.wl.output.goodsout.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DatasourceConfiguration {

    @Bean(name = "db1")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource slaveDataSource(){
        return DataSourceBuilder.create().build();
    }

//    @Bean("dynamicDataSource")
//    public DynamicDataSource dynamicDataSource() {
//        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
//        targetDataSources.put("masterDataSource", masterDataSource());
//        targetDataSources.put("slaveDataSource", slaveDataSource());
//
//        DynamicDataSource dataSource = new DynamicDataSource();
//        // 该方法是AbstractRoutingDataSource的方法
//        dataSource.setTargetDataSources(targetDataSources);
//        // 默认的datasource设置为myTestDbDataSource
//        dataSource.setDefaultTargetDataSource(masterDataSource());
//
//        return dataSource;
//    }

    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean myGetSqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // mapperLocations
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/wl/output/goodsout/mapper/*Mapper.xml"));
        } catch (IOException e) {
//            log.info("sqlSessionFactoryBean的setMapperLocations有问题");
            e.printStackTrace();
        }

        // dataSource

        sqlSessionFactoryBean.setDataSource(dataSource);

        // SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();

        return sqlSessionFactoryBean;

    }

}
