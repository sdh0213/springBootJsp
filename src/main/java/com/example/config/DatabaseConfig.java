package com.example.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(value={"com.example"})
public class DatabaseConfig {
	 @Bean
     public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
         SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
         sessionFactory.setDataSource(dataSource);
        
         Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
         sessionFactory.setMapperLocations(res);
        
         return sessionFactory.getObject();
     }
	 
	 @Bean
     public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();       
//        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        
        dataSource.setUrl("jdbc:log4jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin1234");
        return dataSource;       
        
    }
	 
	 @Bean
	    public DataSourceTransactionManager transactionManager() {
	        return new DataSourceTransactionManager(getDataSource());
	 }
	 
	 @Bean
	 public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory){
		 return new SqlSessionTemplate(sqlSessionFactory);
	 }
	 
}
