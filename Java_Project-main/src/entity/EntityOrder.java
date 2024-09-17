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


    // Constructor
    public EntityOrder(int orderID, int customerID, String orderDate, double totalAmount, String shippingAddress, String paymentStatus) {
        super();
        this.OrderID = orderID;
        this.CustomerID = customerID;
        this.OrderDate = orderDate;
        this.TotalAmount = totalAmount;
        this.ShippingAddress = shippingAddress;
        this.PaymentStatus = paymentStatus;
    }

    // Getter và Setter

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        this.OrderID = orderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        this.OrderDate = orderDate;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.TotalAmount = totalAmount;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.ShippingAddress = shippingAddress;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.PaymentStatus = paymentStatus;
    }
}
