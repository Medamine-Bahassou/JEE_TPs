package actions;


import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import org.apache.struts.action.Action; 
import org.apache.struts.action.ActionForm; 
import org.apache.struts.action.ActionForward; 
import org.apache.struts.action.ActionMapping; 
 
import beans.UserinputForm; 
 
public class UserinputAction extends Action   { 
 
 public ActionForward execute(ActionMapping mapping, ActionForm form, 
   HttpServletRequest request, HttpServletResponse response) { 
  UserinputForm userinputForm = (UserinputForm) form; 
 
  System.out.println(userinputForm.getNom()); 
  System.out.println(userinputForm.getPrenom()); 
  System.out.println(userinputForm.getEmail()); 
 
  HttpSession session = request.getSession(true); 
 
  System.out.println(userinputForm.getNom()); 
  System.out.println(userinputForm.getPrenom()); 
  System.out.println(userinputForm.getEmail()); 
 
   
  session.setAttribute("user", userinputForm); 
 
 
   return mapping.findForward("succes"); 
     } 
      
} 