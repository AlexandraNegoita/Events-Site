package connect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ConnToPlannerEvents
 */
public class ConnToPlannerEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnToPlannerEvents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession(true);
		 User currentUser = (User) session.getAttribute("currentSessionUser");	
		int currentUserID = currentUser.getUserID();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectdb","root", "toor");
			Statement stmt = conn.createStatement();
			
			String sql_planner = "SELECT * FROM `v_events_planner` WHERE userID = '" + currentUserID +"' ORDER BY dateBegin";
			System.out.println(sql_planner);
			ResultSet rs = stmt.executeQuery(sql_planner);
			List<Event> events_planner = new ArrayList();				
			while (rs.next()) {
				events_planner.add(new Event(
						Integer.parseInt(rs.getString("eventID")),
						rs.getString("eventName"),
						rs.getString("eventLink"),
						new Date(Integer.parseInt(rs.getString("dateBegin").substring(8, 10)), rs.getString("dateBegin").substring(5, 7), Integer.parseInt(rs.getString("dateBegin").substring(0, 4))),
						new Date(Integer.parseInt(rs.getString("dateEnd").substring(8, 10)), rs.getString("dateEnd").substring(5, 7), Integer.parseInt(rs.getString("dateEnd").substring(0, 4))),
						rs.getString("description")
					));
			}
			
			
			request.setAttribute("events_planner", events_planner);
		    request.getRequestDispatcher("planner-events.jsp").forward(request, response);

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
