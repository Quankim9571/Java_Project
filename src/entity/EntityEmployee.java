package entity;

import java.sql.Date;

public class EntityEmployee {
	private int EmployeeID;
	private String FullName;

	private String BirthDate;

	private String Gender;

	private String Department;

	private Float Salary;
	
	private String Address;

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public Float getSalary() {
		return Salary;
	}

	public void setSalary(Float salary) {
		Salary = salary;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public EntityEmployee(int employeeID, String fullName, String birthDate, String gender, String department,
			Float salary, String address) {
		super();
		EmployeeID = employeeID;
		FullName = fullName;
		BirthDate = birthDate;
		Gender = gender;
		Department = department;
		Salary = salary;
		Address = address;
	}
	
	public EntityEmployee() {
		super();
	}
	
	
}
