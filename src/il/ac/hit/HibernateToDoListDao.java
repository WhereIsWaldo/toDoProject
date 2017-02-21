package il.ac.hit;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import il.ac.hit.exception.ToDoDAOException;
import il.ac.hit.model.Factory;
import il.ac.hit.model.ITodoListDao;
import il.ac.hit.tables.Tasks;
import il.ac.hit.tables.Users;

public class HibernateToDoListDao implements ITodoListDao {
/**
 * implement the singleton pattern.
 * factory - configuration object that configurates Hibernate and allows a session to be init-ed
 * thread safe - used by all threads in application.
 */
	private SessionFactory factory;
	private Session session;
	/**
	 *  
	 */
	public HibernateToDoListDao(){
		factory = Factory.getSessionFactory();
	}
	/**
	 *  Adding a new user.
	 */
	@Override
	public void addUser(Object item) {
		try {
		session = factory.openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	} catch (ToDoDAOException e){
		Transaction transaction = session.getTransaction();
		if (transaction.isActive()){
			transaction.rollback();
		}
		
	}finally {
		session.close();
	}
		
	}
	/**
	 * deletes a user 
	 * @param id
	 */
	@Override
	public void deleteTask(int id) {
		try {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from Tasks WHERE id = ?");
		query.setInteger(0, new Integer(id));
		query.executeUpdate();
		session.getTransaction().commit();
	} catch (ToDoDAOException e){
		
		Transaction transaction = session.getTransaction();
		if (transaction.isActive()){
			transaction.rollback();
		}
	}
	finally {
		session.close();
	}
	}
/**
 * updates Task
 * @param Object
 * 
 */
	@Override
	public void updateTask(Object item) {
		session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(item);
		session.getTransaction().commit();
		session.close();
	}
/**
 * returns Users
 * @return Users
 * @param password
 */
	@Override
	public Users getUser(String name,String password) {
		try {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Users WHERE username='"+name+"' and "+"password='"+password+"'");
		Users userToReturn = (Users)query.uniqueResult();
		session.getTransaction().commit();
		
		return userToReturn;
	}catch (ToDoDAOException e)
		{
		if(session!=null){
		Transaction transaction = session.getTransaction();
		if (transaction.isActive()){
			transaction.rollback();
			
		}
		}
		return null;
	} finally {
		if (session != null){
		session.close();}
	}
		
	}
	public Users getUsername(String name) {
		session = factory.openSession();
		session.beginTransaction();
		Query query=  session.createQuery("from Users where name=?");
		query.setString(0, name);
		Users userToReturn = (Users)query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return userToReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * returns list of users
	 * @return List
	 * @param user
	 */
	public List<Tasks> getTasks(String user) {
		try {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Tasks WHERE user = ?");
		query.setString(0, user);
	    List<Tasks> tasksToReturn = query.list();
		session.getTransaction().commit();
		
		return (List<Tasks>)tasksToReturn;
	} catch (ToDoDAOException e) {
		Transaction transaction=session.getTransaction();
		if (transaction.isActive()){
			transaction.rollback();
		}
		return null;
	}finally {
		if (session != null)
		{
			session.close();
		}
	}
	}
/**
 * return 1 task
 * @param id
 * @return Object
 */
	@Override
	public Object getTask(Object id) {
		try {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Tasks WHERE id = ?");
		System.out.println(id.getClass());
		query.setInteger(0, (int) id);
        Tasks taskToReturn = (Tasks) query.uniqueResult();
		session.getTransaction().commit();
		
		return taskToReturn;
	} catch (ToDoDAOException e){
		Transaction transaction =session.getTransaction();
		if (transaction.isActive())
		transaction.rollback();
		return null;
	} finally {
		if (session != null){
			session.close();
		}
	}
	}

}
