package connect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet implementation class OrgAddEvent
 */

public class OrgAddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrgAddEvent() {
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
			Location location = new Location();
			location.setCountry("ROMANIA");
			location.setCity(request.getParameter("eventSelectCity"));
			location.setCityID();
			System.out.println(request.getParameter("eventDateBegin"));
			System.out.println(request.getParameter("eventDateEnd"));

		     Event event = new Event();
		     event.setEventName(request.getParameter("eventName"));
		     event.setType(request.getParameter("eventSelectType"));
		     event.setTypeID();
		     event.setDateBegin(new Date(Integer.parseInt(request.getParameter("eventDateBegin").substring(8,10)),request.getParameter("eventDateBegin").substring(5,7), Integer.parseInt(request.getParameter("eventDateBegin").substring(0,4)))) ;
		     event.setDateEnd(new Date(Integer.parseInt(request.getParameter("eventDateEnd").substring(8,10)),request.getParameter("eventDateEnd").substring(5,7), Integer.parseInt(request.getParameter("eventDateEnd").substring(0,4)))) ;
		     event.setEventLink(request.getParameter("eventLink"));
		     event.setDescription(request.getParameter("description"));

		     event = EventDAO.addEvent(event, location);	
		     if (event.isValid())
		     {
		    	 HttpSession session = request.getSession(true);
		          session.setAttribute("eventID", event.getEventID());
		          response.sendRedirect("add-event-thumbnail.jsp"); //logged-in page      		
		     }
			        
		     else {
		          response.sendRedirect("add-event.jsp"); //error page 
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
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
