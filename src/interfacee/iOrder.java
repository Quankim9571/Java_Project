package interfacee;

public interface iOrder {
	void addOrder(int CustomerID ,String OrderDate, double TotalAmount, String ShippingAddress, String PaymentStatus);
    void updateOrder(int OrderID, int CustomerID, String OrderDate, double TotalAmount, String ShippingAddress, String PaymentStatus);
    void deleteOrder(int OrderID);
    void showOrder();
}
