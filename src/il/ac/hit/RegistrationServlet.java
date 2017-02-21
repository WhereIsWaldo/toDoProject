package il.ac.hit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import il.ac.hit.HibernateToDoListDao;
import il.ac.hit.tables.Users;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HibernateToDoListDao query;
	
	Users user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
    	
        super();
        query = new HibernateToDoListDao();
        // TODO Auto-generated constructor stub
    }


    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 */
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
throws ServletException, IOException {
    	RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/registration.jsp");
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
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String username = request.getParameter("username");
		Users user = query.getUsername(request.getParameter("username"));
		
		if (password.equals("")||password2.equals("")||username.equals("")||!password.equals(password2) || user!=null) {
			String invalidInput = "Invalid Input";
			request.setAttribute("invalidInput", invalidInput);
			RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/registration.jsp");
			requestDis.forward(request, response);
		}
		else{
			user = new Users(request.getParameter("username"), request.getParameter("password"));
			
			query.addUser(user);
			RequestDispatcher requestDis = getServletContext().getRequestDispatcher("/login.jsp");
			requestDis.forward(request, response);
		}
	}

}
