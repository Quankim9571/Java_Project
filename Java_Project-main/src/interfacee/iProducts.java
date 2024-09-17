/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacee;

/**
 *
 * @author admin
 */
public interface iProducts {
    void addProducts(String ProductName, int CategoryID, int Size, String Color, Double Price,int StockQuantity);
    void updateProducts(int ProductID, String ProductName, int CategoryID, int Size, String Color, Double Price,int StockQuantity);
    void deleteProducts(int ProductID);
    void showProducts();
}
