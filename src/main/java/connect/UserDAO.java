package connect;
import java.text.*;
import java.util.*;
import java.sql.*;

public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static int result = 0;

	public static User login(User user) {
		Statement stmt = null;    

		String username = user.getUsername();    
		String password = user.getPassword();   

		String searchQuery = "SELECT * FROM v_users_roles WHERE username='" + username + "' AND password='" + password + "'";

		// "System.out.println" prints in the console; Normally used to trace the process
		System.out.println("Your user name is " + username);          
		System.out.println("Your password is " + password);
		System.out.println("Query: "+searchQuery);

		try 
		{
			//connect to DB 
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectdb","root", "toor");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(searchQuery);	        
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) 
			{
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				user.setValid(false);
			} 

			//if user exists set the isValid variable to true
			else if (more) 
			{
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setUserID(Integer.parseInt(rs.getString("userID")));
				user.setRole(rs.getString("roleName"));

				user.setValid(true);
			}
		} 

		catch (Exception ex) 
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{
			if (rs != null)	{
				try {
					rs.close();
				} catch (Exception e) {}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return user;

	}	
	public static void addRole(User user) {
		Statement stmt = null;    
		String role = user.getRole();
		int roleID = 0;
		if(role.equals("user")) {
			roleID = 3;
		}  else if(role.equals("organiser")) { 
			roleID = 2;
		}
		System.out.println(user.getUserID());
		String insertUserRole = "INSERT INTO users_roles(roleID, userID) VALUES ('" + roleID + "','" + user.getUserID() + "')" ;
		try 
		{
			//connect to DB 
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectdb","root", "toor");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(insertUserRole);
			
			//user.setValid(true);
			
		} 

		catch (Exception ex) 
		{
			System.out.println("Role update failed: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{
			if (rs != null)	{
				try {
					rs.close();
				} catch (Exception e) {}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
	}
	
	
	public static User register(User user) {
		Statement stmt = null;    

		String username = user.getUsername();    
		String password = user.getPassword();   
		String email = user.getEmail();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		

		String insertUserQuery = "INSERT INTO users(username, password, firstName, lastName, email) VALUES ('" + username + "', '" + password + "', '" + firstName + "', '" + lastName + "','" + email + "')";
		String searchQuery = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";

		try 
		{
			//connect to DB 
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectdb","root", "toor");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(insertUserQuery);
			
			rs = stmt.executeQuery(searchQuery);	        
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) 
			{
				System.out.println("Sorry, registration didn't work! Please try again later");
				user.setValid(false);
			} 

			//if user exists set the isValid variable to true
			else if (more) 
			{
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setUserID(Integer.parseInt(rs.getString("userID")));

				user.setValid(true);
			}
			
			//user.setValid(true);
			
		} 

		catch (Exception ex) 
		{
			System.out.println("Registration failed: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{
			if (rs != null)	{
				try {
					rs.close();
				} catch (Exception e) {}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return user;

	}	
}
