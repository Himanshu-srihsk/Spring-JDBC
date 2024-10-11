package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.entities.StudentDao;
import com.spring.jdbc.entities.StudentdaoImpl;

@Configuration
public class JavaConfig {
	@Bean(name={"ds"})
  public DataSource getDataSource() {
	  DriverManagerDataSource ds=new DriverManagerDataSource();
	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
	  ds.setUsername("root");
	  ds.setPassword("root");
	  return ds;
  }
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	@Bean(name={"studentdao"})
	public StudentDao studentDao() {
		StudentdaoImpl studentDao = new StudentdaoImpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
	}
	
}
