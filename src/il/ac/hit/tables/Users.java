package il.ac.hit.tables;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import il.ac.hit.tables.Tasks;

/**
 *user object in the To Do List Framework model
 *each user has a name, password and its own list of items (to-do items)
 *this is an entity to the hibernate framework we use.
 */


@Entity
@Table(name="users")
public class Users {
	@Id
	@Column(name="NAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	@OneToMany(mappedBy ="user")
	private List<Tasks> tasks = new LinkedList<Tasks>();
	/**
	 * Creating of new user and allocating a linked list for each user.
	 * @param username
	 * @param password
	 */
	/**
	 * Contructor that creates username , password
	 * @param username
	 * @param password
	 */
	public Users(){}
	public Users(String username ,String password){
		setUserName(username);
		setPassword(password);
		//setItems(new LinkedList<>());
		this.tasks = new LinkedList<>();
	}
	/**
	 * 
	 * @return list of all items
	 */
	public List<Tasks> getItems() {
		return tasks;
	}
	/**
	 * setting new task
	 * @param 
	 */
	public void setItems(List<Tasks> tasks) {
		this.tasks = tasks;
	}
	/**
	 * 
	 * @return Username
	 */
	public String getUserName() {
		return username;
	}
	/**
	 * this function for setting username
	 * @param username
	 */
	public void setUserName(String username) {
		this.username = username;
	}
	/**
	 * @return thePassword
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * this function for setting  password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
