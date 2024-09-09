package classs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Data;
import entity.EntityCategories;
import interfacee.iCategories;

public class Categories implements iCategories {
	private Data dataAccess;
	
	public Categories(Data dataAccess) {
		this.dataAccess = dataAccess;
	}
	@Override
	public void addCategory(String CategoryName) {
		 String sql = "INSERT INTO Categories (CategoryName) VALUES (?)";
	        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
	            ps.setString(1, CategoryName);
	            ps.executeUpdate();
	            System.out.println("Successfully Added category!");
	            System.out.println("--------------------------------");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void updateCategory(int CategoryID, String CategoryName) {
		String sql = "UPDATE Categories SET CategoryName = ? WHERE CategoryID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
        	ps.setString(1, CategoryName);
        	ps.setInt(2, CategoryID);
            ps.executeUpdate();
            System.out.println("Successfully Updated Category!");
            System.out.println("--------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteCategory(int CategoryID) {
		 String sql = "DELETE FROM Categories WHERE CategoryID = ?";
	        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
	            ps.setInt(1, CategoryID);
	            ps.executeUpdate();
	            System.out.println("Successfully Deleted Category!");
	            System.out.println("--------------------------------");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void showCategory() {
		 String sql = "SELECT * FROM Categories";
	        System.out.printf("| %-10s | %-20s |%n", "CategoryID", "Categoryame");
	        System.out.println("|------------|----------------------|-----------------|");
	        try (Statement stmt = dataAccess.getConnection().createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                int CategoryID = rs.getInt("CategoryID");
	                String CategoryName = rs.getString("CategoryName");
	                System.out.printf("| %-10s | %-20s |%n", CategoryID, CategoryName);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

}
