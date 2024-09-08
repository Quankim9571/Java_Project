package classs;

import database.Data;
import interfacee.iSuppliers;
import java.sql.*;
import entity.EntitySupplier;
import java.util.Scanner;
public class Suppliers implements iSuppliers {
	 private Data dataAccess;

	 public Suppliers(Data dataAccess) {
	        this.dataAccess = dataAccess;
	 }
	@Override
	public void addSupplier( String SupplierName, String ContactInfo, String Address) {
		 String sql = "INSERT INTO Suppliers VALUES (?, ?, ?)";
	        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
	        	ps.setString(1, SupplierName);
	            ps.setString(2, ContactInfo);
	            ps.setString(3, Address);
	    
	            ps.executeUpdate();
	            System.out.println("Successfully added supplier!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void updateSupplier(int SupplierID, String SupplierName, String ContactInfo, String Address) {
		 String sql = "UPDATE Suppliers SET SupplierName = ?, ContactInfo = ?, Address = ? WHERE SupplierID = ?";
	        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
	        	ps.setString(1, SupplierName);  
	        	ps.setString(2, ContactInfo);      
	        	ps.setString(3, Address);    
	        	ps.setInt(4, SupplierID);
	            ps.executeUpdate();
	            System.out.println("Successfully updated supplier!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void deleteSupplier(int SupplierID) {
		  String sql = "DELETE FROM Suppliers WHERE SupplierID = ?";
	        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
	            ps.setInt(1, SupplierID);
	            ps.executeUpdate();
	            System.out.println("Successfully deleted supplier!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void showSupplier() {
		 String sql = "SELECT * FROM Suppliers";
	        System.out.printf("| %-10s | %-30s | %-30s | %-15s |%n", "SupplierID", "SupplierName", "ContactInfo", "Address");
	        System.out.println("|------------|----------------------|-----------------|------------------------------|");
	        try (Statement stmt = dataAccess.getConnection().createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                int SupplierID = rs.getInt("SupplierID");
	                String SupplierName = rs.getString("SupplierName");
	                String ContactInfo = rs.getString("ContactInfo");
	                String Address = rs.getString("Address");
	                System.out.printf("| %-10s | %-30s | %-30s | %-15s |%n", SupplierID, SupplierName, ContactInfo, Address);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

}
