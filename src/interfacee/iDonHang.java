package interfacee;


public interface iDonHang {
    void themDonHang(int KhachhangID, String ngaydat, double tongsotien);
    void suaDonHang(int donhangID, int KhachhangID, String ngaydat, double tongsotien);
    void xoaDonHang(int donhangID);
    void hienThiDonHang();

}
