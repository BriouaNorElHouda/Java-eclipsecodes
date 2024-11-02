package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jdbc.DAO;
import jdbc.AddressDAO;
import model.Address;
import model.DeliveryGuy;
import model.Order;
import model.DeliveryGuy.Status;

public class DeliveryGuyDAO extends DAO<DeliveryGuy> {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "deliveryadmin";
    private static final String PASS = "deliveryadmin";

    public DeliveryGuyDAO(Connection con) {
        super(con);
    }
    
    @Override
    public boolean create(DeliveryGuy obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
        	String sql = "INSERT INTO DeliveryGuy (numD, firstname, lastname, email, password, phoneNumber, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getnumD());
            pstmt.setString(2, obj.getFirstname());
            pstmt.setString(3, obj.getLastname());
            pstmt.setString(4, obj.getEmail());
            pstmt.setString(5, obj.getPassword());
            pstmt.setString(6, obj.getPhoneNumber());
            pstmt.setString(7, obj.getStatus().toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(DeliveryGuy obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "DELETE FROM DeliveryGuy WHERE numD = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getnumD());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean update(DeliveryGuy obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
        	 String sql = " UPDATE DELIVERYGUY SET firstname = ?, lastname = ?, email = ?, password = ?, phoneNumber = ? WHERE numD = ?\"\r\n" + "  ";
	          PreparedStatement pstmt = conn.prepareStatement(sql);
   	    pstmt.setString(1, obj.getFirstname());
           pstmt.setString(2, obj.getLastname());
           pstmt.setString(3, obj.getEmail());
           pstmt.setString(4, obj.getPassword());
           pstmt.setString(5, obj.getPhoneNumber());
           pstmt.setInt(6, obj.getnumD());
           pstmt.executeUpdate();
           return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
	

    public DeliveryGuy find(int numD) {
        DeliveryGuy deliveryGuy = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM DeliveryGuy WHERE numD = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, numD);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int foundNumD = rs.getInt("numD");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phoneNumber = rs.getString("phoneNumber");
                Status status = Status.valueOf(rs.getString("status")); // Assuming status is stored as a String in the DB

                deliveryGuy = new DeliveryGuy(foundNumD, firstname, lastname, email, password, phoneNumber, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryGuy;
    }



}
