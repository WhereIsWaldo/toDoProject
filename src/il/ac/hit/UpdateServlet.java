package il.ac.hit;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import il.ac.hit.HibernateToDoListDao;
import il.ac.hit.tables.Tasks;
import il.ac.hit.tables.Users;

/**
 * Servlet implementation class UpdateServlet
 * user password update.
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      HibernateToDoListDao query; 
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        query = new HibernateToDoListDao();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users user  = (Users) session.getAttribute("user");
		if (user != null){
			System.out.println(user.toString());
		List<Tasks> task = query.getTasks(user.getUserName());
		session.setAttribute("listTasks", task);
		}
		else{
			RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/login.jsp");
		}
		
		RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/home.jsp");
		requestDis.forward(request, response);
	}

	/**
	 * doPost 
	 * see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		query = new HibernateToDoListDao();
		List<Tasks> task = query.getTasks(user.getUserName());
		session.setAttribute("listTasks", task);
		RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/home.jsp");
		requestDis.forward(request, response);
	}

}
