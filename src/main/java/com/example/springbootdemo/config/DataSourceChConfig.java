package com.example.springbootdemo.config;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 多数据源配置-clickhouse
 */
@Configuration
@MapperScan(basePackages = "com.example.springbootdemo.mapper.mapper.ch", sqlSessionTemplateRef  = "chSqlSessionTemplate")
public class DataSourceChConfig {

    private SqlSessionFactory chGetsqlSessionFactory;

    @Bean(name = "chDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.gnckbase")
    public DataSource chDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "chSqlSessionFactory")
    public SqlSessionFactory chSqlSessionFactory(@Qualifier("chDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/ch/**/*.xml"));
        chGetsqlSessionFactory = bean.getObject();
        return bean.getObject();
    }

    @Bean(name = "chTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("chDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "chJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("chDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "chSqlSessionTemplate")
    public SqlSessionTemplate chSqlSessionTemplate(@Qualifier("chSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    public SqlSessionFactory getChGetsqlSessionFactory() {
        return chGetsqlSessionFactory;
    }
}
