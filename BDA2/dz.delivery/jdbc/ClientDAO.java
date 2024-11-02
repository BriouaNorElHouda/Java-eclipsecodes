package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Client;
import jdbc.DAO;


public class ClientDAO extends DAO<Client> {
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String USER = "deliveryadmin";
    static final String PASS = "deliveryadmin";

    public ClientDAO(Connection con) {
        super(con);
    }

    @Override
    public boolean create(Client obj) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO Clients (clientId, firstname, lastname, email, password, phoneNumber, profilePhotoPath) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getId());
            pstmt.setString(2, obj.getFirstname());
            pstmt.setString(3, obj.getLastname());
            pstmt.setString(4, obj.getEmail());
            pstmt.setString(5, obj.getPassword());
            pstmt.setString(6, obj.getPhoneNumber());
            pstmt.setString(7, obj.getProfilePhotoPath());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Client obj) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
        	  String sql = "DELETE FROM Clients WHERE clientId = ?";
  	          PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
   
    @Override
    public boolean update(Client obj) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
      	  String sql = " UPDATE Clients SET firstname = ?, lastname = ?, email = ?, password = ?, phoneNumber = ?, profilePhotoPath = ? WHERE clientId = ?\"\r\n" + "  ";
	          PreparedStatement pstmt = conn.prepareStatement(sql);
    	    pstmt.setString(1, obj.getFirstname());
            pstmt.setString(2, obj.getLastname());
            pstmt.setString(3, obj.getEmail());
            pstmt.setString(4, obj.getPassword());
            pstmt.setString(5, obj.getPhoneNumber());
            pstmt.setString(6, obj.getProfilePhotoPath());
            pstmt.setInt(7, obj.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Client find(int clientId) {
        Client client = null;
         try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
        	  String sql = "SELECT * FROM Addresses WHERE numA = ?";
	          PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clientId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phoneNumber = rs.getString("phoneNumber");
                String profilePhotoPath = rs.getString("profilePhotoPath");
                client = new Client(clientId, firstname, lastname, email, password, phoneNumber, profilePhotoPath);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

}
