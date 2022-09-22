/**
 * 
 */
package com.blog.service.impl;


import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.service.BusinessService;
import com.blog.util.AppUtil;

/**
 * @author Руся
 *
 */
public class ServiceManager {

	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute(SERVICE_MANAGER);
		if (instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute(SERVICE_MANAGER, instance);
		}
		return instance;
	}
	
	public void destroy() {
		LOGGER.info("ServiceManager instance destroyed!");
	}
	
	private static final String SERVICE_MANAGER = "SERVICE_MANAGER";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
	
	final Properties applicationProperties = new Properties();
	
	final BasicDataSource dataSource;
	
	final BusinessService businessService;
	
	/**
	 * @return the businessService
	 */
	public BusinessService getBusinessService() {
		return businessService;
	}

	public String getApplicationProperty(String property) {
		return applicationProperties.getProperty(property);
	}
	
	private ServiceManager(ServletContext context) {
		AppUtil.loadProperties(applicationProperties, "application.properties");
		dataSource = createBasicDataSource();
		this.businessService = new BusinessServiceImpl();
		LOGGER.info("ServiceManager instance created!");
	}

	private BasicDataSource createBasicDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDefaultAutoCommit(false);
		ds.setRollbackOnReturn(true);
		ds.setDriverClassName(getApplicationProperty("db.driver"));
		ds.setUrl(getApplicationProperty("db.url"));
		ds.setUsername(getApplicationProperty("db.username"));
		ds.setPassword(getApplicationProperty("db.password"));
		ds.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
		ds.setMaxTotal(Integer.parseInt(getApplicationProperty("db.pool.maxSize")));
		return ds;
	}
}
