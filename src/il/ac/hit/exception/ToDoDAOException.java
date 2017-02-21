package il.ac.hit.exception;

import org.hibernate.HibernateException;

public class ToDoDAOException extends HibernateException{
	/**
	 * to do list exception class
	 */
	private static final long serialVersionUID = 1L;

	public ToDoDAOException() {
		super("TO DO LIST EXCEPTION : ");
		// TODO Auto-generated constructor stub
	}
}
