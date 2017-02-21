package il.ac.hit;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 *manage listener
 */
public class Listener implements HttpSessionListener,HttpSessionAttributeListener {
	private ServletContext servletContext = null;
	static int userCounter = 0,
			onlineUsers = 0,
			addedCounter = 0,
			deletedCounter = 0,
			replacedCounter = 0;
/**
 * user counter
 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		userCounter++;
		onlineUsers++;
		servletContext = event.getSession().getServletContext();
		servletContext.setAttribute("userCounter", userCounter);
		servletContext.setAttribute("onlineUsers", onlineUsers);
	}
/**
 * users online
 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		onlineUsers--;
		servletContext = event.getSession().getServletContext();
		servletContext.setAttribute("onlineUsers", onlineUsers);
		
	}
/**
 * count sessions
 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		addedCounter++;
		servletContext = event.getSession().getServletContext();
		servletContext.setAttribute("addedCounter", addedCounter);
	}
/**
 * counter session deleted
 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		deletedCounter++;
		servletContext = event.getSession().getServletContext();
		servletContext.setAttribute("deletedCounter", deletedCounter);
	}
/**
 * counter session replaced
 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		replacedCounter++;
		servletContext = event.getSession().getServletContext();
		servletContext.setAttribute("replacedCounter", replacedCounter);
	}

}