/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classs;

import java.sql.*;
import database.Data;
import interfacee.iKhachHang;
import java.util.Scanner;

public class KhachHang implements iKhachHang {
    
    private Data dataAccess;

    public KhachHang(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void themKhachHang(String khachhangName, String thongtinlienhe, String diachi) {
        String sql = "INSERT INTO KhachHang (KhachhangName, Thongtinlienhe, Diachi) VALUES (?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, khachhangName);
            ps.setString(2, thongtinlienhe);
            ps.setString(3, diachi);
            ps.executeUpdate();
            System.out.println("Khách hàng đã được thêm thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaKhachHang(int khachhangID, String khachhangName, String thongtinlienhe, String diachi) {
        String sql = "UPDATE KhachHang SET KhachhangName = ?, Thongtinlienhe = ?, Diachi = ? WHERE KhachhangID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, khachhangName);
            ps.setString(2, thongtinlienhe);
            ps.setString(3, diachi);
            ps.setInt(4, khachhangID);
            ps.executeUpdate();
            System.out.println("Khách hàng đã được cập nhật thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaKhachHang(int khachhangID) {
        String sql = "DELETE FROM KhachHang WHERE KhachhangID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, khachhangID);
            ps.executeUpdate();
            System.out.println("Khách hàng đã được xóa thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hienThiKhachHang() {
        String sql = "SELECT * FROM KhachHang";
        System.out.printf("| %-10s | %-20s | %-15s | %-30s |%n", "KhachhangID", "KhachhangName", "Thongtinlienhe", "Diachi");
        System.out.println("|------------|----------------------|-----------------|------------------------------|");
        try (Statement stmt = dataAccess.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int khachhangID = rs.getInt("KhachhangID");
                String khachhangName = rs.getString("KhachhangName");
                String thongtinlienhe = rs.getString("Thongtinlienhe");
                String diachi = rs.getString("Diachi");
                System.out.printf("| %-10d | %-20s | %-15s | %-30s |%n", khachhangID, khachhangName, thongtinlienhe, diachi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}