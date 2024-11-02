package model;

import java.sql.*;

	public class Main{
		public static void main(String[] args) {
			
	        // conx JDBC
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String user = "Delivery";   // Put your oracle user
	        String password = "G2STIC";  // Put your oracle password

	       String insertClientQuery = "INSERT INTO Clients (clientId, firstname, lastname, email, psswrd, phoneNumber, profilePhotoPath) VALUES (?, ?, ?, ?, ?, ?, ?)";


	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement preparedStatement = connection.prepareStatement(insertClientQuery)) {

	            //data
	            preparedStatement.setInt(1, 5);  // Id client
	            preparedStatement.setString(4, "cln@gmail.com");
	            preparedStatement.setString(7, "n.jpg");
	            preparedStatement.setString(2, "fName");
	            preparedStatement.setString(3, "lName");
	            preparedStatement.setString(5, "pass");
	            preparedStatement.setString(6, "0533");

	            
	            preparedStatement.executeUpdate();

	            System.out.println("Données insérées avec succés.");

	        }  catch (SQLException e) {
	            System.err.println("SQL Exception: " + e.getErrorCode() + " - " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

