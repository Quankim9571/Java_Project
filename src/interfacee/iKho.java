/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacee;

public interface iKho {
    void themKho(int sanphamID, int soluong, String ngaynhap);
    void suaKho(int khoID, int sanphamID, int soluong, String ngaynhap);
    void xoaKho(int khoID);
    void hienThiKho();
}
