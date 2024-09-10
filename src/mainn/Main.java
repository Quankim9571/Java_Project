package mainn;

import classs.Customers;
import interfacee.iCategories;
import interfacee.iCustomers;
import classs.DonHang;
import java.util.Scanner;
import database.Data;
import interfacee.iDonHang;

import java.sql.Date;
import java.sql.SQLException;
import classs.NhanVien;
import classs.Order;
import classs.Payment;
import interfacee.iNhanVien;
import interfacee.iOrder;
import interfacee.iPayment;
import classs.Kho;
import interfacee.iKho;
import classs.SanPham;
import classs.Suppliers;
import interfacee.iSanPham;
import interfacee.iSuppliers;
import entity.DH;
import entity.EntityCategories;
import entity.EntityCustomers;
import entity.EntityOrder;
import entity.EntitySupplier;
import classs.Categories;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data dataAccess = null;
        iDonHang idonHang = null;
        iCustomers ikhachHang = null;
        iNhanVien inhanVien = null;
        iKho ikho = null;
        iSanPham isanPham = null;
        iSuppliers isupplier = null;
        iCategories icategory = null;
        iOrder iorder = null;
        iPayment ipayment = null;
        try {
            dataAccess = new Data();
            idonHang = new DonHang(dataAccess);
            ikhachHang = new Customers(dataAccess);
            inhanVien = new NhanVien(dataAccess);
            ikho = new Kho(dataAccess);
            isanPham = new SanPham(dataAccess);
            isupplier = new Suppliers(dataAccess);
            icategory = new Categories(dataAccess);
            iorder = new Order(dataAccess);
            ipayment = new Payment(dataAccess);
            while (true) {
                System.out.println("1. Quản lý Đơn hàng");
                System.out.println("2. Quản lý Khách hàng");
                System.out.println("3. Quản lý Nhân viên");
                System.out.println("4. Quản lý Sản phẩm");
                System.out.println("5. Quản lý Kho");
                System.out.println("6. Quản lý Nhà Cung Cấp");
                System.out.println("7. Quản lý Loại Hàng");
                System.out.println("8. Quản lý Đơn Hàng");
                System.out.println("9. Quản lý Phương Thức Thanh Toán");
                System.out.println("10. Thoát");

                System.out.print("Chọn chức năng: ");
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
                        QLNCC(scanner, isupplier);
                        break;
                    case 7:
                    	QLLH(scanner, icategory);
                        return;
                    case 8:
                    	QLDH(scanner, iorder);
                        return;
                    case 9:
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

    private static void QLKhachHang(Scanner scanner, iCustomers ikhachHang) {
    	EntityCustomers etS = new EntityCustomers();
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
                    ikhachHang.showCustomer();
                    break;
                case 2:
                    System.out.println("Nhập Tên khách hàng:");
                    etS.setFullName(scanner.nextLine());
                    System.out.println("Nhập email:");
                    etS.setEmail(scanner.nextLine());
                    System.out.println("Nhập số điện thoại:");
                    etS.setPhoneNumber(scanner.nextLine());
                    System.out.println("Nhập địa chỉ:");
                    etS.setAddress(scanner.nextLine());
                    System.out.println("Nhập ngày sinh yy-mm-dd:");
                    etS.setDateOfBirth(Date.valueOf(scanner.nextLine()));
                    if(!etS.getFullName().isEmpty() && !etS.getEmail().isEmpty() && !etS.getPhoneNumber().isEmpty() && !etS.getAddress().isEmpty() && etS.getDateOfBirth() != null) {
                    	ikhachHang.addCustomer(etS.getFullName(), etS.getEmail(), etS.getPhoneNumber(), etS.getAddress(), etS.getDateOfBirth());
                    } else {
                    	System.out.println("Không được để trống!");
                    }
                    
                    break;
                case 3:
                	System.out.println("Nhập id khách hàng:");
                    etS.setCustomerID(scanner.nextInt());
                    scanner.nextLine();
                	System.out.println("Nhập Tên khách hàng:");
                	etS.setFullName(scanner.nextLine());
                    System.out.println("Nhập email:");
                    etS.setEmail(scanner.nextLine());
                    System.out.println("Nhập số điện thoại:");
                    etS.setPhoneNumber(scanner.nextLine());
                    System.out.println("Nhập địa chỉ:");
                    etS.setAddress(scanner.nextLine());
                    System.out.println("Nhập ngày sinh yy-mm-dd:");
                    etS.setDateOfBirth(Date.valueOf(scanner.nextLine()));
                    if( etS.getCustomerID() != 0 && !etS.getFullName().isEmpty() && !etS.getEmail().isEmpty() && !etS.getPhoneNumber().isEmpty() && !etS.getAddress().isEmpty() && etS.getDateOfBirth() != null) {
                    	ikhachHang.updateCustomer(etS.getCustomerID(), etS.getFullName(), etS.getEmail(), etS.getPhoneNumber(), etS.getAddress(), etS.getDateOfBirth());
                    } else {
                    	System.out.println("Không được để trống!");
                    }
                    break;
                case 4:
                    System.out.println("Nhập KhachhangID:");
                    etS.setCustomerID(scanner.nextInt());
                    scanner.nextLine(); 
                    if(etS.getCustomerID() != 0) ikhachHang.deleteCustomer(etS.getCustomerID());
                    else {
                    	System.out.println("Vui long nhap CustomerID");
                    }
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
    
    private static void QLNCC(Scanner scanner, iSuppliers isupplier) {
    	EntitySupplier etS = new EntitySupplier();
        while (true) {
            System.out.println("Chọn mục quản lý Nhà Cung Cấp:");
            System.out.println("1. Xem nhà cung cấp");
            System.out.println("2. Thêm nhà cung cấp");
            System.out.println("3. Sửa nhà cung cấp");
            System.out.println("4. Xóa nhà cung cấp");
            System.out.println("5. Quay lại menu chính");

            int subChoice = scanner.nextInt();
            scanner.nextLine();
            switch (subChoice) {
                case 1:
                    isupplier.showSupplier();
                    break;
                case 2:
					System.out.print("Nhập tên Nhà Cung Cấp: ");
					etS.setSupplierName(scanner.nextLine());
					System.out.print("Nhập thông tin liên lạc: ");
					etS.setContactInfo(scanner.nextLine());
					System.out.print("Nhập địa chỉ: ");
					etS.setAddress(scanner.nextLine());
					if(!etS.getSupplierName().isEmpty() && !etS.getContactInfo().isEmpty() && !etS.getAddress().isEmpty()) {
						isupplier.addSupplier(etS.getSupplierName(), etS.getContactInfo(), etS.getAddress());
					}
					else {
						System.out.println("Vui lòng điền đầy đủ thông tin!");
						System.out.println("---------------------------------");
					}
                    break;
                case 3:
					System.out.print("Nhập SupplierID cần sửa: ");
					etS.setSupplierID(scanner.nextInt());
					scanner.nextLine();
					System.out.print("Nhập tên Nhà Cung Cấp cần sửa: ");
					etS.setSupplierName(scanner.nextLine());
					System.out.print("Nhập thông tin liên lạc cần sửa: ");
					etS.setContactInfo(scanner.nextLine());
					System.out.print("Nhập địa chỉ cần sửa: ");
					etS.setAddress(scanner.nextLine());
					if(etS.getSupplierID() != 0 && !etS.getSupplierName().isEmpty() && !etS.getContactInfo().isEmpty() && !etS.getAddress().isEmpty()) {						
						isupplier.updateSupplier(etS.getSupplierID(), etS.getSupplierName(), etS.getContactInfo(), etS.getAddress());
					} else {
						System.out.println("Vui lòng điền đầy đủ thông tin!");
						System.out.println("---------------------------------");
					}
					break;
                case 4:
                    System.out.print("Nhập SupplerID cần xóa: ");
                    etS.setSupplierID(scanner.nextInt());
                    isupplier.deleteSupplier(etS.getSupplierID());
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
    
    private static void QLLH(Scanner scanner, iCategories icategory) {
    	EntityCategories etC = new EntityCategories();
    	 while (true) {
             System.out.println("Chọn mục quản lý Loại Hàng:");
             System.out.println("1. Xem loại hàng");
             System.out.println("2. Thêm loại hàng");
             System.out.println("3. Sửa loại hàng");
             System.out.println("4. Xóa loại hàng");
             int subChoice = scanner.nextInt();
             scanner.nextLine();
             switch (subChoice) {
                 case 1:
                     icategory.showCategory();
                     break;
                 case 2:
 					System.out.print("Nhập tên Loại Hàng: ");
 					etC.setCategoryName(scanner.nextLine());
 					icategory.addCategory(etC.getCategoryName());
                     break;
                 case 3:
 					System.out.print("Nhập CategoryID cần sửa: ");
 					etC.setCategoryID(scanner.nextInt());
 					scanner.nextLine();
 					System.out.print("Nhập tên Loại Hàng cần sửa: ");
 					etC.setCategoryName(scanner.nextLine());
 					
 					icategory.updateCategory(etC.getCategoryID(), etC.getCategoryName());
 					break;
                 case 4:
                     System.out.print("Nhập CategoryID cần xóa: ");
                     etC.setCategoryID(scanner.nextInt());
                     icategory.deleteCategory(etC.getCategoryID());
                     break;
                 case 5:
                     System.out.println("Quay lại menu chính.");
                     return;
                 default:
                     System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
             }
         }
    }
    
    private static void QLDH(Scanner scanner, iOrder iorder) {
    	EntityOrder etD = new EntityOrder();
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
                    iorder.showOrder();
                    break;
                case 2:
                    System.out.print("Nhập CustomerID: ");
                    etD.setCustomerID(scanner.nextInt());
                    System.out.print("Nhập Ngày đặt hàng (YYYY-MM-DD): ");
                    etD.setOrderDate(scanner.next());
                    System.out.print("Nhập Tổng số tiền: ");
                    etD.setTotalAmount(scanner.nextDouble());
                    System.out.print("Nhập Địa chỉ giao hàng: ");
                    scanner.nextLine(); // Đọc ký tự newline còn lại
                    etD.setShippingAddress(scanner.nextLine());
					System.out.print("Nhập Trạng thái thanh toán: ");
					etD.setPaymentStatus(scanner.nextLine());
					if (etD.getCustomerID() != 0 && etD.getOrderDate() != null && etD.getTotalAmount() != 0
							&& !etD.getShippingAddress().isEmpty() && !etD.getPaymentStatus().isEmpty()) {
						iorder.addOrder(etD.getCustomerID(), etD.getOrderDate(), etD.getTotalAmount(),
								etD.getShippingAddress(), etD.getPaymentStatus());
					} else {
						System.out.println("Vui lòng điền đầy đủ thông tin!");
					}

                    break;
                case 3:
                    System.out.print("Nhập OrderID cần sửa: ");
                    etD.setOrderID(scanner.nextInt());
                    System.out.print("Nhập CustomerID mới: ");
                    etD.setCustomerID(scanner.nextInt());
                    System.out.print("Nhập Ngày đặt hàng mới (YYYY-MM-DD): ");
                    etD.setOrderDate(scanner.next());
                    System.out.print("Nhập Tổng số tiền mới: ");
                    etD.setTotalAmount(scanner.nextDouble());
                    System.out.print("Nhập Địa chỉ giao hàng mới: ");
                    scanner.nextLine(); // Đọc ký tự newline còn lại
                    etD.setShippingAddress(scanner.nextLine());
                    System.out.print("Nhập Trạng thái thanh toán mới: ");
                    etD.setPaymentStatus(scanner.nextLine());
                    iorder.updateOrder(etD.getOrderID(), etD.getCustomerID(), etD.getOrderDate(), etD.getTotalAmount(), etD.getShippingAddress(), etD.getPaymentStatus());
                    break;
                case 4:
                    System.out.print("Nhập OrderID cần xóa: ");
                    etD.setOrderID(scanner.nextInt());
                    iorder.deleteOrder(etD.getOrderID());
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
