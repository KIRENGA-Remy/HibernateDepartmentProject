package app.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import app.models.Employee;
import app.services.Department;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties settings = new Properties();
			// POSTGRESQL

			settings.put(Environment.DRIVER, "org.postgresql.Driver");
//			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			// Postgresql
			// settings.put(Environment.URL, "jdbc:mysql://localhost:3306/myapp");
			settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/student");
			settings.put(Environment.USER, "postgres");
			settings.put(Environment.PASS, "remy2020");
			// PostgreSQL
			settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
//			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			settings.put(Environment.SHOW_SQL, true);
			settings.put(Environment.HBM2DDL_AUTO, "create-drop");
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Department.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
