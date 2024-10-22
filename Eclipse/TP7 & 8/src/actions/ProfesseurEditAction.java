package actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import Traitement.MetierProfesseurs;

public class ProfesseurEditAction extends DispatchAction {

public ActionForward deleteProfesseur(ActionMapping mapping,	ActionForm form,HttpServletRequest request,	HttpServletResponse response) 
        {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		System.out.println("deleteProfesseur id = "+id);
		
		MetierProfesseurs m = new MetierProfesseurs();
		m.SupprimerProfesseur(id);
		return mapping.findForward("showList");
		}



}
