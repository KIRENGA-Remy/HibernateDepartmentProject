package app.services;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import app.models.Employee;
import app.utils.HibernateUtils;

public class EmployeeServices {
	public static EmployeeServices employeeServices;
	protected static SessionFactory sf = HibernateUtils.getSessionFactory();
	protected static Session session;

	public static EmployeeServices getInstance() {
		if (employeeServices == null) {
			employeeServices = new EmployeeServices();
		}
		return employeeServices;
	}

	private EmployeeServices() {
	}

	public void addEmployee(Employee emp) {
		session = sf.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
	}

	public List<Employee> getAllEmployees() {
		session = sf.openSession();
		Query q = (Query) session.createQuery("from Employee");
		List<Employee> employees = ((org.hibernate.query.Query) q).list();
		return employees;
	}
}