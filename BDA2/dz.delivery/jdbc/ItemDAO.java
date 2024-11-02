package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import jdbc.DAO;
import model.Item;
import model.OrderLine;

public class ItemDAO extends DAO<Item> {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "deliveryadmin";
    private static final String PASS = "deliveryadmin";

    public ItemDAO(Connection con) {
        super(con);
    }

    @Override
    public boolean create(Item obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO Items (name, description, price) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getDescription());
            pstmt.setDouble(3, obj.getPrice());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Item obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "DELETE FROM Items WHERE Number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getNumber());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Item obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "UPDATE Items SET name = ?, description = ?, price = ? WHERE Number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getDescription());
            pstmt.setDouble(3, obj.getPrice());
            pstmt.setInt(4, obj.getNumber());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Item find(int Number) {
        Item item = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM Items WHERE Number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Number);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                item = new Item(Number, name, description, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public Set<OrderLine> getOrderLinesForItem(Item item) {
        Set<OrderLine> orderLines = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM OrderLines WHERE itemNumber = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, item.getNumber());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	Integer numOL= rs.getInt("OL_ID");
                Integer quantity = rs.getInt("quantity");
                String photoFilePath = rs.getString("photoFilePath");

                OrderLine orderLine = new OrderLine(numOL, photoFilePath,quantity);
                orderLine.setItem(item);
                orderLines.add(orderLine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderLines;
    }
}
