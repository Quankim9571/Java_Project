package classs;

import java.sql.*;
import database.Data;
import java.util.Scanner;
import interfacee.iProducts;

import interfacee.iProducts;

public class Products implements iProducts {
	private Data dataAccess;

    public Products(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void addProducts(String ProductName, int CategoryID, int Size, String Color,
            Double Price,int StockQuantity) {
        String sql = "INSERT INTO Products (ProductName, CategoryID, Size, Color, Price, StockQuantity) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, ProductName);
            ps.setInt(2, CategoryID);
            ps.setInt(3, Size);
            ps.setString(4, Color);
            ps.setDouble(5, Price);
            ps.setInt(6, StockQuantity);
            ps.executeUpdate();
            System.out.println("Successfully added Products!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProducts(int ProductID, String ProductName, int CategoryID, int Size,
        String Color, Double Price,int StockQuantity) {
        String sql = "UPDATE Products SET ProductName = ?, CategoryID = ?, Size = ?, Color = ?, Price = ?, StockQuantity = ? WHERE ProductID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, ProductName);
            ps.setInt(2, CategoryID);
            ps.setInt(3, Size);
            ps.setString(4, Color);
            ps.setDouble(5, Price);
            ps.setInt(6, StockQuantity);
            ps.setInt(7, ProductID);  
            ps.executeUpdate();
            System.out.println("Successfully updated Order!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProducts(int ProductID) {
        String sql = "DELETE FROM Products WHERE ProductID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, ProductID);
            ps.executeUpdate();
            System.out.println("Successfully deleted Order!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
	public void showProducts() {
	    String sql = "SELECT * FROM Products";
	    System.out.printf("| %-10s | %-20s | %-15s | %-10s | %-10s | %-10s | %-15s |%n", 
                       "ProductID", "ProductName", "CategoryID", "Size", 
                       "Color", "Price", "StockQuantity");
    System.out.println("|------------|----------------------|-----------------|------------|------------|------------|-----------------|");

	    try (Statement stmt = dataAccess.getConnection().createStatement()) {
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int productId = rs.getInt("ProductID");
	            String productName = rs.getString("ProductName");
	            int categoryId = rs.getInt("CategoryID");
	            int size = rs.getInt("Size");
	            String color = rs.getString("Color");
	            Double price = rs.getDouble("price");
                    int stockQuantity = rs.getInt("StockQuantity"); 

	            System.out.printf("| %-10d | %-20s | %-15d | %-10d | %-10s | %-10.2f | %-15d |%n", 
                              productId, productName, categoryId, size, 
                              color, price, stockQuantity);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
