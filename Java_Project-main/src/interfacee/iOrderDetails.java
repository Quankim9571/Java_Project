/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacee;

/**
 *
 * @author admin
 */
public interface iOrderDetails {
    void addOrderDetail(int OrderID, int ProductID, int Quantity, double UnitPrice);
    void updateOrderDetail(int OrderDetailID, int OrderID, int ProductID, int Quantity, double UnitPrice);
    void deleteOrderDetail(int OrderDetailID);
    void showOrderDetails();
}
