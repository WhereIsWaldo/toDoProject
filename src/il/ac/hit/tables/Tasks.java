package il.ac.hit.tables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import il.ac.hit.tables.Users;


/**
 * this class implements all changes we want to make for our task  in our DB.
 * @author 89leo
 *
 */
	
	@Entity
	@Table(name="items")
	public class Tasks implements Serializable{
		@Id
		@Column(name="ID",nullable=false)
		@GeneratedValue
		private int id;
		@ManyToOne
		@JoinColumn(name = "NAME", nullable=false)
		private Users user;
		@Column(name="TASK")
		private String task;
		@Column(name="DESCRIPTION")
		private String description;
	
	
		/**
		 * default contructor
		 */
		public Tasks() {
			
		}
		/**
		 * 
		 * @param task
		 * @param user

		 */
		public Tasks(String task,String description,Users user) {
			setTask(task);
			setUser(user);
			setDescription(description);
			
		}
		@Override
		public String toString() {
			return "Tasks [id=" + id + ", user=" + user + ", task=" + task + ", description=" + description + "]";
		}
		/**
		 * 
		 * @return id of the user
		 */
		public int getId() {
			return id;
		}
/**
 * sets id 
 * @param id
 */
		public void setId(int id) {
			this.id = id;
		}
/**
 * 
 * @return user
 */
		public Users getUser() {
			return user;
		}
/**
 * sets user
 * @param user
 */
		public void setUser(Users user) {
			this.user = user;
		}
/**
 * 
 * @return task
 */
		public String getTask() {
			return task;
		}
/**
 * sets new task
 * @param task
 */
		public void setTask(String task) {
			this.task = task;
		}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

	}

