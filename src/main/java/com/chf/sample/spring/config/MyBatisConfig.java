package com.chf.sample.spring.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chf.sample.spring.controller.dao.EventMapper;

@Configuration
@MapperScan("com.chf.sample.spring.controller.dao")
public class MyBatisConfig {

    @Bean
    @Autowired
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory.getObject();
    }

    @Bean
    @Autowired
    public SqlSessionTemplate sqlSessionTemplate(
            SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(EventMapper.class);
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(
                sqlSessionFactory);
        return sessionTemplate;
    }

    @Bean
    @Autowired
    public EventMapper eventMapper(SqlSessionTemplate sqlSessionTemplate)
            throws Exception {

        EventMapper mapper = sqlSessionTemplate.getMapper(EventMapper.class);
        return mapper;
    }
}
