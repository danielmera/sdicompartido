package uo.sdi.presentation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import uo.sdi.business.UserService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;

@ManagedBean
@SessionScoped
public class BeanUser implements Serializable{

	private static final long serialVersionUID = 555L;

	private User userdata = new User();
	
	private String messageUserAlreadyExists = "";
	
	public BeanUser(){
		iniciaUsuario(null);
	}
	
	public void iniciaUsuario(ActionEvent event){
		//user.setId(null);
		userdata.setLogin("nombredeusuario");
		//user.setName("nombre");
		//user.setSurname("apellidos");
		//user.setEmail("email@mail.com");
		//user.setStatus(null);
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
	
	public String alta(){
		UserService service;
		try{
			service = Factories.services.createUsersService();
			//service.saveUser(userdata);
			return "exito";
		}catch(Exception e){
			e.printStackTrace();
			return "error"; 
		}
	}

	public void validarNombre(AjaxBehaviorEvent evento){
		String login = userdata.getLogin();
		if(Factories.services.createUsersService().findByLogin(login)==null)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Nombre de usuario disponible"));
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El usuario ya existe."));
		}
	}
	
}
