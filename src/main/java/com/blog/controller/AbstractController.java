/**
 * 
 */
package com.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blog.service.BusinessService;
import com.blog.service.impl.ServiceManager;

/**
 * @author Руся
 *
 */
public abstract class AbstractController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5429606473917624515L;
	
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass()); 
	
	private BusinessService businessService;
	
	/**
	 * @return the businessService
	 */
	public final BusinessService getBusinessService() {
		return businessService;
	}

	@Override
	public void init() throws ServletException {
		this.businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
	} 
	
	public final void forwardToPage(String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("currentPage", "page/" + jspPage);
		request.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(request, response);
	}
	
	public final void forwardToFragment(String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/JSP/fragment/" + jspPage).forward(request, response);
	}
}
