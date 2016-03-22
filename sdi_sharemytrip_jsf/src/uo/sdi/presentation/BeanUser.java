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

	private String messageUserAlreadyExists = "";

	public BeanUser() {
		iniciaUsuario(null);
	}

	public void iniciaUsuario(ActionEvent event) {
		userdata.setLogin("");
	}

	public User getUserData() {
		return userdata;
	}

	public void setUserData(User usuario) {
		this.userdata = usuario;
	}

	public String getMessageUserAlreadyExists() {
		return messageUserAlreadyExists;
	}

	public void setMessageUserAlreadyExists(String messageUserAlreadyExists) {
		this.messageUserAlreadyExists = messageUserAlreadyExists;
	}

	public String alta() {
		UserService service;
		try {
			service = Factories.services.createUsersService();
			service.saveUser(userdata);
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public void validarNombre(AjaxBehaviorEvent evento) {
		String login = userdata.getLogin();
		FacesContext fc = FacesContext.getCurrentInstance();
		if (Factories.services.createUsersService().findByLogin(login) != null) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"", "El usuario ya existe."));
		}
	}

	// Borrar los datos del formulario de registro cuando se cancela la
	// operación
	public void reset() {
		iniciaUsuario(null);
		RequestContext.getCurrentInstance().reset("form:panel");
	}

}
