package actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Traitement.MetierProfesseurs;
import beans.AfficherListeProfesseursForm;


public class AfficherListeProfesseurs extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		AfficherListeProfesseursForm listeProfesseursForm = (AfficherListeProfesseursForm) form;// TODO Auto-generated method stub
		MetierProfesseurs m = new MetierProfesseurs();
		
		listeProfesseursForm.setProfesseurs(m.getAllProfesseurs());
		return mapping.findForward("succes");
	}
}