/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacee;

public interface iSanPham {
    void themSanPham(String sanphamName, String loai, double gia, int soluongcon);
    void suaSanPham(int sanphamID, String sanphamName, String loai, double gia, int soluongcon);
    void xoaSanPham(int sanphamID);
    void hienThiSanPham();
}
