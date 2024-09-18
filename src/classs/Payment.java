package classs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Data;
import interfacee.iPayment;

public class Payment implements iPayment{
	private Data dataAccess;
	public Payment(Data dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public void addPayment(int PaymentID, int OrderID, String PaymentMethod, String PaymentDate) {
		String sql = "INSERT INTO Payments (OrderID, PaymentMethod, PaymentDate) VALUES (?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, OrderID);
            ps.setString(2, PaymentMethod);
            ps.setString(3, PaymentDate);
            ps.executeUpdate();
            System.out.println("Successfully added Orders!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void updatePayment(int PaymentID, int OrderID, String PaymentMethod, String PaymentDate) {
		String sql = "UPDATE Payments SET OrderID = ?, PaymentMethod = ?, PaymentDate = ? WHERE PaymentID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
        	ps.setInt(1, OrderID);  
        	ps.setString(2, PaymentMethod);      
        	ps.setString(3, PaymentDate);
        	ps.setInt(4, PaymentID);   
            ps.executeUpdate();
            System.out.println("Successfully updated Order!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deletePayment(int PaymentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPayment() {
		String sql = "SELECT * FROM Payments";
        System.out.printf("| %-10s | %-20s | %-30s | %-15s |%n", "PaymentID", "OrderID", "PaymentMethod", "PaymentDate");
        System.out.println("|------------|----------------------|-----------------|------------------------------|");
        try (Statement stmt = dataAccess.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int PaymentID = rs.getInt("PaymentID");
                int OrderID = rs.getInt("OrderID");
                String PaymentMethod = rs.getString("PaymentMethod");
                String PaymentDate = rs.getString("PaymentDate");
                System.out.printf("| %-10s | %-20s | %-30s | %-15s |%n", PaymentID, OrderID, PaymentMethod, PaymentDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
