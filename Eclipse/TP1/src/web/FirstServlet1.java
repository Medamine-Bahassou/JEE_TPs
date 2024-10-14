package web;

import java.io.IOException;
import java.sql.* ; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null ; 

		ConnectionClass connexion = new ConnectionClass(); 
		
		String nom = request.getParameter("nom");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>"+nom+"</h1>");
		
		try {
			if(!connection.isClosed()) {
				out.println("<h1>Connected</h1>");
			}
		}
		catch(SQLException e) {
			e.getMessage() ; 
		}
		out.println("</body>");
		
		
		
		//request.getRequestDispatcher("vue.jsp").forward(request, response); 

	}

}
