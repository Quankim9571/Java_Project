package entity;

import java.sql.Date;

public class EntityCustomers {
	private int CustomerID;
	private String FullName;
	private String Email;
	private String PhoneNumber;
	private String Address;
	private Date DateOfBirth;
	
	public EntityCustomers() {
		super();
	}
	
	public EntityCustomers(int customerID, String fullName, String email, String phoneNumber, String address,
			Date dateOfBirth) {
		super();
		CustomerID = customerID;
		FullName = fullName;
		Email = email;
		PhoneNumber = phoneNumber;
		Address = address;
		DateOfBirth = dateOfBirth;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	
}
