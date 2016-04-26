package com.chf.sample.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@PropertySource({ "classpath:jdbc.properties" })
public class HibernateConfig {

	@Autowired
	private Environment env;

	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { "com.chf.sample.domain" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {

		String driverClass = env.getProperty(DRIVER);
		String url = env.getProperty(URL);
		String userName = env.getProperty(USER);
		String password = env.getProperty(PASS);
		// BasicDataSource dataSource = new BasicDataSource();
		// dataSource.setDriverClassName(driverClass);
		// dataSource.setUrl(url);
		// dataSource.setUsername(userName);
		// dataSource.setPassword(password);

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl(url);
		dataSource.setUser(userName);
		dataSource.setPassword(password);
		return dataSource;
	}

	// @Bean
	// @Autowired
	// public HibernateTransactionManager transactionManager(SessionFactory
	// sessionFactory) {
	// HibernateTransactionManager txManager = new
	// HibernateTransactionManager();
	// txManager.setSessionFactory(sessionFactory);
	// return txManager;
	// }

	@Bean
	@Autowired
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(sessionFactory);
		return template;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	final Properties hibernateProperties() {
		Properties hibernateProperties = getProperties(DIALECT, HBM2DDL_AUTO, SHOW_SQL, FORMAT_SQL,
				GLOBALLY_QUOTED_IDENTIFIERS, C3P0_MAX_SIZE, C3P0_MIN_SIZE, C3P0_TIMEOUT, C3P0_MAX_STATEMENTS,
				C3P0_ACQUIRE_INCREMENT);
		return hibernateProperties;
	}

	Properties getProperties(String... keys) {
		Properties properties = new Properties();
		for (String key : keys) {
			properties.setProperty(key, env.getProperty(key));
		}
		return properties;
	}

}
