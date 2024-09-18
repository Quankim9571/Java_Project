package classs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Data;
import entity.EntityEmployee;
import interfacee.iEmployee;

public class Employee implements iEmployee{
	
	EntityEmployee etS = new EntityEmployee();
    private Data dataAccess;

    public Employee(Data dataAccess) {
        this.dataAccess = dataAccess;
    }
	
	@Override
	public void addEmployee(String FullName, String birthDate, String Gender, String Department, Float Salary,
			String Address) {
		String sql = "INSERT INTO Employee (FullName, birthDate, Gender, Department , Salary, Address ) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, FullName);
            ps.setString(2, birthDate);
            ps.setString(3, Gender);
            ps.setString(4, Department);
            ps.setFloat(5, Salary);
            ps.setString(6, Address);
            ps.executeUpdate();
            System.out.println("Successfully added employee!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void updateEmployee(int EmployeeID, String FullName, String birthDate, String Gender, String Department,
			Float Salary, String Address) {
		 String sql = "UPDATE Employee SET FullName = ?, birthDate = ?, Gender = ?, Department = ?, Salary = ?, Address = ? WHERE EmployeeID = ?";
	        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
	        	ps.setString(1, FullName);  
	        	ps.setString(2, birthDate);      
	        	ps.setString(3, Gender);
	        	ps.setString(4, Department);   
	        	ps.setFloat(5, Salary); 
	        	ps.setString(6,Address);
	        	ps.setInt(7, EmployeeID);
	            ps.executeUpdate();
	            System.out.println("Successfully updated employee!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void deleteEmployee(int EmployeeID) {
		 String sql = "DELETE FROM Employee WHERE EmployeeID = ?";
	        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
	            ps.setInt(1, EmployeeID);
	            ps.executeUpdate();
	            System.out.println("Successfully deleted employee!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void showEmployee() {
		String sql = "SELECT * FROM Employee";
        System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-25s | %-10s | %-25s |%n", "EmployeeID", "FullName", "birthDate", "Gender", "Department", "Salary" ,"Address");
        System.out.println("|------------|----------------------|-----------------|------------------------------|------------------------------|------------------------------|");
        try (Statement stmt = dataAccess.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int EmployeeID = rs.getInt("EmployeeID");
                String FullName = rs.getString("FullName");
                String birthDate = rs.getString("birthDate");
                String Gender = rs.getString("Gender");
                String Department = rs.getString("Department");
                Float Salary = rs.getFloat("Salary");
                String Address = rs.getString("Address");
                System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-25s | %-10s | %-25s | |%n", EmployeeID, FullName, birthDate, Gender, Department, Salary, Address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
