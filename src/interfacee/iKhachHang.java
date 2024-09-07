/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacee;

/**
 *
 * @author admin
 */
public interface iKhachHang {
    void themKhachHang(String KhachhangName, String thongtinlienhe, String diachi);
    void suaKhachHang(int khachhangID, String KhachhangName, String thongtinlienhe, String diachi);
    void xoaKhachHang(int khachhangID);
    void hienThiKhachHang();
}
