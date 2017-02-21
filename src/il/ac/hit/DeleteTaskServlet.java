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
 * Servlet implementation class deleteTaskServlet
 */
@WebServlet("/deleteTaskServlet")
public class DeleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HibernateToDoListDao query;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		query = new HibernateToDoListDao();
		
		
		request.getSession().setAttribute("id", Integer.parseInt(request.getParameter("idTask")));
		request.setAttribute("id", request.getParameter("idTask"));
		int id = Integer.parseInt(request.getParameter("idTask"));
		query.deleteTask(id);
		
		RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/update");
		requestDis.forward(request, response);
	}

}
