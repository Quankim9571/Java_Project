package entity;

public class EntitySupplier {
	private int SupplierID;
	private String SupplierName;
	private String ContactInfo;
	private String Address;
	
	public EntitySupplier() {
		super();
	}
	
	public EntitySupplier(int supplierID, String supplierName, String contactInfo, String address) {
		super();
		SupplierID = supplierID;
		SupplierName = supplierName;
		ContactInfo = contactInfo;
		Address = address;
	}

	public int getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}

	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	public String getContactInfo() {
		return ContactInfo;
	}

	public void setContactInfo(String contactInfo) {
		ContactInfo = contactInfo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
	
}
