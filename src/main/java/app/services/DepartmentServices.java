package app.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import app.utils.HibernateUtils;

public class DepartmentServices {
	public static void main(String[] args) {
	}

	public static DepartmentServices departmentServices;
	protected static SessionFactory sf = HibernateUtils.getSessionFactory();
	protected static Session session;

	public static DepartmentServices getInstance() {
		if (departmentServices == null) {
			departmentServices = new DepartmentServices();
		}
		return departmentServices;
	}

	private DepartmentServices() {
	}

	public void addDipartment(Department dl) {
		session = sf.openSession();
		session.beginTransaction();
		session.save(dl);
		session.getTransaction().commit();
	}

	public Department getDepartmentById(int id) {
		session = sf.openSession();
		Department dpt = session.load(Department.class, id);
		return dpt;
	}

}
