package ex0410.listener;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;

public class AppListener implements ServletContextListener {

	/**
	 * ServletContext(application)�� start�ɶ� ȣ��
	 */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("AppListener �� contextInitialized........");
		
		//�� ���� �����ڵ带 �����ؼ� ��� �������� ����� �� �ֵ��� �Ѵ�.
		Map<String,String> map = new HashMap<String, String>();
		map.put("kr", "���ѹα�");
		map.put("us", "�̱�");
		map.put("jp", "�Ϻ�");
		map.put("ch", "�߱�");
		map.put("fr", "������");
		
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);
		
		String contextPath = application.getContextPath();
		application.setAttribute("path", contextPath);
	}
	
	/**
	 * ServletContext(application)�� stop �ɶ� ȣ��
	 */

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener �� contextDestroyed........");
	}
	
}
