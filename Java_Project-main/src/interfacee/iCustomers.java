/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacee;

import java.sql.Date;

/**
 *
 * @author admin
 */
public interface iCustomers {
    void addCustomer(String FullName, String Email, String PhoneNumber, String Address, Date DateOfBirth);
    void updateCustomer(int CustomerID, String FullName, String Email, String PhoneNumber, String Address, Date DateOfBirth);
    void deleteCustomer(int CustomerID);
    void showCustomer();
}
