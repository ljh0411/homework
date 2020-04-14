package ex0410.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	/**
	 * ������ ���۵ɶ�...ȣ��
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionListener�� sessionCreated....");
	}
	
	/**
	 * ������ ����ɶ� ȣ���...
	 * :session timeout�� �ɶ�...
	 * 	session.invalidate()ȣ��ɶ�...
	 *  �������� x�� Ŭ���������� ȣ����� �ʴ´�.
	 */

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionListener�� sessionDestroyed....");
	}

}
