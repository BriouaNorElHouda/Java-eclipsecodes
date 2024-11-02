package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Address;
import jdbc.DAO;

public class AddressDAO  extends DAO<Address>{
	    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	    static final String USER = "delivery";
	    static final String PASS = "G2STIC";
	    
	    public AddressDAO(Connection con) {
	    	super(con);
	    	}
	    	   @Override
	    	    public boolean create(Address obj) {
	    	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	    	            String sql = "INSERT INTO Addresses (numA, street, city, postalCode, country, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    	            PreparedStatement pstmt = conn.prepareStatement(sql);
	    	            pstmt.setInt(1, obj.getnumA());
	    	            pstmt.setString(2, obj.getStreet());
	    	            pstmt.setString(3, obj.getCity());
	    	            pstmt.setString(4, obj.getPostalCode());
	    	            pstmt.setString(5, obj.getCountry());
	    	            pstmt.setDouble(6, obj.getLatitude());
	    	            pstmt.setDouble(7, obj.getLongitude());
	    	            pstmt.executeUpdate();
	    	            return true;
	    	        } catch (SQLException e) {
	    	            e.printStackTrace();
	    	            return false;
	    	        }
	    	    }

	    	    @Override
	    	    public boolean delete(Address obj) {
	    	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	    	            String sql = "DELETE FROM Addresses WHERE numA = ?";
	    	            PreparedStatement pstmt = conn.prepareStatement(sql);
	    	            pstmt.setInt(1, obj.getnumA());
	    	            pstmt.executeUpdate();
	    	            return true;
	    	        } catch (SQLException e) {
	    	            e.printStackTrace();
	    	            return false;
	    	        }
	    	    }

	    	    @Override
	    	    public boolean update(Address obj) {
	    	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	    	            String sql = "UPDATE Addresses SET street = ?, city = ?, postalCode = ?, country = ?, latitude = ?, longitude = ? WHERE numA = ?";
	    	            PreparedStatement pstmt = conn.prepareStatement(sql);
	    	            pstmt.setString(1, obj.getStreet());
	    	            pstmt.setString(2, obj.getCity());
	    	            pstmt.setString(3, obj.getPostalCode());
	    	            pstmt.setString(4, obj.getCountry());
	    	            pstmt.setDouble(5, obj.getLatitude());
	    	            pstmt.setDouble(6, obj.getLongitude());
	    	            pstmt.setInt(7, obj.getnumA());
	    	            pstmt.executeUpdate();
	    	            return true;
	    	        } catch (SQLException e) {
	    	            e.printStackTrace();
	    	            return false;
	    	        }
	    	    }
	    public Address find(int numA) {
	        Address address = null;
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	            String sql = "SELECT * FROM Addresses WHERE numA = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, numA);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                String street = rs.getString("street");
	                String city = rs.getString("city");
	                String postalCode = rs.getString("postalCode");
	                String country = rs.getString("country");
	                Double latitude = rs.getDouble("latitude");
	                Double longitude = rs.getDouble("longitude");
	                address = new Address(numA, street, city, postalCode, country, latitude, longitude);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return address;
	    }
	    public void saveAddress(Address address) {
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
	            String sql = "INSERT INTO Addresses (numA, street, city, postalCode, country, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, address.getnumA());
	            pstmt.setString(2, address.getStreet());
	            pstmt.setString(3, address.getCity());
	            pstmt.setString(4, address.getPostalCode());
	            pstmt.setString(5, address.getCountry());
	            pstmt.setDouble(6, address.getLatitude());
	            pstmt.setDouble(7, address.getLongitude());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	

	}


