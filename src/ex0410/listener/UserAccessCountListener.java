package ex0410.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 * tomcat version 9.x �̹Ƿ� interface�� �ִ� �޼ҵ� default�̴�.
 * �׷��� , �ʿ��� 
 *
 */
//annotaion listener ���
@WebListener
public class UserAccessCountListener implements HttpSessionListener, ServletContextListener {
	/**
	 *1. ������ start�ɶ� ������ ���� count ���� ������ �ʱ�ȭ �۾��� �ʿ�
	 */
	
	ServletContext application;
	@Override
	public void contextInitialized(ServletContextEvent e) {
		application = e.getServletContext();
		
		application.setAttribute("count", new AtomicInteger()); //������ ��ŸƮ�ɶ� count�� 0�� �ʱ�ȭ��.
	}
	
	/**
	 * 2. session�� ���۵Ǹ� ������ ���� �����Ѵ�
	 */
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		AtomicInteger count = (AtomicInteger)application.getAttribute("count");
		
		//����
		int i = count.incrementAndGet();
		System.out.println("������ �� : "+i+"��");
	}
	
	/**
	 * 2. session�� ����Ǹ� ������ ���� �����Ѵ�
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		AtomicInteger count = (AtomicInteger)application.getAttribute("count");
		int i = count.decrementAndGet();
		System.out.println("���ҵ� �� : "+i+"��");
	}
		
}
