/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classs;

import database.Data;
import interfacee.iNhanVien;
import java.util.Scanner;
import java.sql.*;

public class NhanVien implements iNhanVien {
    private Data dataAccess;

    public NhanVien(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void themNhanVien(String nhanvienName, String vitri, String thongtinlienhe) {
        String sql = "INSERT INTO NhanVien (NhanvienName, Vitri, Thontinlienhe) VALUES (?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, nhanvienName);
            ps.setString(2, vitri);
            ps.setString(3, thongtinlienhe);
            ps.executeUpdate();
            System.out.println("Nhân viên đã được thêm thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaNhanVien(int nhanvienID, String nhanvienName, String vitri, String thongtinlienhe) {
        String sql = "UPDATE NhanVien SET NhanvienName = ?, Vitri = ?, Thontinlienhe = ? WHERE NhanvienID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setString(1, nhanvienName);
            ps.setString(2, vitri);
            ps.setString(3, thongtinlienhe);
            ps.setInt(4, nhanvienID);
            ps.executeUpdate();
            System.out.println("Thông tin nhân viên đã được cập nhật thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaNhanVien(int nhanvienID) {
        String sql = "DELETE FROM NhanVien WHERE NhanvienID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, nhanvienID);
            ps.executeUpdate();
            System.out.println("Nhân viên đã được xóa thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hienThiNhanVien() {
        String sql = "SELECT * FROM NhanVien";
        System.out.printf("| %-10s | %-20s | %-15s | %-15s |%n", "NhanvienID", "NhanvienName", "Vitri", "Thontinlienhe");
        System.out.println("|------------|----------------------|-----------------|-----------------|");
        try (Statement stmt = dataAccess.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int nhanvienID = rs.getInt("NhanvienID");
                String nhanvienName = rs.getString("NhanvienName");
                String vitri = rs.getString("Vitri");
                String thongtinlienhe = rs.getString("Thontinlienhe");
                System.out.printf("| %-10d | %-20s | %-15s | %-15s |%n", nhanvienID, nhanvienName, vitri, thongtinlienhe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
