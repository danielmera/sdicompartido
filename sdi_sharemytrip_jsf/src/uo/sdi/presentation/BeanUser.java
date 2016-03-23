package uo.sdi.presentation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;

import uo.sdi.business.UserService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;

@ManagedBean
@SessionScoped
public class BeanUser implements Serializable {

	private static final long serialVersionUID = 555L;

	private User userdata = new User();

	private String repassword = new String();

	private boolean userNameValid = false;

	private boolean passwordEquealsRePassword = false;

	public BeanUser() {
		iniciaUsuario(null);
	}

	public void iniciaUsuario(ActionEvent event) {
		userdata.setLogin("");
		userdata.setName("");
		userdata.setSurname("");
		userdata.setPassword("");
		userdata.setEmail("");
		repassword = "";
		setUserNameValid(false);
		setPasswordEquealsRePassword(false);
	}

	public User getUserData() {
		return userdata;
	}

	public void setUserData(User usuario) {
		this.userdata = usuario;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public boolean isUserNameValid() {
		return userNameValid;
	}

	public void setUserNameValid(boolean userNameValid) {
		this.userNameValid = userNameValid;
	}

	public boolean isPasswordEquealsRePassword() {
		return passwordEquealsRePassword;
	}

	public void setPasswordEquealsRePassword(boolean passwordEquealsRePassword) {
		this.passwordEquealsRePassword = passwordEquealsRePassword;
	}

	public String alta() {
		FacesContext fc = FacesContext.getCurrentInstance();
		UserService service;
		if (userNameValid && passwordEquealsRePassword)
			try {
				service = Factories.services.createUsersService();
				service.saveUser(userdata);
				fc.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Operación de registro exitosa, pruebe a iniciar sesión",
						"El usuario ya existe."));
				return "exito";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		else {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"El usuario ya existe", "El usuario ya existe."));
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Las contraseñas deben coincidir", "El usuario ya existe."));
			iniciaUsuario(null);
			return "error";
		}

	}

	/**
	 * Método que comprueba si el campo password y el campo repassword tienen
	 * los mismo valores
	 * 
	 * @param evento
	 */
	public void validarPasswords(AjaxBehaviorEvent evento) {
		FacesContext fc = FacesContext.getCurrentInstance();
		if (!userdata.getPassword().equals(repassword)){
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Las contraseñas deben coincidir", "El usuario ya existe."));
			setPasswordEquealsRePassword(false);
		}
		else
			setPasswordEquealsRePassword(true);
	}

	/**
	 * Comprobamos si existe el nombre de usuario cuando el campo login pierde
	 * el foco
	 * 
	 * @param evento
	 */
	public void validarNombre(AjaxBehaviorEvent evento) {
		String login = userdata.getLogin();
		FacesContext fc = FacesContext.getCurrentInstance();
		if (Factories.services.createUsersService().findByLogin(login) != null) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"El usuario ya existe", "El usuario ya existe."));
			setUserNameValid(false);
		} else
			setUserNameValid(true);
	}

	// Borrar los datos del formulario de registro cuando se cancela la
	// operación
	public void reset() {
		iniciaUsuario(null);
		RequestContext.getCurrentInstance().reset("form:panel");
	}

}
