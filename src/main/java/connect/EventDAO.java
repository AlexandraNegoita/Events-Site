package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EventDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static int result = 0;
	
	public static Event addEvent(Event event, Location location) {
		Statement stmt = null;    

		String eventName = event.getEventName();    
		int typeID = event.getTypeID();   
		Date dateBegin = event.getDateBegin();
		Date dateEnd = event.getDateEnd();
		String eventLink = event.getEventLink();
		String eventDescription = event.getDescription();
		
		String country = location.getCountry();
		int cityID = location.getCityID();
		String locationID = "0";
		String eventID = "0";

		String insertLocationQuery = "INSERT INTO events_location(cityID, country) VALUES ('" + cityID + "', '" + country + "')";
		String selectLocationID = "SELECT locationID FROM events_location ORDER BY locationID DESC LIMIT 1";
		String insertEventQuery = "INSERT INTO events(eventName, typeID, eventLink, dateBegin, dateEnd, description, locationID, userID) VALUES ('" + eventName + "', '" + typeID + "', '" + eventLink + "', '" + dateBegin.formatDateForDB() + "', '" + dateEnd.formatDateForDB() + "', '" + eventDescription + "', '" ;
		String selectEventID = "SELECT eventID FROM events ORDER BY eventID DESC LIMIT 1";
		String updateLocation = "UPDATE events_location SET eventID = ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectdb","root", "toor");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(insertLocationQuery);
			
			rs = stmt.executeQuery(selectLocationID);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) 
			{
				System.out.println("Sorry, location didn't work! Please try again later");
				event.setValid(false);
			} 

			//if user exists set the isValid variable to true
			else if (more) 
			{
				locationID = rs.getString("locationID");
				System.out.println(locationID);
				result = stmt.executeUpdate(insertEventQuery+ locationID + "', '1')");
				System.out.println(locationID);

				rs = stmt.executeQuery(selectEventID);
				
				more = rs.next();

				// if user does not exist set the isValid variable to false
				if (!more) 
				{
					System.out.println("Sorry, eventID didn't work! Please try again later");
					event.setValid(false);
				} 

				//if user exists set the isValid variable to true
				else if (more) 
				{
					eventID = rs.getString("eventID");
					event.setEventID(Integer.parseInt(eventID));
					result = stmt.executeUpdate(updateLocation + eventID + " WHERE locationID = '"  + locationID + "'");
					event.setValid(true);
				}
			}
			
			
		}
		catch (Exception ex) 
		{
			System.out.println("Event add failed: An Exception has occurred! " + ex);
		} 
		return event;
	}
}
