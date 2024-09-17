/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacee;

/**
 *
 * @author admin
 */
public interface iOrder {
    void addOrder(int CustomerID, String OrderDate, double TotalAmount, String ShippingAddress, String PaymentStatus);
    void updateOrder(int OrderID, int CustomerID, String OrderDate, double TotalAmount, String ShippingAddress, String PaymentStatus);
    void deleteOrder(int OrderID);
    void showOrder();
}
