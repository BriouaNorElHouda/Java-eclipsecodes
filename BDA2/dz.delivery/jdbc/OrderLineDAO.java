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
import model.Order;
import jdbc.OrderDAO;
import model.OrderLine;

public class OrderLineDAO extends DAO<OrderLine> {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "deliveryadmin";
    private static final String PASS = "deliveryadmin";

    public OrderLineDAO(Connection con) {
        super(con);
    }

    @Override
    public boolean create(OrderLine obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO OrderLine (quantity, photoFilePath, order_id, item_id) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getQuantity());
            pstmt.setString(2, obj.getPhotoFilePath());
            pstmt.setInt(3, obj.getOrder().getOrderNumber());
            pstmt.setInt(4, obj.getItem().getNumber()); 
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean delete(OrderLine obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "DELETE FROM OrderLine WHERE orderLineId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getnumOL()); 
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean update(OrderLine obj) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "UPDATE OrderLine SET quantity = ?, photoFilePath = ?, order_id = ?, item_id = ? WHERE orderLineId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getQuantity());
            pstmt.setString(2, obj.getPhotoFilePath());
            pstmt.setInt(3, obj.getOrder().getOrderNumber());
            pstmt.setInt(4, obj.getItem().getNumber());
            pstmt.setInt(5, obj.getnumOL());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public OrderLine find(int numOL) {
        OrderLine orderLine = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM OrderLine WHERE numOL = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, numOL);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int quantity = rs.getInt("quantity");
                String photoFilePath = rs.getString("photoFilePath");
                Order order = getOrderFromResultSet(rs); 
                Item item = getItemFromResultSet(rs); 
                
                orderLine = new OrderLine(quantity, photoFilePath, quantity);
                orderLine.setOrder(order);
                orderLine.setItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderLine;
    }


    private Item getItemFromResultSet(ResultSet rs) throws SQLException {
        int Number = rs.getInt("item_id");
        String name = rs.getString("item_name"); 
        String description = rs.getString("item_description"); 
        double price = rs.getDouble("price"); 

        return new Item( Number, name, description, price); 
    }


    private Order getOrderFromResultSet(ResultSet rs) throws SQLException {
        int numO = rs.getInt("order_id"); 
        OrderDAO orderDAO = new OrderDAO(con); 
        Order order = orderDAO.find(numO);
        return order;
    }


	public Set<OrderLine> getOrderLinesForOrder(Order order) {
        Set<OrderLine> orderLines = new HashSet<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM OrderLine WHERE order_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, order.getOrderNumber()); 
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int numOL= rs.getInt("orderLineId");
                int quantity = rs.getInt("quantity");
                String photoFilePath = rs.getString("photoFilePath");
               
                Order fetchedOrder = getOrderFromResultSet(rs);
                Item fetchedItem = getItemFromResultSet(rs); 
                
                OrderLine orderLine = new OrderLine(quantity, photoFilePath, quantity);
                orderLine.setOrder(fetchedOrder);
                orderLine.setItem(fetchedItem);
                orderLines.add(orderLine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderLines;
    }

}
