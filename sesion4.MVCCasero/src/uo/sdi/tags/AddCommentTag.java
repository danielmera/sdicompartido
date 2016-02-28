package uo.sdi.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import uo.sdi.model.Rating;
import uo.sdi.model.User;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.RatingDao;

public class AddCommentTag extends SimpleTagSupport{

	Long aboutTripId;
	Long aboutUserId;
	
	public void setAboutTripId(String aboutTripId) {
		this.aboutTripId = new Long(aboutTripId);
	}

	public void setAboutUserId(String aboutUserId) {
		this.aboutUserId = new Long(aboutUserId);
	}


	public void doTag() throws JspException, IOException {
		
		RatingDao dao = PersistenceFactory.newRatingDao();
		Long fromUserId = ((User) getJspContext().getAttribute("user",PageContext.SESSION_SCOPE)).getId();
		Rating r = dao.findByAboutFrom(aboutUserId, aboutTripId, fromUserId, aboutTripId);
		StringBuilder sb = new StringBuilder();
		if(r==null)
		{
		getJspContext().setAttribute("tripId", aboutTripId,PageContext.SESSION_SCOPE);
		getJspContext().setAttribute("aboutUserId", aboutUserId,PageContext.SESSION_SCOPE);
		sb.append("<a class=\"btn btn-info\"");
		sb.append(" href=\"registrarComentario.jsp\"");
		sb.append("/>Comentar</a>");
		}else{
			sb.append("<a class=\"btn btn-info\"");
			sb.append(" href=\"cargarComentario?id="+r.getId()+"&trip_id="+aboutTripId+"\">Ver comentario</a>");
		}
		getJspContext().getOut().write(sb.toString());
	}
}
