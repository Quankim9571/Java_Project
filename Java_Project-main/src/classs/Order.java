package classs;

import java.sql.*;
import database.Data;
import interfacee.iOrder;
import java.util.Scanner;
import entity.EntityOrder;

public class Order implements iOrder {
    
    private Data dataAccess;

    public Order(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void addOrder(int CustomerID, String OrderDate, double TotalAmount, String ShippingAddress,
			String PaymentStatus) {
        String sql = "INSERT INTO Orders (CustomerID, OrderDate, TotalAmount, ShippingAddress, PaymentStatus) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, CustomerID);
            ps.setString(2, OrderDate);
            ps.setDouble(3, TotalAmount);
            ps.setString(4, ShippingAddress);
            ps.setString(5, PaymentStatus);
            ps.executeUpdate();
            System.out.println("Successfully added Orders!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(int OrderID, int CustomerID, String OrderDate, double TotalAmount, String ShippingAddress,
			String PaymentStatus) {
        String sql = "UPDATE Orders SET CustomerID = ?, OrderDate = ?, TotalAmount = ?, ShippingAddress = ?, PaymentStatus = ? WHERE OrderID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
        	ps.setInt(1, CustomerID);  
        	ps.setString(2, OrderDate);      
        	ps.setDouble(3, TotalAmount);
        	ps.setString(4, ShippingAddress);   
        	ps.setString(5, PaymentStatus); 
            ps.executeUpdate();
            System.out.println("Successfully updated Order!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int OrderID) {
        String sql = "DELETE FROM Orders WHERE OrderID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, OrderID);
            ps.executeUpdate();
            System.out.println("Successfully deleted Order!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
	public void showOrder() {
	    String sql = "SELECT * FROM Orders";
	    System.out.printf("| %-10s | %-10s | %-15s | %-15s | %-25s | %-15s |%n", 
	                       "OrderID", "CustomerID", "OrderDate", "TotalAmount", 
	                       "ShippingAddress", "PaymentStatus");
	    System.out.println("|------------|------------|---------------|---------------|--------------------------|---------------|");

	    try (Statement stmt = dataAccess.getConnection().createStatement()) {
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int orderId = rs.getInt("OrderID");
	            int customerId = rs.getInt("CustomerID");
	            java.sql.Date orderDate = rs.getDate("OrderDate");  // Sửa lại kiểu Date
	            double totalAmount = rs.getDouble("TotalAmount");
	            String shippingAddress = rs.getString("ShippingAddress");
	            String paymentStatus = rs.getString("PaymentStatus");

	            System.out.printf("| %-10d | %-10d | %-15s | %-15.2f | %-25s | %-15s |%n", 
	                              orderId, customerId, orderDate.toString(), totalAmount, 
	                              shippingAddress, paymentStatus);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}