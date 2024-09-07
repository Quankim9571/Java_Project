/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classs;

import database.Data;
import interfacee.iSanPham;
import java.sql.*;

public class SanPham implements iSanPham {
    
    private Data dataAccess;

    public SanPham(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void themSanPham(String sanphamName, String loai, double gia, int soluongcon) {
        String sql = "INSERT INTO SanPham (SanphamName, Loai, Gia, Soluongcon) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, sanphamName);
            ps.setString(2, loai);
            ps.setDouble(3, gia);
            ps.setInt(4, soluongcon);
            ps.executeUpdate();
            System.out.println("Sản phẩm đã được thêm thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaSanPham(int sanphamID, String sanphamName, String loai, double gia, int soluongcon) {
        String sql = "UPDATE SanPham SET SanphamName = ?, Loai = ?, Gia = ?, Soluongcon = ? WHERE SanphamID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, sanphamName);
            ps.setString(2, loai);
            ps.setDouble(3, gia);
            ps.setInt(4, soluongcon);
            ps.setInt(5, sanphamID);
            ps.executeUpdate();
            System.out.println("Sản phẩm đã được cập nhật thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaSanPham(int sanphamID) {
        String sql = "DELETE FROM SanPham WHERE SanphamID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, sanphamID);
            ps.executeUpdate();
            System.out.println("Sản phẩm đã được xóa thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hienThiSanPham() {
        String sql = "SELECT * FROM SanPham";
        System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s |%n", "SanphamID", "SanphamName", "Loai", "Gia", "Soluongcon");
        System.out.println("|------------|----------------------|------------|------------|------------|");
        try (Statement stmt = dataAccess.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int sanphamID = rs.getInt("SanphamID");
                String sanphamName = rs.getString("SanphamName");
                String loai = rs.getString("Loai");
                double gia = rs.getDouble("Gia");
                int soluongcon = rs.getInt("Soluongcon");
                System.out.printf("| %-10d | %-20s | %-10s | %-10.2f | %-10d |%n", sanphamID, sanphamName, loai, gia, soluongcon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
