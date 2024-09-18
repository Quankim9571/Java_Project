package interfacee;

public interface iOrderDetails {
	void addOrderDetail(int OrderID, int ProductID, int Quantity, double UnitPrice);

	void updateOrderDetail(int OrderDetailID, int OrderID, int ProductID, int Quantity, double UnitPrice);

	void deleteOrderDetail(int OrderDetailID);

	void showOrderDetails();
}
