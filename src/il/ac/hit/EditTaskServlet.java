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



/**
 * Servlet implementation class EditTaskServlet
 * class that edits a task in our DB
 */
@WebServlet("/EditTaskServlet")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HibernateToDoListDao query;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		query = new HibernateToDoListDao();
		
		
		request.getSession().setAttribute("id", Integer.parseInt(request.getParameter("idTask")));
		request.setAttribute("id", request.getParameter("idTask"));
		Tasks task = (Tasks) query.getTask(Integer.parseInt(request.getParameter("idTask")));
		session.setAttribute("task", task);
		RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/editTask.jsp");
		requestDis.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
