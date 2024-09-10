package entity;

public class EntityPayments {
	private int PaymentID;
	private int OrderID;
	private String PaymentMethod;
	private String PaymentDate;
	public EntityPayments() {
		super();
	}
	public EntityPayments(int paymentID, int orderID, String paymentMethod, String paymentDate) {
		super();
		PaymentID = paymentID;
		OrderID = orderID;
		PaymentMethod = paymentMethod;
		PaymentDate = paymentDate;
	}
	public int getPaymentID() {
		return PaymentID;
	}
	public void setPaymentID(int paymentID) {
		PaymentID = paymentID;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public String getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	public String getPaymentDate() {
		return PaymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}
	
	
}
