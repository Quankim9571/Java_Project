package mainn;

import classs.KhachHang;
import interfacee.iKhachHang;
import classs.DonHang;
import java.util.Scanner;
import database.Data;
import interfacee.iDonHang;
import java.sql.SQLException;
import classs.NhanVien;
import interfacee.iNhanVien;
import classs.Kho;
import interfacee.iKho;
import classs.SanPham;
import interfacee.iSanPham;
import entity.DH;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data dataAccess = null;
        iDonHang idonHang = null;
        iKhachHang ikhachHang = null;
        iNhanVien inhanVien = null;
        iKho ikho = null;
        iSanPham isanPham = null;

        try {
            dataAccess = new Data();
            idonHang = new DonHang(dataAccess);
            ikhachHang = new KhachHang(dataAccess);
            inhanVien = new NhanVien(dataAccess);
            ikho = new Kho(dataAccess);
            isanPham = new SanPham(dataAccess);

            while (true) {
                System.out.println("1. Quản lý Đơn hàng");
                System.out.println("2. Quản lý Khách hàng");
                System.out.println("3. Quản lý Nhân viên");
                System.out.println("4. Quản lý Sản phẩm");
                System.out.println("5. Quản lý Kho");
                System.out.println("6. Thoát");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        QLDonHang(scanner, idonHang);
                        break;
                    case 2:
                        QLKhachHang(scanner, ikhachHang);
                        break;
                    case 3:
                        QLNhanVien(scanner, inhanVien);
                        break;
                    case 4:
                        QLSanPham(scanner, isanPham);
                        break;
                    case 5:
                        QLKho(scanner, ikho);
                        break;
                    case 6:
                        System.out.println("Thoát chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (dataAccess != null) {
                try {
                    dataAccess.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void QLDonHang(Scanner scanner, iDonHang idonHang) {
        DH donhang = new DH();
        while (true) {
            System.out.println("Chọn mục quản lý Đơn hàng:");
            System.out.println("1. Xem đơn hàng");
            System.out.println("2. Thêm đơn hàng");
            System.out.println("3. Sửa đơn hàng");
            System.out.println("4. Xóa đơn hàng");
            System.out.println("5. Quay lại menu chính");

            int subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    idonHang.hienThiDonHang();
                    break;
                case 2:
                    // Thêm đơn hàng
                    System.out.print("Nhập ID khách hàng: ");
                    donhang.setkhachhangID(scanner.nextInt());
                    scanner.nextLine(); // Đọc ký tự xuống dòng còn lại sau khi nhập số

                    System.out.print("Nhập ngày đặt hàng (yyyy-mm-dd): ");
                    donhang.setngaydat(scanner.nextLine());

                    System.out.print("Nhập tổng số tiền: ");
                    donhang.settongsotien(scanner.nextDouble());
                    idonHang.themDonHang(donhang.getkhachhangID(), donhang.getngaydat(), donhang.gettongsotien());
                    break;
                case 3:
                    // Sửa đơn hàng
                    System.out.print("Nhập ID đơn hàng cần sửa: ");
                    donhang.setdonhangID(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Nhập ID khách hàng mới: ");
//                khachhangID = scanner.nextInt();
                    donhang.setkhachhangID(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Nhập ngày đặt hàng mới (yyyy-mm-dd): ");
                    donhang.setngaydat(scanner.nextLine());

                    System.out.print("Nhập tổng số tiền mới: ");
                    donhang.settongsotien(scanner.nextDouble());
                    idonHang.suaDonHang(donhang.getdonhangID(), donhang.getkhachhangID(), donhang.getngaydat(), donhang.gettongsotien());
                    break;
                case 4:
                    // Xóa đơn hàng
                    System.out.print("Nhập ID đơn hàng cần xóa: ");
                    donhang.setdonhangID(scanner.nextInt());

                    idonHang.xoaDonHang(donhang.getdonhangID());
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            System.out.println();
        }
    }

    private static void QLKhachHang(Scanner scanner, iKhachHang ikhachHang) {
        while (true) {
            System.out.println("Chọn mục quản lý Khách hàng:");
            System.out.println("1. Xem khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Quay lại menu chính");

            int subChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (subChoice) {
                case 1:
                    ikhachHang.hienThiKhachHang();
                    break;
                case 2:
                    System.out.println("Nhập Tên khách hàng:");
                    String khachhangName = scanner.nextLine();
                    System.out.println("Nhập Thông tin liên hệ:");
                    String thongtinlienhe = scanner.nextLine();
                    System.out.println("Nhập Địa chỉ:");
                    String diachi = scanner.nextLine();
                    ikhachHang.themKhachHang(khachhangName, thongtinlienhe, diachi);
                    break;
                case 3:
                    System.out.println("Nhập KhachhangID:");
                    int khachhangID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Nhập Tên khách hàng:");
                    khachhangName = scanner.nextLine();
                    System.out.println("Nhập Thông tin liên hệ:");
                    thongtinlienhe = scanner.nextLine();
                    System.out.println("Nhập Địa chỉ:");
                    diachi = scanner.nextLine();
                    ikhachHang.suaKhachHang(khachhangID, khachhangName, thongtinlienhe, diachi);
                    break;
                case 4:
                    System.out.println("Nhập KhachhangID:");
                    khachhangID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    ikhachHang.xoaKhachHang(khachhangID);
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            System.out.println();
        }
    }

    private static void QLNhanVien(Scanner scanner, iNhanVien iNhanVien) {
        while (true) {
            System.out.println("Chọn mục quản lý Nhân viên:");
            System.out.println("1. Xem nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Sửa nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Quay lại menu chính");

            int subChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (subChoice) {
                case 1:
                    iNhanVien.hienThiNhanVien();
                    break;
                case 2:
                    System.out.println("Nhập tên nhân viên:");
                    String nhanvienName = scanner.nextLine();
                    System.out.println("Nhập vị trí:");
                    String vitri = scanner.nextLine();
                    System.out.println("Nhập thông tin liên hệ:");
                    String thongtinlienhe = scanner.nextLine();
                    iNhanVien.themNhanVien(nhanvienName, vitri, thongtinlienhe);
                    break;
                case 3:
                    System.out.println("Nhập ID nhân viên cần sửa:");
                    int nhanvienID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Nhập tên mới cho nhân viên:");
                    nhanvienName = scanner.nextLine();
                    System.out.println("Nhập vị trí mới:");
                    vitri = scanner.nextLine();
                    System.out.println("Nhập thông tin liên hệ mới:");
                    thongtinlienhe = scanner.nextLine();
                    iNhanVien.suaNhanVien(nhanvienID, nhanvienName, vitri, thongtinlienhe);
                    break;
                case 4:
                    System.out.println("Nhập ID nhân viên cần xóa:");
                    nhanvienID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    iNhanVien.xoaNhanVien(nhanvienID);
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
            System.out.println();
        }
    }

    private static void QLSanPham(Scanner scanner, iSanPham iSanPham) {
        while (true) {
            System.out.println("Chọn mục quản lý Sản phẩm:");
            System.out.println("1. Xem sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Quay lại menu chính");

            int subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    iSanPham.hienThiSanPham();
                    break;
                case 2:
                    System.out.print("Nhập tên sản phẩm: ");
                    scanner.nextLine(); // consume newline
                    String sanphamName = scanner.nextLine();
                    System.out.print("Nhập loại sản phẩm: ");
                    String loai = scanner.next();
                    System.out.print("Nhập giá: ");
                    double gia = scanner.nextDouble();
                    System.out.print("Nhập số lượng còn: ");
                    int soluongcon = scanner.nextInt();
                    iSanPham.themSanPham(sanphamName, loai, gia, soluongcon);
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    int sanphamID = scanner.nextInt();
                    System.out.print("Nhập tên sản phẩm mới: ");
                    scanner.nextLine(); // consume newline
                    sanphamName = scanner.nextLine();
                    System.out.print("Nhập loại sản phẩm mới: ");
                    loai = scanner.next();
                    System.out.print("Nhập giá mới: ");
                    gia = scanner.nextDouble();
                    System.out.print("Nhập số lượng còn mới: ");
                    soluongcon = scanner.nextInt();
                    iSanPham.suaSanPham(sanphamID, sanphamName, loai, gia, soluongcon);
                    break;
                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    int deleteSanphamID = scanner.nextInt();
                    iSanPham.xoaSanPham(deleteSanphamID);
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void QLKho(Scanner scanner, iKho ikho) {
        while (true) {
            System.out.println("Chọn mục quản lý Kho:");
            System.out.println("1. Xem kho");
            System.out.println("2. Thêm kho");
            System.out.println("3. Sửa kho");
            System.out.println("4. Xóa kho");
            System.out.println("5. Quay lại menu chính");

            int subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    ikho.hienThiKho();
                    break;
                case 2:
                    System.out.print("Nhập SanphamID: ");
                    int sanphamID = scanner.nextInt();
                    System.out.print("Nhập Số lượng: ");
                    int soluong = scanner.nextInt();
                    System.out.print("Nhập Ngày nhập (YYYY-MM-DD): ");
                    String ngaynhap = scanner.next();
                    ikho.themKho(sanphamID, soluong, ngaynhap);
                    break;
                case 3:
                    System.out.print("Nhập KhoID cần sửa: ");
                    int khoID = scanner.nextInt();
                    System.out.print("Nhập SanphamID mới: ");
                    sanphamID = scanner.nextInt();
                    System.out.print("Nhập Số lượng mới: ");
                    soluong = scanner.nextInt();
                    System.out.print("Nhập Ngày nhập mới (YYYY-MM-DD): ");
                    ngaynhap = scanner.next();
                    ikho.suaKho(khoID, sanphamID, soluong, ngaynhap);
                    break;
                case 4:
                    System.out.print("Nhập KhoID cần xóa: ");
                    int deleteKhoID = scanner.nextInt();
                    ikho.xoaKho(deleteKhoID);
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
