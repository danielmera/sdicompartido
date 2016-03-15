package uo.sdi.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;

@ManagedBean
@SessionScoped
public class BeanUser implements Serializable{

	private static final long serialVersionUID = 555L;

	private User user = new User();

	public BeanUser(){
		iniciaUsuario(null);
	}
	
	public void iniciaUsuario(ActionEvent event){
		user.setId(null);
		user.setLogin("nombre de usuario");
		user.setName("nombre");
		user.setSurname("apellidos");
		user.setEmail("email@mail.com");
		user.setStatus(null);
	}
	
	public User getUsuario() {
		return user;
	}

	public void setUsuario(User usuario) {
		this.user = usuario;
	}
	
	public void validarNombre(AjaxBehaviorEvent evento){
		//if(Factories.services.createUsersService().findByLogin(user.getName()))
			
	}
	
}
