/**
 * 
 */
package com.blog.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.service.impl.ServiceManager;

/**
 * @author Руся
 *
 */
public class ApplicationListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext());
		LOGGER.info("Aplication initialized!");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext()).destroy();
		LOGGER.info("Aplication destroyed!");
	}

}
