package il.ac.hit;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import il.ac.hit.HibernateToDoListDao;
import il.ac.hit.tables.Tasks;
import il.ac.hit.tables.Users;
/**
 * Servlet implementation class LoginServlet
 * this class with combination of UpdateServlet checks if there a user in DB .
 * @author 89leo
 *
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	HibernateToDoListDao query;
	Users user;// check if needed

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		query = new HibernateToDoListDao();
	}
	/**
	 * doPost 
	 * see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = query.getUser(request.getParameter("name"), request.getParameter("password"));
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);// setting input to session.
			//session.setMaxInactiveInterval(300);// session time limit
			Cookie cookie = new Cookie("savedCookie", user.getUserName());
			response.addCookie(cookie);
			//Tasks task = new Tasks(request.getParameter("task"),request.getParameter("description"),user);
			//query = new HibernateToDoListDao();
			//query.addUser(task);
			//user.getItems().add(task);
			//query.addUser(task);
			List<Tasks> task1 = query.getTasks(user.getUserName());
			session.setAttribute("listTasks", task1);
			
			response.sendRedirect("homep");
			//RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			//requestDispatcher.forward(request, response);
			
			//SCALA bonus adds the number to itself and adds it
			ScalaTest scalaClassObject = new ScalaTest();
			Integer scala = scalaClassObject.addInt(2);
			session.setAttribute("scala", scala);
		} else {
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}