package interfacee;

import java.sql.Date;
import java.time.LocalDate;

public interface iEmployee {
	void addEmployee(String FullName, String birthDate, String Gender, String Department, Float Salary, String Address);

	void updateEmployee(int EmployeeID, String FullName, String birthDate, String Gender, String Department, Float Salary, String Address);

	void deleteEmployee(int EmployeeID);

	void showEmployee();
}
