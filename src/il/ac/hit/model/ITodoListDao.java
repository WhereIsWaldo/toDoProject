package il.ac.hit.model;

import java.util.List;

import il.ac.hit.tables.Tasks;
import il.ac.hit.tables.Users;
/**
 * 
 * 
 * interface that lists the methods through which the web application uses the database. 
 * @author 89leo
 *
 */
public interface ITodoListDao {
	public void addUser(Object item);
	public Users getUser(String name, String password);
	
	public void deleteTask(int id);
	public void updateTask(Object item);
	public Object getTask(Object id);
	public List <Tasks>getTasks(String user);

}
