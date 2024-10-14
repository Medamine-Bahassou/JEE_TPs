package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import JavaBeans.UserBean;

public class TraiterLoginServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public TraiterLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		Connexion cnx = new Connexion();
		HttpSession session = request.getSession(true);
		HttpSession session1 = request.getSession(true);
		String action = (String) session1.getAttribute("page");
		if (action == "modification") {
			System.out.println("En cours de modification");
			UserBean user = new UserBean();
			user = (UserBean) session.getAttribute("utilisateur");
			cnx.modifier(login, password, user.getLogin(), user.getPassword());
			System.out.println("Modification réussi ");
			out.println("<P> Modification bien réussi </P>");
			session1.invalidate();
			out.println("<a href='index.jsp'>Aceuil</a>");
		} else if (cnx.existeDeja(login, password)) {
			System.out.println("L'utilisateur Existe Login :" + login + " Mot de passe :" + password);
			out.println("<P> L'utilisateur Existe </P>");
			UserBean user = new UserBean();
			user.setLogin(login);
			user.setPassword(password);
			session.setAttribute("utilisateur", user);
			response.sendRedirect(request.getContextPath() + "/users.jsp");
		} else {
			System.out.println("Cet utilisateur nexiste pas");
			out.println("<P> Cet utilisateur nexiste pas </P>");
			cnx.enregistrer(login, password);
			System.out.println("L'utilisteur a été bien enregistré !");
			out.println("<P> L'utilisteur a été bien enregistré ! </P>");
			out.println("<a href='index.jsp'>Aceuil</a>");
		}
	}
}
