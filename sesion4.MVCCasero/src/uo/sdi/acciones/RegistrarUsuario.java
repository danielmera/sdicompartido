package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class RegistrarUsuario implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String resultado = "EXITO";
		String login = request.getParameter("login");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		User usuario = new User(login, name, surname, email, password);
		if (password.equals(repassword)) {
			UserDao dao = PersistenceFactory.newUserDao();
			if (dao.findByLogin(usuario.getLogin()) == null) {
				dao.save(usuario);
				Log.debug("Usuario [%s] creado correctamente",
						usuario.getLogin());
			} else {
				resultado = "FRACASO";
				Log.debug("Usuario con login [%s] ya existe",
						usuario.getLogin());
				request.setAttribute("message", "El login de usuario ya existe");
			}
		} else {
			resultado = "FRACASO";
			Log.info("Password [%s] y repassword [%s], deben de ser iguales",
					password, repassword);
			request.setAttribute("message", "Ambas contraseñas han de ser iguales");
		}
		return resultado;
	}

}
