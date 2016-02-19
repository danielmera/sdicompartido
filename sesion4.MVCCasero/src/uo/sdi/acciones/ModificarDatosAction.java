package uo.sdi.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.UserDao;
import alb.util.log.Log;

public class ModificarDatosAction implements Accion {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String respuesta = "EXITO";
		String nuevoNombre = request.getParameter("name");
		String nuevoApellido = request.getParameter("surname");
		String nuevoEmail = request.getParameter("email");
		String nuevaPassword = request.getParameter("pass");
		String nuevaRePassword = request.getParameter("repass");
		HttpSession session = request.getSession();
		User usuario = ((User) session.getAttribute("user"));
		User user = new User(usuario.getId(),usuario.getLogin(), nuevoNombre, nuevoApellido, nuevoEmail,
				nuevaPassword);
		if (nuevaPassword.equals(nuevaRePassword)) {
			if (!user.equals(usuario)) {
				usuario.setName(nuevoNombre);
				usuario.setSurname(nuevoApellido);
				usuario.setEmail(nuevoEmail);
				usuario.setPassword(nuevaPassword);
				try {
					UserDao dao = PersistenceFactory.newUserDao();
					dao.update(usuario);
					Log.debug("Modificado email de [%s] con el valor [%s]",
							usuario.getLogin(), nuevoEmail);
					request.setAttribute("messageSuccess",
							"La operación se ha llevado a cabo correctamente");

				} catch (Exception e) {
					Log.error("Algo ha ocurrido modificando el perfil del usuario");
					respuesta = "FRACASO";
				}
			} else {
				Log.debug("No se ha cambiado nada");
				request.setAttribute("message",
						"Se debe de cambiar los datos de algún campo si queremos "
						+ "actualizar la información de perfil del usuario");
			}
		} else {
			Log.debug(
					"Las contraseñas han de ser iguales para poder cambiarla: [%s] != [%s]",
					nuevaPassword, nuevaRePassword);
			request.setAttribute("message",
					"Las contraseñas proporcionadas no son iguales, y deben serlo para llevar a cabo la operación de "
					+ "actualización de datos");
		}
		return respuesta;
	}

	@Override
	public String toString() {
		return getClass().getName();
	}

}
