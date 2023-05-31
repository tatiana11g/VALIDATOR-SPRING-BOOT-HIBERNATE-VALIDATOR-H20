package net.javatatiana.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author javatatiana.net
 *
 */

@Table(name = "users")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	
	// campo name no es nulo y debe tener mino 2 caracteres
	@NotEmpty
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String name;
	
	// email no debe ser nulo o vacio y debe tener un formato
	@NotEmpty
	@Email
	private String email;
	
	// password no debe  ser nulo y debe tener minimo 8 caracteres
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	private String password;
	
	public User() {
		
	}
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}