package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import model.Address;
import model.OrderLine;
import jdbc.DAO;
import model.Order;
import model.DeliveryGuy.Status;

public class OrderDAO extends DAO<Order> {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "Delivery";
    private static final String PASS = "G2STIC";

    public OrderDAO(Connection con) {
        super(con);
    }

    @Override
    public boolean create(Order obj) {
    	  try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO Orders (numO, review, evaluation, createdAt, confirmedAt, deliveredAt, status, destinationAddressId, sourceAddressId) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getOrderNumber());
            pstmt.setString(2, obj.getReview());
            pstmt.setInt(3, obj.getEvaluation());
            pstmt.setTimestamp(4, new java.sql.Timestamp(obj.getCreatedAt().getTime()));
            pstmt.setTimestamp(5, new java.sql.Timestamp(obj.getConfirmedAt().getTime()));
            pstmt.setTimestamp(6, new java.sql.Timestamp(obj.getDeliveredAt().getTime()));
     
            pstmt.setInt(7, obj.getDestination().getnumA());
            pstmt.setString(8, obj.getDestination().getCity());
            pstmt.setString(9, obj.getDestination().getPostalCode());
            pstmt.setString(10, obj.getDestination().getCountry());
            pstmt.setString(11, obj.getDestination().getStreet());
            pstmt.setDouble(12, obj.getDestination().getLatitude());
            pstmt.setDouble(13, obj.getDestination().getLongitude());
            pstmt.setInt(14, obj.getSource().getnumA());
            pstmt.setString(15, obj.getSource().getCity());
            pstmt.setString(16, obj.getSource().getPostalCode());
            pstmt.setString(17, obj.getSource().getCountry());
            pstmt.setString(18, obj.getSource().getStreet());
            pstmt.setDouble(19, obj.getSource().getLatitude());
            pstmt.setDouble(20, obj.getSource().getLongitude());
         


            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Order obj) {
    	  try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "DELETE FROM Orders WHERE numO = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, obj.getOrderNumber());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Order obj) {
    	  try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "UPDATE Orders SET review = ?, evaluation = ?, status = ?, confirmedAt = ?, deliveredAt = ? " +
                         "WHERE numO = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, obj.getReview());
            pstmt.setInt(2, obj.getEvaluation());
            pstmt.setString(3, obj.getStatus().toString());
            pstmt.setTimestamp(4, new java.sql.Timestamp(obj.getConfirmedAt().getTime()));
            pstmt.setTimestamp(5, new java.sql.Timestamp(obj.getDeliveredAt().getTime()));
            pstmt.setInt(6, obj.getOrderNumber());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Order find(int numO) {
        Order order = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM Orders WHERE numO = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, numO);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int orderNumber = rs.getInt("numO");
                String review = rs.getString("review");
                int evaluation = rs.getInt("evaluation");
                Date createdAt = rs.getDate("createdAt");
                Date confirmedAt = rs.getDate("confirmedAt");
                Date deliveredAt = rs.getDate("deliveredAt"); 
                int destinationAddressId = rs.getInt("destinationAddressId");
                int sourceAddressId = rs.getInt("sourceAddressId");
            
                Address destination = getAddressById(destinationAddressId);
                Address source = getAddressById(sourceAddressId);
                
                order.addAddressDes(destination);
                order.addAddressSrc(source);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
   
        public Set<OrderLine> findAllOrderLines() throws SQLException {
            String sql = "SELECT * FROM order_lines";
            Set<OrderLine> orderLines = new HashSet<>();

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    OrderLine orderLine = extractOrderLineFromResultSet(resultSet);
                    orderLines.add(orderLine);
                }
            }

            return orderLines;
        }


    private OrderLine extractOrderLineFromResultSet(ResultSet resultSet) throws SQLException {
        int numOL = resultSet.getInt("numOL");
        String photoFilePath = resultSet.getString("photo_file_path");
        int quantity = resultSet.getInt("quantity");
        OrderLine orderLine = new OrderLine(numOL, photoFilePath, quantity);
        return orderLine;
    }

    private Address getAddressById(int destinationAddressId) {
        Address address = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM Addresses WHERE numA = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, destinationAddressId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String street = rs.getString("street");
                String city = rs.getString("city");
                String postalCode = rs.getString("postalCode");
                String country = rs.getString("country");
                Double latitude = rs.getDouble("latitude");
                Double longitude = rs.getDouble("longitude");

                address = new Address(destinationAddressId, street, city, postalCode, country, latitude, longitude);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }



}
