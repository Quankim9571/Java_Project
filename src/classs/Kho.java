/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classs;

import database.Data;
import interfacee.iKho;
import java.sql.*;

public class Kho implements iKho {
    
    private Data dataAccess;

    public Kho(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void themKho(int sanphamID, int soluong, String ngaynhap) {
        String sql = "INSERT INTO Kho (SanphamID, Soluong, Ngaynhap) VALUES (?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, sanphamID);
            ps.setInt(2, soluong);
            ps.setString(3, ngaynhap);
            ps.executeUpdate();
            System.out.println("Kho đã được thêm thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaKho(int khoID, int sanphamID, int soluong, String ngaynhap) {
        String sql = "UPDATE Kho SET SanphamID = ?, Soluong = ?, Ngaynhap = ? WHERE KhoID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, sanphamID);
            ps.setInt(2, soluong);
            ps.setString(3, ngaynhap);
            ps.setInt(4, khoID);
            ps.executeUpdate();
            System.out.println("Kho đã được cập nhật thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaKho(int khoID) {
        String sql = "DELETE FROM Kho WHERE KhoID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, khoID);
            ps.executeUpdate();
            System.out.println("Kho đã được xóa thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hienThiKho() {
        String sql = "SELECT * FROM Kho";
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |%n", "KhoID", "SanphamID", "Soluong", "Ngaynhap");
        System.out.println("|------------|------------|------------|------------|");
        try (Statement stmt = dataAccess.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int khoID = rs.getInt("KhoID");
                int sanphamID = rs.getInt("SanphamID");
                int soluong = rs.getInt("Soluong");
                String ngaynhap = rs.getString("Ngaynhap");
                System.out.printf("| %-10d | %-10d | %-10d | %-10s |%n", khoID, sanphamID, soluong, ngaynhap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

