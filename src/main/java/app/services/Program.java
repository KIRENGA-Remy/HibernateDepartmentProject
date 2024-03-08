package app.services;

import app.models.Employee;

public class Program {
	public static void main(String[] args) {
		DepartmentServices dis = DepartmentServices.getInstance();
		Department dl = new Department("Reverse engineering");
		dis.addDipartment(dl);
		Department saved = dis.getDepartmentById(1);
		EmployeeServices services = EmployeeServices.getInstance();
		Employee emp = new Employee("GITOLI", "Remy", "claudien@gmail.com", "Student", "0792441050", saved);
		services.addEmployee(emp);
	}
}