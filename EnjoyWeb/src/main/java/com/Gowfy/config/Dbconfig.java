package com.Gowfy.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Gowfy.model.BlogComment;
import com.Gowfy.model.BlogPost;
import com.Gowfy.model.Friend;
import com.Gowfy.model.Job;
import com.Gowfy.model.Notification;
import com.Gowfy.model.ProfilePicture;
import com.Gowfy.model.User;


@Configuration
@EnableTransactionManagement

public class Dbconfig {
public Dbconfig() {
	System.out.println("Dbconfig class is instantiated");
}
@Bean(name="sessionfactory")
public SessionFactory sessionfactory()
{
	System.out.println("Entering session factory creation method");
	LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDataSource());
	Properties hibernateProperties=new Properties();
	hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
	hibernateProperties.setProperty("hibernate.show_sql", "true");
	lsf.addProperties(hibernateProperties);
	Class classes[]=new Class[]{User.class,Job.class,BlogPost.class,Notification.class,BlogComment.class,Friend.class,ProfilePicture.class};
	return lsf.addAnnotatedClasses(classes).buildSessionFactory();
}

@Bean(name="dataSource")
public DataSource getDataSource()
{
	System.out.println("Entering DataSource Bean creation method ");
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName("org.H2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/media");
	dataSource.setUsername("root");
	dataSource.setPassword("root");
	System.out.println("DataSource bean"+dataSource);
	return dataSource;
}
@Bean 
public HibernateTransactionManager hibTransManagement()
{
	return new HibernateTransactionManager(sessionfactory());
	}
}
