package il.ac.hit.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 * The main contract here is the creation of Session instances.
 * @author 89leo
 *
 */
public class Factory {
	private static SessionFactory sessionFactory = null;
	
	
	public Factory(){}
	
	
	public static SessionFactory getSessionFactory(){
		if (sessionFactory == null)
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		return sessionFactory;
		
	}
}
