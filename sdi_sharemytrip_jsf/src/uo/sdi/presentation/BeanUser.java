package uo.sdi.presentation;

import java.io.Serializable;

import uo.sdi.model.User;

public class BeanUser implements Serializable{

	private static final long serialVersionUID = 555L;

	private User usuario = new User();

	public BeanUser(){
	}
	
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	
	
}
