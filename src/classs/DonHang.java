package classs;

import java.sql.*;
import database.Data;
import interfacee.iDonHang;
import java.util.Scanner;
/**
 *
 * @author trinh
 */
public class DonHang implements iDonHang {
    
    private Data dataAccess;

    public DonHang(Data dataAccess) {
        this.dataAccess = dataAccess;
    }

    
    @Override
    public void themDonHang(int khachhangID, String ngaydat, double tongsotien) {
        String sql = "INSERT INTO DonHang (KhachhangID, Ngaydat, Tongsotien) VALUES (?, ?, ?)";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, khachhangID);
            ps.setDate(2, java.sql.Date.valueOf(ngaydat)); // Chuyển đổi từ String thành java.sql.Date
            ps.setDouble(3, tongsotien);
            ps.executeUpdate();
            System.out.println("Đơn hàng đã được thêm thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaDonHang(int donhangID, int khachhangID, String ngaydat, double tongsotien) {
        String sql = "UPDATE DonHang SET KhachhangID = ?, Ngaydat = ?, Tongsotien = ? WHERE DonhangID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, khachhangID);
            ps.setDate(2, java.sql.Date.valueOf(ngaydat)); // Chuyển đổi từ String thành java.sql.Date
            ps.setDouble(3, tongsotien);
            ps.setInt(4, donhangID);
            ps.executeUpdate();
            System.out.println("Đơn hàng đã được cập nhật thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaDonHang(int donhangID) {
        String sql = "DELETE FROM DonHang WHERE DonhangID = ?";
        try (PreparedStatement ps = dataAccess.getConnection().prepareStatement(sql)) {
            ps.setInt(1, donhangID);
            ps.executeUpdate();
            System.out.println("Đơn hàng đã được xóa thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void hienThiDonHang() {
        String sql = "SELECT * FROM DonHang";
        
        System.out.printf("| %-10s | %-10s | %-10s | %-12s |%n", "DonhangID", "KhachhangID", "Ngaydat", "Tongsotien");
        System.out.println("|------------|-------------|------------|--------------|");
        try (Statement stmt = dataAccess.getConnection().createStatement();
                
                
            ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                int donhangID = rs.getInt("DonhangID");
                int khachhangID = rs.getInt("KhachhangID");
                String ngaydat = rs.getString("Ngaydat");
                double tongsotien = rs.getDouble("Tongsotien");
            System.out.printf("| %-10d | %-10d  | %-10s | %-12.2f |%n", donhangID, khachhangID, ngaydat, tongsotien);}
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    

