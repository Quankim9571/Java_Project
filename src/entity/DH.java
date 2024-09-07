package entity;

public class DH {
    
    private int donhangID;
    private int khachhangID;
    private String ngaydat;
    private double tongsotien;

    public DH() {
        super();
    }
    
    public DH(int donhangID, int khachhangID, String ngaydat, double tongsotien) {
        this.donhangID = donhangID;
        this.khachhangID = khachhangID;
        this.ngaydat = ngaydat;
        this.tongsotien = tongsotien;
    }
 
    // Getters and Setters
    public int getdonhangID() {
        return donhangID;
    }

    public void setdonhangID(int donhangID) {
        this.donhangID = donhangID;
    }

    public int getkhachhangID() {
        return khachhangID;
    }

    public void setkhachhangID(int khachhangID) {
        this.khachhangID = khachhangID;
    }

    public String getngaydat() {
        return ngaydat;
    }

    public void setngaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public double gettongsotien() {
        return tongsotien;
    }

    public void settongsotien(double tongsotien) {
        this.tongsotien = tongsotien;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP=" + donhangID +
                ", tenSP='" + khachhangID + '\'' +
                ", gia=" + ngaydat +
                ", soLuong=" + tongsotien +
                '}';
    }
}

