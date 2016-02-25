package uo.sdi.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MessageErrorTag extends SimpleTagSupport {

	String mensaje;

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void doTag() throws JspException, IOException {
		StringBuilder sb = new StringBuilder();
		if (!mensaje.isEmpty()) {
			sb.append("<div class=\"alert alert-danger\">");
			sb.append(mensaje);
			sb.append("</div>");
		}
		getJspContext().getOut().write(sb.toString());
	}

}
