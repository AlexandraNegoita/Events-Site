package connect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class ConnUserRegister
 */
public class ConnUserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnUserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{	    

		     User user = new User();
		     user.setUsername(request.getParameter("username"));
		     user.setPassword(request.getParameter("password"));
		     user.setEmail(request.getParameter("email"));
		     user.setFirstName(request.getParameter("firstName"));
		     user.setLastName(request.getParameter("lastName"));
		     user.setRole(request.getParameter("selectRole"));

		     user = UserDAO.register(user);	
			 UserDAO.addRole(user);
		     if (user.isValid())
		     {
			        
		          HttpSession session = request.getSession(true);
		          session.setAttribute("isLoggedIn", "y");
		          session.setAttribute("currentSessionUser",user); 
		          response.sendRedirect("index.jsp"); //logged-in page      		
		     }
			        
		     else {
		    	  HttpSession session = request.getSession(true);
		          session.setAttribute("isLoggedIn", "n");
		          response.sendRedirect("register-page.jsp"); //error page 
		     }
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
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
