package connect;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/connToEventTypes")
public class ConnToEventTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConnToEventTypes() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String typeSelected="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectdb","root", "toor");
			Statement stmt = conn.createStatement();
//			String sql_types = "select * from events_type";
//			ResultSet rs = stmt.executeQuery(sql_types);
			String sql_count_by_type ="SELECT count(*) as count_events, events_type.type FROM events_type INNER JOIN v_events_city ON events_type.typeID=v_events_city.typeID WHERE v_events_city.cityName='" + request.getParameter("selectCity") + "' GROUP BY events_type.type";
			ResultSet rs;
			rs = stmt.executeQuery(sql_count_by_type);
			List<EventType> types = new ArrayList();
			int totalEvents = 0;
			while (rs.next()) {
				types.add(new EventType(rs.getString("type"), Integer.parseInt(rs.getString("count_events"))));
				totalEvents += Integer.parseInt(rs.getString("count_events"));
			}
			String sql_events = "SELECT * FROM `v_events_city` WHERE cityName = '" + request.getParameter("selectCity") + "'";
			rs = stmt.executeQuery(sql_events);
			List<Event> events = new ArrayList();				
			while (rs.next()) {
				events.add(new Event(
						Integer.parseInt(rs.getString("eventID")),
						rs.getString("eventName"),
						rs.getString("type"),
						rs.getString("eventLink"),
						new Date(Integer.parseInt(rs.getString("dateBegin").substring(8, 10)), rs.getString("dateBegin").substring(5, 7), Integer.parseInt(rs.getString("dateBegin").substring(0, 4))),
						new Date(Integer.parseInt(rs.getString("dateEnd").substring(8, 10)), rs.getString("dateEnd").substring(5, 7), Integer.parseInt(rs.getString("dateEnd").substring(0, 4))),
						rs.getString("description"),
						Integer.parseInt(rs.getString("locationID")),
						Integer.parseInt(rs.getString("userID"))
					));
			}
			
			
			
			
			request.setAttribute("types", types);
			request.setAttribute("totalEvents", totalEvents);
			request.setAttribute("events", events);
		    request.getRequestDispatcher("events-by-city.jsp").forward(request, response);

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
