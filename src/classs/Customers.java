/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classs;

import java.sql.*;
import entity.EntityCustomers;
import database.Data;
import interfacee.iCustomers;
import java.util.Scanner;

public class Customers implements iCustomers {
    EntityCustomers etS = new EntityCustomers();
    private Data dataAccess;

    public Customers(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void addCustomer(String FullName, String Email, String PhoneNumber, String Address, Date DateOfBirth) {
        String sql = "INSERT INTO Customers (FullName, Email, PhoneNumber,Address,DateOfBirth ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, FullName);
            ps.setString(2, Email);
            ps.setString(3, PhoneNumber);
            ps.setString(4, Address);
            ps.setDate(5, DateOfBirth);
            ps.executeUpdate();
            System.out.println("Successfully added customer!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(int CustomerID, String FullName, String Email, String PhoneNumber, String Address, Date DateOfBirth) {
        String sql = "UPDATE Customers SET FullName = ?, Email = ?, PhoneNumber = ?, Address = ?, DateOfBirth = ? WHERE CustomerID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
        	ps.setString(1, FullName);  
        	ps.setString(2, Email);      
        	ps.setString(3, PhoneNumber);
        	ps.setString(4, Address);   
        	ps.setDate(5, DateOfBirth); 
            ps.executeUpdate();
            System.out.println("Successfully updated customer!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int CustomerID) {
        String sql = "DELETE FROM Customers WHERE CustomerID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, CustomerID);
            ps.executeUpdate();
            System.out.println("Successfully deleted customer!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showCustomer() {
        String sql = "SELECT * FROM Customers";
        System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-25s | %-10s |%n", "CustomerID", "FullName", "Email", "PhoneNumber", "Address", "DateOfBirth");
        System.out.println("|------------|----------------------|-----------------|------------------------------|");
        try (Statement stmt = dataAccess.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int CustomerID = rs.getInt("CustomerID");
                String FullName = rs.getString("FullName");
                String Email = rs.getString("Email");
                String PhoneNumber = rs.getString("PhoneNumber");
                String Address = rs.getString("Address");
                String DateOfBirth = rs.getString("DateOfBirth");
                System.out.printf("| %-10s | %-20s | %-30s | %-15s | %-25s | %-10s |%n", CustomerID, FullName, Email, PhoneNumber, Address, DateOfBirth);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}