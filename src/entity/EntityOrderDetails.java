package entity;

public class EntityOrderDetails {
	private int OrderDetailID;
    private int OrderID;
    private int ProductID;
    private int Quantity;
    private double UnitPrice;
    
    public EntityOrderDetails() {
        super();
    }
    
    public EntityOrderDetails(int orderDetailID, int orderID, int productID,
        int quantity, double unitPrice) {
        super(); 
        this.OrderDetailID = orderDetailID;
        this.OrderID = orderID;
        this.ProductID = productID;
        this.Quantity = quantity;
        this.UnitPrice = unitPrice;
    }
    
    public int getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.OrderDetailID = orderDetailID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        this.OrderID = orderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        this.ProductID = productID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.UnitPrice = unitPrice;
    }
}
