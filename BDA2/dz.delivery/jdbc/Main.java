package jdbc;

import java.sql.*;

	public class Main {
		public static void main(String[] args) {
	        
	        // conx JDBC
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String user = "Delivery";   // Put your oracle user
	        String password = "G2STIC";  // Put your oracle password

	       
	        String insertClientQuery = "INSERT INTO Client (clientId, firstname, lastname, email, psswrd, phoneNumber, profilePhotoPath) VALUES (?, ?, ?, ?, ?, ?, ?)";


	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(insertClientQuery)) {

	            //data
	            preparedStatement.setInt(1, 6);  // Id client
	            preparedStatement.setString(2, "joum@gmail.com");
	            preparedStatement.setString(3, "jou.jpg");
	            preparedStatement.setString(4, "fName");
	            preparedStatement.setString(5, "lName");
	            preparedStatement.setString(6, "pass");
	            preparedStatement.setString(7, "078899");

	            
	            preparedStatement.executeUpdate();

	            System.out.println("Données insérées avec succés.");

	        }  catch (SQLException e) {
	            System.err.println("SQL Exception: " + e.getErrorCode() + " - " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

