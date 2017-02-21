package il.ac.hit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.tables.Users;

/**
 * Servlet implementation class SwitchServlet
 * For implementation simple logic to limir our servlets
 */
@WebServlet("/SwitchServlet")
public class SwitchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SwitchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = (Users) request.getSession().getAttribute("user");
		String url = request.getRequestURL().toString().substring(request.getRequestURL().toString().lastIndexOf("/") + 1);
		if (user!= null||url.equals("loginp")||url.equals("registp")){
		RequestDispatcher requestDispatcher;
		getServletContext().getRequestDispatcher("/error.jsp");
		switch (url) {
		case "login":
			requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "newT":
			requestDispatcher = getServletContext().getRequestDispatcher("/newTask.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "homep":
			requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "registp":
			requestDispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "logout":
			request.getSession().invalidate();
			response.sendRedirect("loginp");
			break;
		case "adminp":
			requestDispatcher = getServletContext().getRequestDispatcher("/adminPage.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "loginp":
			request.getSession().invalidate();
			requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
			break;
			
			
		default:
			requestDispatcher = getServletContext().getRequestDispatcher("/error.jsp");
			requestDispatcher.forward(request, response);
			break;
		}
		}else{
			response.sendRedirect("loginp");
		}

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
