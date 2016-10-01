package com.coders.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coders.dao.BCommentDao;
import com.coders.dao.BCommentDaoImpl;
import com.coders.dao.BlogMasterDao;
import com.coders.dao.BlogMasterDaoImpl;
import com.coders.dao.FReplyDao;
import com.coders.dao.FReplyDaoImpl;
import com.coders.dao.ForumMasterDaoImpl;
import com.coders.dao.ForumMaterDao;
import com.coders.dao.UsersDao;
import com.coders.dao.UsersDaoImpl;
import com.coders.model.BComment;
import com.coders.model.BlogMaster;
import com.coders.model.FReply;
import com.coders.model.ForumMaster;
import com.coders.model.Users;

@Configuration
@ComponentScan("com.coders")
@EnableTransactionManagement
public class ApplicationContextConfig {
	

    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/civic");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.format_sql", "true");
    	properties.put("hibernate.hbm2ddl.auto", "update");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Users.class);
    	sessionBuilder.addAnnotatedClasses(BlogMaster.class);
    	sessionBuilder.addAnnotatedClasses(BComment.class);
    	sessionBuilder.addAnnotatedClasses(ForumMaster.class);
    	sessionBuilder.addAnnotatedClasses(FReply.class);
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    //----------------------------
   @Autowired
   @Bean(name="usersDao")
   public UsersDao getUsersDao(SessionFactory sessionFactory)
   {
	   return new UsersDaoImpl(sessionFactory);
   }
    @Autowired
    @Bean(name="users")
    public Users getUser()
    {
    	return new Users();
    }
    //---------------------
    @Autowired
    @Bean(name="blogMasterDao")
    public BlogMasterDao getBlogMasterDao(SessionFactory sessionFactory)
    {
    	return new BlogMasterDaoImpl(sessionFactory);
    }
    @Autowired
    @Bean(name="blogMaster")
    public BlogMaster getBlogMaster()
    {
    	return new BlogMaster();
    }
  //---------------------
    @Autowired
    @Bean(name="bcommentDao")
    public BCommentDao getBCommentDao(SessionFactory sessionFactory)
    {
    	return new BCommentDaoImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name="bcomment")
    public BComment getBComment()
    {
    	return new BComment();
    }
  //---------------------
    @Autowired
    @Bean(name="forumMasterDao")
    public ForumMaterDao getForumMaterDao(SessionFactory sessionFactory)
    {
    	return new ForumMasterDaoImpl(sessionFactory);
    }
    @Autowired
    @Bean(name="forumMaster")
    public ForumMaster getForumMaster()
    {
    	return new ForumMaster(); 
    }
    //---------------------
    @Autowired
    @Bean(name="fReplyDao")
    public FReplyDao getFReplyDao(SessionFactory sessionFactory)
    {
    	return new FReplyDaoImpl(sessionFactory);
    }
    @Autowired
    @Bean(name="fReply")
    public FReply getFReply()
    {
    	return new FReply();
    }

}
