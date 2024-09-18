package mainn;

import classs.Customers;
import classs.Employee;
import interfacee.iCategories;
import interfacee.iCustomers;
import java.util.Scanner;
import database.Data;
import interfacee.iEmployee;

import java.sql.Date;
import java.sql.SQLException;
import classs.Order;
import classs.OrderDetails;
import classs.Payment;
import classs.Products;
import interfacee.iOrder;
import interfacee.iOrderDetails;
import interfacee.iPayment;
import interfacee.iProducts;
import classs.Suppliers;
import interfacee.iSuppliers;
import entity.EntityCategories;
import entity.EntityCustomers;
import entity.EntityEmployee;
import entity.EntityOrder;
import entity.EntityOrderDetails;
import entity.EntityPayments;
import entity.EntityProducts;
import entity.EntitySupplier;
import classs.Categories;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Data dataAccess = null;
		iCustomers ikhachHang = null;
		iSuppliers isupplier = null;
		iCategories icategory = null;
		iOrder iorder = null;
		iPayment ipayment = null;
		iOrderDetails iorderDetails = null;
		iProducts iproducts = null;
		iEmployee iemployee = null;
		try {
			dataAccess = new Data();
			ikhachHang = new Customers(dataAccess);
			isupplier = new Suppliers(dataAccess);
			icategory = new Categories(dataAccess);
			iorder = new Order(dataAccess);
			ipayment = new Payment(dataAccess);
			iorderDetails = new OrderDetails(dataAccess);
			iproducts = new Products(dataAccess);
			iemployee = new Employee(dataAccess);
			while (true) {
				System.out.println("1. Quản lý Đơn hàng");
				System.out.println("2. Quản lý Khách hàng");
				System.out.println("3. Quản lý Nhân viên");
				System.out.println("4. Quản lý Sản phẩm");
				System.out.println("5. Quản lý Kho");
				System.out.println("6. Quản lý Nhà Cung Cấp");
				System.out.println("7. Quản lý Loại Hàng");
				System.out.println("8. Quản lý Chi Tiết Đơn hàng");
				System.out.println("9. Quản lý Đơn Hàng");
				System.out.println("10. Quản lý Phương Thức Thanh Toán");
				System.out.println("11. Thoát");

				System.out.print("Chọn chức năng: ");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					QLDH(scanner, iorder);
					break;
				case 2:
					QLKhachHang(scanner, ikhachHang);
					break;
				case 3:
					QLNhanVien(scanner, iemployee);
					break;
				case 4:
					QLSP(scanner, iproducts);
					break;
				case 5:
					System.out.println("Quan lý kho");
//					QLKho(scanner, ikho);
					break;
				case 6:
					QLNCC(scanner, isupplier);
					break;
				case 7:
					QLLH(scanner, icategory);
					return;
				case 8:
					QLCTDH(scanner, iorderDetails);
					return;
				case 9:
					QLPTTT(scanner, ipayment);
					return;
				case 10:
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
				if (!etS.getFullName().isEmpty() && !etS.getEmail().isEmpty() && !etS.getPhoneNumber().isEmpty()
						&& !etS.getAddress().isEmpty() && etS.getDateOfBirth() != null) {
					ikhachHang.addCustomer(etS.getFullName(), etS.getEmail(), etS.getPhoneNumber(), etS.getAddress(),
							etS.getDateOfBirth());
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
				if (etS.getCustomerID() != 0 && !etS.getFullName().isEmpty() && !etS.getEmail().isEmpty()
						&& !etS.getPhoneNumber().isEmpty() && !etS.getAddress().isEmpty()
						&& etS.getDateOfBirth() != null) {
					ikhachHang.updateCustomer(etS.getCustomerID(), etS.getFullName(), etS.getEmail(),
							etS.getPhoneNumber(), etS.getAddress(), etS.getDateOfBirth());
				} else {
					System.out.println("Không được để trống!");
				}
				break;
			case 4:
				System.out.println("Nhập KhachhangID:");
				etS.setCustomerID(scanner.nextInt());
				scanner.nextLine();
				if (etS.getCustomerID() != 0)
					ikhachHang.deleteCustomer(etS.getCustomerID());
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

	private static void QLNhanVien(Scanner scanner, iEmployee iemployee) {
		EntityEmployee employee = new EntityEmployee();
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
				iemployee.showEmployee();
				break;
			case 2:
				System.out.println("Nhập tên nhân viên:");
				employee.setFullName(scanner.nextLine());
				System.out.println("Nhập ngày sinh:");
				employee.setBirthDate(scanner.next());
				System.out.println("Nhập giới tính:");
				employee.setGender(scanner.next());
				System.out.println("Nhập phòng ban:");
				employee.setDepartment(scanner.nextLine());
				System.out.println("Nhập mức lương:");
				employee.setSalary(scanner.nextFloat());
				System.out.println("Nhập địa chỉ:");
				employee.setAddress(scanner.nextLine());
				if (!employee.getFullName().isEmpty() && !employee.getBirthDate().isEmpty()
						&& !employee.getGender().isEmpty() && !employee.getDepartment().isEmpty()
						&& employee.getSalary() != 0 && !employee.getAddress().isEmpty()) {
					iemployee.addEmployee(employee.getFullName(), employee.getBirthDate(), employee.getGender(),
							employee.getDepartment(), employee.getSalary(), employee.getAddress());
				} else {
					System.out.println("Vui lòng điền đủ thông tin");
				}

				break;
			case 3:
				System.out.println("Nhập id nhân viên:");
				employee.setEmployeeID(scanner.nextInt());
				System.out.println("Nhập tên nhân viên:");
				employee.setFullName(scanner.nextLine());
				System.out.println("Nhập ngày sinh:");
				employee.setBirthDate(scanner.next());
				System.out.println("Nhập giới tính:");
				employee.setGender(scanner.next());
				System.out.println("Nhập phòng ban:");
				employee.setDepartment(scanner.nextLine());
				System.out.println("Nhập mức lương:");
				employee.setSalary(scanner.nextFloat());
				System.out.println("Nhập địa chỉ:");
				employee.setAddress(scanner.nextLine());
				if (employee.getEmployeeID() != 0 && !employee.getFullName().isEmpty()
						&& !employee.getBirthDate().isEmpty() && !employee.getGender().isEmpty()
						&& !employee.getDepartment().isEmpty() && employee.getSalary() != 0
						&& !employee.getAddress().isEmpty()) {
					iemployee.updateEmployee(employee.getEmployeeID(), employee.getFullName(), employee.getBirthDate(),
							employee.getGender(), employee.getDepartment(), employee.getSalary(),
							employee.getAddress());
				} else {
					System.out.println("Vui lòng điền đủ thông tin");
				}

				break;
			case 4:
				System.out.println("Nhập ID nhân viên cần xóa:");
				employee.setEmployeeID(scanner.nextInt());
				scanner.nextLine(); // Consume newline
				iemployee.deleteEmployee(employee.getEmployeeID());
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
	/*
	 * private static void QLKho(Scanner scanner, iKho ikho) { while (true) {
	 * System.out.println("Chọn mục quản lý Kho:");
	 * System.out.println("1. Xem kho"); System.out.println("2. Thêm kho");
	 * System.out.println("3. Sửa kho"); System.out.println("4. Xóa kho");
	 * System.out.println("5. Quay lại menu chính");
	 * 
	 * int subChoice = scanner.nextInt();
	 * 
	 * switch (subChoice) { case 1: ikho.hienThiKho(); break; case 2:
	 * System.out.print("Nhập SanphamID: "); int sanphamID = scanner.nextInt();
	 * System.out.print("Nhập Số lượng: "); int soluong = scanner.nextInt();
	 * System.out.print("Nhập Ngày nhập (YYYY-MM-DD): "); String ngaynhap =
	 * scanner.next(); ikho.themKho(sanphamID, soluong, ngaynhap); break; case 3:
	 * System.out.print("Nhập KhoID cần sửa: "); int khoID = scanner.nextInt();
	 * System.out.print("Nhập SanphamID mới: "); sanphamID = scanner.nextInt();
	 * System.out.print("Nhập Số lượng mới: "); soluong = scanner.nextInt();
	 * System.out.print("Nhập Ngày nhập mới (YYYY-MM-DD): "); ngaynhap =
	 * scanner.next(); ikho.suaKho(khoID, sanphamID, soluong, ngaynhap); break; case
	 * 4: System.out.print("Nhập KhoID cần xóa: "); int deleteKhoID =
	 * scanner.nextInt(); ikho.xoaKho(deleteKhoID); break; case 5:
	 * System.out.println("Quay lại menu chính."); return; default:
	 * System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại."); } } }
	 */

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
				if (!etS.getSupplierName().isEmpty() && !etS.getContactInfo().isEmpty()
						&& !etS.getAddress().isEmpty()) {
					isupplier.addSupplier(etS.getSupplierName(), etS.getContactInfo(), etS.getAddress());
				} else {
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
				if (etS.getSupplierID() != 0 && !etS.getSupplierName().isEmpty() && !etS.getContactInfo().isEmpty()
						&& !etS.getAddress().isEmpty()) {
					isupplier.updateSupplier(etS.getSupplierID(), etS.getSupplierName(), etS.getContactInfo(),
							etS.getAddress());
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
				iorder.updateOrder(etD.getOrderID(), etD.getCustomerID(), etD.getOrderDate(), etD.getTotalAmount(),
						etD.getShippingAddress(), etD.getPaymentStatus());
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

	private static void QLPTTT(Scanner scanner, iPayment ipayment) {
		EntityPayments etP = new EntityPayments();
		while (true) {
			System.out.println("Chọn mục quản lý Phương thức thanh toán:");
			System.out.println("1. Xem phương thức thanh toán");
			System.out.println("2. Thêm phương thức thanh toán");
			System.out.println("3. Sửa phương thức thanh toán");
			System.out.println("4. Xóa phương thức thanh toán");
			System.out.println("5. Quay lại menu chính");

			int subChoice = scanner.nextInt();

			switch (subChoice) {
			case 1:
				ipayment.showPayment();
				;
				break;

			case 2:
				System.out.print("Nhập OrderID: ");
				etP.setOrderID(scanner.nextInt());
				scanner.nextLine();
				System.out.print("Nhập phương thức thanh toán: ");
				etP.setPaymentMethod(scanner.nextLine());

				System.out.print("Nhập ngày thanh toán (yy-mm-dd): ");
				etP.setPaymentDate(scanner.next());

				if (etP.getOrderID() != 0 && !etP.getPaymentMethod().isEmpty() && !etP.getPaymentDate().isEmpty()) {
					ipayment.addPayment(etP.getPaymentID(), etP.getOrderID(), etP.getPaymentMethod(),
							etP.getPaymentDate());
				} else {
					System.out.println("Vui lòng điền đầy đủ thông tin!");
				}

				break;

			case 3:
				System.out.print("Nhập PaymentID cần sửa: ");
				etP.setOrderID(scanner.nextInt());
				System.out.print("Nhập OrderID mới: ");
				etP.setOrderID(scanner.nextInt());
				scanner.nextLine();
				System.out.print("Nhập Phương thức thanh toán mới: ");
				etP.setPaymentMethod(scanner.nextLine());
				System.out.print("Nhập Ngày thanh toán (YYYY-MM-DD): ");
				etP.setPaymentDate(scanner.next());

				ipayment.updatePayment(etP.getPaymentID(), etP.getOrderID(), etP.getPaymentMethod(),
						etP.getPaymentDate());
				break;
			/*
			 * case 4: System.out.print("Nhập OrderID cần xóa: ");
			 * etD.setOrderID(scanner.nextInt()); iorder.deleteOrder(etD.getOrderID());
			 * break; case 5: System.out.println("Quay lại menu chính."); return;
			 */
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
				if (etOD.getOrderID() != 0 && etOD.getProductID() != 0 && etOD.getQuantity() != 0
						&& etOD.getUnitPrice() != 0) {
					iorderDetails.addOrderDetail(etOD.getOrderID(), etOD.getProductID(), etOD.getQuantity(),
							etOD.getUnitPrice());
				} else {
					System.out.println("Vui lòng điền đủ thông tin");
				}

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
				if (etOD.getOrderDetailID() != 0 && etOD.getOrderID() != 0 && etOD.getProductID() != 0
						&& etOD.getQuantity() != 0 && etOD.getUnitPrice() != 0) {
					iorderDetails.updateOrderDetail(etOD.getOrderDetailID(), etOD.getOrderID(), etOD.getProductID(),
							etOD.getQuantity(), etOD.getUnitPrice());
				} else {
					System.out.println("Vui lòng điền đủ thông tin");
				}
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
				if (!etP.getProductName().isEmpty() && etP.getCategoryID() != 0 && etP.getSize() != 0
						&& !etP.getColor().isEmpty() && etP.getPrice() != 0 && etP.getStockQuantity() != 0) {
					iproducts.addProducts(etP.getProductName(), etP.getCategoryID(), etP.getSize(), etP.getColor(),
							etP.getPrice(), etP.getStockQuantity());
				} else {
					System.out.println("Vui lòng điền đủ thông tin");
				}

				break;
			case 3:
				System.out.print("Nhập ID sản phẩm cần sửa: ");
				etP.setProductID(scanner.nextInt());
				scanner.nextLine(); // Tiêu thụ ký tự xuống dòng sau nextInt()
				System.out.print("Nhập tên sản phẩm mới: ");
				etP.setProductName(scanner.nextLine());
				System.out.print("Nhập ID quần áo mới: ");
				etP.setCategoryID(scanner.nextInt());
				scanner.nextLine(); // Tiêu thụ ký tự xuống dòng
				System.out.print("Nhập kích cỡ mới: ");
				etP.setSize(scanner.nextInt());
				scanner.nextLine(); // Tiêu thụ ký tự xuống dòng
				System.out.print("Nhập màu mới: ");
				etP.setColor(scanner.nextLine());
				System.out.print("Nhập giá mới: ");
				etP.setPrice(scanner.nextDouble());
				scanner.nextLine(); // Tiêu thụ ký tự xuống dòng
				System.out.print("Nhập số lượng còn mới: ");
				etP.setStockQuantity(scanner.nextInt());
				scanner.nextLine(); // Tiêu thụ ký tự xuống dòng
				if (etP.getProductID() != 0 && !etP.getProductName().isEmpty() && etP.getCategoryID() != 0
						&& etP.getSize() != 0 && !etP.getColor().isEmpty() && etP.getPrice() != 0
						&& etP.getStockQuantity() != 0) {
					iproducts.updateProducts(etP.getProductID(), etP.getProductName(), etP.getCategoryID(),
							etP.getSize(), etP.getColor(), etP.getPrice(), etP.getStockQuantity());
				} else {
					System.out.println("Vui lòng điền đủ thông tin");
				}

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
}
