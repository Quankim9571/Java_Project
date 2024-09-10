package classs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.Data;
import interfacee.iPayment;

public class Payment implements iPayment{
	private Data dataAccess;
	public Payment(Data dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	@Override
	public void addPayment(int PaymentID, int OrderID, String PaymentMethod, String PaymentDate) {
		String sql = "INSERT INTO Payment (OrderID, PaymentMethod, PaymentDate) VALUES (?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, OrderID);
            ps.setString(2, PaymentMethod);
            ps.setString(3, PaymentDate);
            ps.setInt(5, PaymentID);
            ps.executeUpdate();
            System.out.println("Successfully added Orders!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void updatePayment(int PaymentID, int OrderID, String PaymentMethod, String PaymentDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePayment(int PaymentID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPayment() {
		// TODO Auto-generated method stub
		
	}

}
