package uo.sdi.model;

import java.io.Serializable;

/**
 * This class is not an entity, it is a DTO with the same fields as a row in the
 * table
 * 
 * Implementa la interfaz Serializable para que el objeto User se pueda guardar en Sesión
 * 
 * @see Data Transfer Object pattern
 * @author alb
 *
 */
public class User implements Serializable{


	private static final long serialVersionUID = 41L;
	private Long id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	
	private UserStatus status;

	public User(String login, String name, String surname, String email,
			String password) {
		this.login = login;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.status = UserStatus.ACTIVE;
	}
	
	public User(Long id,String login, String name, String surname, String email,
			String password) {
		this.id = id;
		this.login = login;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.status = UserStatus.ACTIVE;
	}

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "User [id=" + id 
				+ ", login=" + login 
				+ ", password=" + password 
				+ ", name=" + name 
				+ ", surname=" + surname 
				+ ", status=" + status 
				+ ", email=" + email
			+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
