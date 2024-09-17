package mainn;

import classs.Customers;
import interfacee.iCategories;
import interfacee.iCustomers;
import java.util.Scanner;
import database.Data;
import java.sql.Date;
import java.sql.SQLException;
import classs.Suppliers;
import interfacee.iSuppliers;
import entity.EntityCategories;
import entity.EntityCustomers;
import classs.Categories;
import classs.Order;
import classs.OrderDetails;
import classs.Products;
import entity.EntityOrder;
import entity.EntityOrderDetails;
import entity.EntityProducts;
import interfacee.iOrder;
import interfacee.iOrderDetails;
import interfacee.iProducts;
        
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data dataAccess = null;
        iCustomers icustomer = null;
        iSuppliers isupplier = null;
        iCategories icategory = null;
        iOrder iorder = null;
        iProducts iproducts = null;
        iOrderDetails iorderDetails = null;
        try {
            dataAccess = new Data();
            icustomer = new Customers(dataAccess);
            isupplier = new Suppliers(dataAccess);
            icategory = new Categories(dataAccess);
            iorder = new Order(dataAccess);
            iproducts = new Products(dataAccess);
            iorderDetails = new OrderDetails(dataAccess);
            
            while (true) {
                System.out.println("1. Quản lý Loại Hàng");
                System.out.println("2. Quản lý Khách Hàng");
                System.out.println("3. Quản lý Đơn Hàng");              
                System.out.println("4. Quản lý Sản Phẩm");
                System.out.println("5. Quản lý Nhà Cung Cấp");
                System.out.println("6. Quản lý Chi Tiết Đơn Hàng");              
                System.out.println("7. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        QLLH(scanner,icategory );
                        break;
                    case 2:
                        QLKH(scanner, icustomer);
                        break;
                    case 3:
                        QLDH(scanner,iorder );
                        break;                    
                    case 4:
                        QLSP(scanner,iproducts );
                        break;
                    case 5:
                        QLNCC(scanner, isupplier);
                        break;
                    case 6:
                    	QLCTDH(scanner, iorderDetails);
                        break;                                     
                    case 7:
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
    private static void QLKH(Scanner scanner, iCustomers ikhachHang) {
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
                    ikhachHang.addCustomer(etS.getFullName(), etS.getEmail(), etS.getPhoneNumber(), etS.getAddress(), etS.getDateOfBirth());
                    break;
                case 3:
                    System.out.println("Nhập id khách hàng:");
                    etS.setCustomerID(scanner.nextInt());
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
                    ikhachHang.updateCustomer(etS.getCustomerID(), etS.getFullName(), etS.getEmail(), etS.getPhoneNumber(), etS.getAddress(), etS.getDateOfBirth());
                    break;
                case 4:
                    System.out.println("Nhập KhachhangID:");
                    etS.setCustomerID(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    ikhachHang.deleteCustomer(etS.getCustomerID());
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

    private static void QLNCC(Scanner scanner, iSuppliers isupplier) {
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
                    String supplierName = scanner.nextLine();
                    System.out.print("Nhập thông tin liên lạc: ");
                    String contactInfo = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    isupplier.addSupplier(supplierName, contactInfo, address);
                    break;
                case 3:
                    System.out.print("Nhập SupplierID cần sửa: ");
                    int supplierID = scanner.nextInt();
                    System.out.print("Nhập tên Nhà Cung Cấp cần sửa: ");
                    supplierName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Nhập thông tin liên lạc cần sửa: ");
                    contactInfo = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Nhập địa chỉ cần sửa: ");
                    address = scanner.nextLine();
                    isupplier.updateSupplier(supplierID, supplierName, contactInfo, address);
                    break;
                case 4:
                    System.out.print("Nhập SupplerID cần xóa: ");
                    supplierID = scanner.nextInt();
                    isupplier.deleteSupplier(supplierID);
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
    
    private static void QLSP(Scanner scanner, iProducts iproducts) {
            	EntityProducts etP = new EntityProducts();

        while (true) {
            System.out.println("Chọn mục quản lý Sản phẩm:");
            System.out.println("1. Xem Sản phẩm");
            System.out.println("2. Thêm Sản phẩm");
            System.out.println("3. Sửa Sản phẩm");
            System.out.println("4. Xóa Sản phẩm");
            System.out.println("5. Quay lại menu chính");

            int subChoice = scanner.nextInt();
            scanner.nextLine();

            switch (subChoice) {
                case 1:
                    iproducts.showProducts();
                    break;
                case 2:
                    System.out.print("Nhập tên áo: ");
                    etP.setProductName(scanner.nextLine());
                    System.out.print("Nhập ID quần áo: ");
                    etP.setCategoryID(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Nhập kích cỡ: ");
                    etP.setSize(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Nhập màu : ");
                    etP.setColor(scanner.nextLine());    
                    System.out.print("Nhập giá : ");
                    etP.setPrice(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.print("Nhập số lượng còn : ");
                    etP.setStockQuantity(scanner.nextInt());  
                    scanner.nextLine();
                    iproducts.addProducts(etP.getProductName(), etP.getCategoryID(), etP.getSize(), etP.getColor(), etP.getPrice(), etP.getStockQuantity());
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    etP.setProductID(scanner.nextInt());
                    scanner.nextLine();  // Tiêu thụ ký tự xuống dòng sau nextInt()
                    System.out.print("Nhập tên sản phẩm mới: ");
                    etP.setProductName(scanner.nextLine());
                    System.out.print("Nhập ID quần áo mới: ");
                    etP.setCategoryID(scanner.nextInt());
                    scanner.nextLine();  // Tiêu thụ ký tự xuống dòng
                    System.out.print("Nhập kích cỡ mới: ");
                    etP.setSize(scanner.nextInt());
                    scanner.nextLine();  // Tiêu thụ ký tự xuống dòng
                    System.out.print("Nhập màu mới: ");
                    etP.setColor(scanner.nextLine());
                    System.out.print("Nhập giá mới: ");
                    etP.setPrice(scanner.nextDouble());
                    scanner.nextLine();  // Tiêu thụ ký tự xuống dòng
                    System.out.print("Nhập số lượng còn mới: ");
                    etP.setStockQuantity(scanner.nextInt());
                    scanner.nextLine();  // Tiêu thụ ký tự xuống dòng
                    iproducts.updateProducts(etP.getProductID(), etP.getProductName(), etP.getCategoryID(), etP.getSize(), etP.getColor(), etP.getPrice(), etP.getStockQuantity());
                    System.out.println("Sản phẩm đã được cập nhật.");
                break;
                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    etP.setProductID(scanner.nextInt());
                    scanner.nextLine();
                    iproducts.deleteProducts(etP.getProductID());
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
    
    private static void QLCTDH(Scanner scanner, iOrderDetails iorderDetails) {
    EntityOrderDetails etOD = new EntityOrderDetails(); // Khởi tạo với giá trị mặc định

    while (true) {
        System.out.println("Chọn mục quản lý Chi tiết Đơn hàng:");
        System.out.println("1. Xem Chi tiết Đơn hàng");
        System.out.println("2. Thêm Chi tiết Đơn hàng");
        System.out.println("3. Sửa Chi tiết Đơn hàng");
        System.out.println("4. Xóa Chi tiết Đơn hàng");
        System.out.println("5. Quay lại menu chính");

        int subChoice = scanner.nextInt();
        scanner.nextLine();

        switch (subChoice) {
            case 1:
                iorderDetails.showOrderDetails();
                break;
            case 2:
                System.out.print("Nhập ID đơn hàng: ");
                etOD.setOrderID(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Nhập ID sản phẩm: ");
                etOD.setProductID(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Nhập số lượng: ");
                etOD.setQuantity(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Nhập đơn giá: ");
                etOD.setUnitPrice(scanner.nextDouble());
                scanner.nextLine();
                iorderDetails.addOrderDetail(etOD.getOrderID(), etOD.getProductID(), etOD.getQuantity(), etOD.getUnitPrice());
                break;
            case 3:
                System.out.print("Nhập ID Chi tiết Đơn hàng cần sửa: ");
                etOD.setOrderDetailID(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Nhập ID đơn hàng mới: ");
                etOD.setOrderID(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Nhập ID sản phẩm mới: ");
                etOD.setProductID(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Nhập số lượng mới: ");
                etOD.setQuantity(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Nhập đơn giá mới: ");
                etOD.setUnitPrice(scanner.nextDouble());
                scanner.nextLine();
                iorderDetails.updateOrderDetail(etOD.getOrderDetailID(), etOD.getOrderID(), etOD.getProductID(), etOD.getQuantity(), etOD.getUnitPrice());
                System.out.println("Chi tiết Đơn hàng đã được cập nhật.");
                break;
            case 4:
                System.out.print("Nhập ID Chi tiết Đơn hàng cần xóa: ");
                etOD.setOrderDetailID(scanner.nextInt());
                scanner.nextLine();
                iorderDetails.deleteOrderDetail(etOD.getOrderDetailID());
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
