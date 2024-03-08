package app.models;

import app.services.Department;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	public Employee(String firstname, String lastname, String email, String position, String mobile,
			Department department) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.position = position;
		this.mobile = mobile;
		this.department = department;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "code")
	private String id;
	@Column(name = "izina_Ry'Umuryango")
	private String firstname;
	private String lastname;
	@Column(name = "emeli", unique = false, nullable = false)
	private String email;
	private String position;
	private String mobile;
	@ManyToOne
	private Department department;

	public Employee() {
	};

	public String getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", position=" + position + ", mobile=" + mobile + "]";
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPosition() {
		return position;
	}

	public String getMobile() {
		return mobile;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Employee(String id, String firstname, String lastname, String email, String position, String mobile) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.position = position;
		this.mobile = mobile;
	}

	public Employee(String firstname, String lastname, String email, String position, String mobile) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.position = position;
		this.mobile = mobile;
	}

}