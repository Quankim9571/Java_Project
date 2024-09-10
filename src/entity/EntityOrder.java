package entity;

public class EntityOrder {
	private int OrderID;
    private int CustomerID;
    private String OrderDate;
    private double TotalAmount;
    private String ShippingAddress;
    private String PaymentStatus;
    
    public EntityOrder() {
    	super();
    }
    
	public EntityOrder(int orderID, int customerID, String orderDate, double totalAmount, String shippingAddress,
			String paymentStatus) {
		super();
		OrderID = orderID;
		CustomerID = customerID;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
		ShippingAddress = shippingAddress;
		PaymentStatus = paymentStatus;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getShippingAddress() {
		return ShippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		ShippingAddress = shippingAddress;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}
    
	
}
