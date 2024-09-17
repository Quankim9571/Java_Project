/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class EntityProducts {
    private int ProductID;
    private String ProductName;
    private int CategoryID;
    private int Size;
    private String Color;
    private Double Price;
    private int StockQuantity;    
    
    public EntityProducts() {
		super();
	}
    
    public EntityProducts(int productID, String productName, int categoryID, int size, String color, Double price,int stockQuantity) {
		super();
		ProductID = productID;
		ProductName = productName;
		CategoryID = categoryID;
		Size = size;
                Color = color;
                Price = price;
                StockQuantity = stockQuantity;
	}
    
    public int getProductID() {
		return ProductID;
	}

    public void setProductID(int productID) {
		ProductID = productID;
	}
    
    public String getProductName() {
		return ProductName;
	}

    public void setProductName(String productName) {
		ProductName = productName;
	}
    
    public int getCategoryID() {
		return CategoryID;
	}

    public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
    
    public int getSize() {
		return Size;
	}

    public void setSize(int size) {
		Size = size;
	}
    
    public String getColor() {
		return Color;
	}

    public void setColor(String color) {
		Color = color;
	}
    
    public Double getPrice() {
		return Price;
	}

    public void setPrice(Double price) {
		Price = price;
	}
    
    public int getStockQuantity() {
		return StockQuantity;
	}

    public void setStockQuantity(int stockQuantity) {
		StockQuantity = stockQuantity;
	}
}


