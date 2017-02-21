package il.ac.hit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import il.ac.hit.tables.Tasks;
import il.ac.hit.tables.Users;



/**
 * Servlet implementation class UpdateTaskServlet
 * updates the task to our DB on creation.
 */
@WebServlet("/UpdateTaskServlet")
public class UpdateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HibernateToDoListDao query;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    /**
     * doPost 
     * see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * @param HttpServletRequest
     * @param HttpServletResponse
     * @throws ServletException, IOException
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if (user != null) {
			query = new HibernateToDoListDao();
			
			Tasks task = (Tasks) query.getTask(request.getSession().getAttribute("id"));
			task.setDescription(request.getParameter("description"));
			task.setTask(request.getParameter("task"));
			//user.getItems().add(task);
			query.updateTask(task);
			RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/update");
			requestDis.forward(request, response);
		} else {
			System.out.println("not change");
			RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/login.jsp");
			requestDis.forward(request, response);
		}
	}

}
