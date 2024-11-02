package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Agent;
import jdbc.DAO;

public class AgentDAO extends DAO<Agent> {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "deliveryadmin";
    private static final String PASS = "deliveryadmin";

    public AgentDAO(Connection con) {
        super(con);
    }

    @Override
    public boolean create(Agent obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO Agents (ipAddress, firstname, lastname, email, password, phoneNumber) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, obj.getIpAddress());
            pstmt.setString(2, obj.getFirstname());
            pstmt.setString(3, obj.getLastname());
            pstmt.setString(4, obj.getEmail());
            pstmt.setString(5, obj.getPsswrd());
            pstmt.setString(6, obj.getPhoneNumber());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Agent obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "DELETE FROM Agents WHERE ipAddress = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, obj.getIpAddress());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Agent obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "UPDATE Agents SET firstname = ?, lastname = ?, email = ?, password = ?, phoneNumber = ? " +
                         "WHERE ipAddress = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, obj.getFirstname());
            pstmt.setString(2, obj.getLastname());
            pstmt.setString(3, obj.getEmail());
            pstmt.setString(4, obj.getPsswrd());
            pstmt.setString(5, obj.getPhoneNumber());
            pstmt.setString(6, obj.getIpAddress());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Agent find(int numAg) {
        Agent agent = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM Agents WHERE numAg = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, numAg);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String ipAddress = rs.getString("ipAddress");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phoneNumber = rs.getString("phoneNumber");
                agent = new Agent(numAg, ipAddress, firstname, lastname, email, password, phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agent;
    }

	
	}

