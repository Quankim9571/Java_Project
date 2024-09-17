package classs;

import java.sql.*;
import database.Data;
import interfacee.iOrderDetails;
import java.util.Scanner;
import entity.EntityOrderDetails;

public class OrderDetails implements iOrderDetails {

    private Data dataAccess;

    public OrderDetails(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void addOrderDetail(int OrderID, int ProductID, int Quantity, double UnitPrice) {
        String sql = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, OrderID);
            ps.setInt(2, ProductID);
            ps.setInt(3, Quantity);
            ps.setDouble(4, UnitPrice);
            ps.executeUpdate();
            System.out.println("Successfully added OrderDetail!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderDetail(int OrderDetailID, int OrderID, int ProductID, int Quantity, double UnitPrice) {
        String sql = "UPDATE OrderDetails SET OrderID = ?, ProductID = ?, Quantity = ?, UnitPrice = ? WHERE OrderDetailID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, OrderID);
            ps.setInt(2, ProductID);
            ps.setInt(3, Quantity);
            ps.setDouble(4, UnitPrice);
            ps.setInt(5, OrderDetailID);
            ps.executeUpdate();
            System.out.println("Successfully updated OrderDetail!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderDetail(int OrderDetailID) {
        String sql = "DELETE FROM OrderDetails WHERE OrderDetailID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, OrderDetailID);
            ps.executeUpdate();
            System.out.println("Successfully deleted OrderDetail!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showOrderDetails() {
        String sql = "SELECT * FROM OrderDetails";
        System.out.printf("| %-15s | %-10s | %-10s | %-10s | %-15s |%n",
                "OrderDetailID", "OrderID", "ProductID", "Quantity", "UnitPrice");
        System.out.println("|-----------------|------------|------------|------------|---------------|");

        try (Statement stmt = dataAccess.getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int orderDetailID = rs.getInt("OrderDetailID");
                int orderID = rs.getInt("OrderID");
                int productID = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                double unitPrice = rs.getDouble("UnitPrice");

                System.out.printf("| %-15d | %-10d | %-10d | %-10d | %-15.2f |%n",
                        orderDetailID, orderID, productID, quantity, unitPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

