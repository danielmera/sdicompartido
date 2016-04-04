package uo.sdi.presentation;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import alb.util.log.Log;
import uo.sdi.business.UserService;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;

@ManagedBean
@SessionScoped
public class BeanLogin implements Serializable {

	private static final long serialVersionUID = 40L;

	@ManagedProperty(value="#{viajes}")
	private BeanTrips beantrips;
	
	public BeanTrips getBeanTrips(){
		return this.beantrips;
	}
	
	public void setBeanTrips(BeanTrips beantrips){
		this.beantrips = beantrips;
	}
	
	@PostConstruct
    public void init() {        
      Log.info("BeanLogin - PostConstruct"); 
      beantrips = (BeanTrips) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("viajes"));
      //si no existe lo creamos e inicializamos
      if (beantrips == null) { 
        Log.info("BeanTrips-No existia");
        beantrips = new BeanTrips();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "viajes", beantrips);
      }
    }
	
    @PreDestroy
    public void end()  {
        System.out.println("BeanLogin - PreDestroy");
    }
	
	private User user = new User();

	private String resultado = "";

	public void inicializarUsuario() {
		user.setId(null);
		user.setLogin("");
		user.setName("");
		user.setPassword("");
		user.setSurname("");
		user.setEmail("");
	}

	public BeanLogin() {
		Log.debug("Bean Login no existía");
	}

	public String verify() {
		FacesContext fc = FacesContext.getCurrentInstance();
		if (fc.getExternalContext().getSessionMap().get("LOGGEDIN_USER") == null) {
			UserService us = Factories.services.createUsersService();
			User aux = us.verify(user.getLogin(), user.getPassword());
			if (aux != null) {
				user = aux;
				putUserInSession();
				resultado = "exito";
				Log.info("El usuario [%s] ha iniciado sesión", user.getLogin());
				beantrips.cargarViajesUsuario();
			} else {
				inicializarUsuario();
				resultado = "fracaso";
				Log.info("Alguien ha intentado iniciar sesión con credenciales inválidas");
				fc.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Credenciales inválidas",
						"Credenciales inválidas"));
			}
		} else {
			resultado = "fracaso";
			Log.info("Ya existe un usuario en sesión");
			fc.addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Usuario en sesión",
							"Hay un usuario logeado, para logearte con otra cuenta debes cerrar la sesión con tu cuenta actual"));
		}
		return resultado;
	}

	public String cerrarSesion() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		removeUserInSession(session);
		//session.invalidate();
		return "exito";
	}

	public void putUserInSession() {
		Map<String, Object> sessionmap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		sessionmap.put("LOGGEDIN_USER", user);
	}

	/**
	 * Borrar usuario en sesión y invalidar sesión
	 */
	public void removeUserInSession(HttpSession session) {
		session.removeAttribute("LOGGEDIN_USER");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
