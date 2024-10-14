package servlet.user;

import java.sql.*;

public class Connexion {
	private Connection connexion;
	private Statement instruction;
	protected ResultSet r�sultat;

	public Connexion() {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connexion =
			DriverManager.getConnection("jdbc:mysql://localhost/jee","root",
			"");
			instruction = connexion.createStatement();
			System.out.println("connexion etablie");
			}
			catch (ClassNotFoundException ex) {
			System.err.println("Probl�me de pilote");
			}
			catch (SQLException ex) {
			System.err.println("Base de donn�es non trouv�e ou requ�te incorrecte");
			}
			}

	public void lire(String requ�te) {
		try {
			r�sultat = instruction.executeQuery(requ�te);
		} catch (SQLException ex) {
			System.err.println("Requ�te incorrecte " + requ�te);
		}
	}

	public void miseAJour(String requ�te) {
		try {
			instruction.executeUpdate(requ�te);
		} catch (SQLException ex) {
			System.err.println("Requ�te incorrecte " + requ�te);
		}
	}

	public boolean suivant() {
		try {
			return r�sultat.next();
		} catch (SQLException ex) {
			return false;
		}
	}

	public void enregistrer(String login,String password) {
			miseAJour("INSERT INTO users (login,password) VALUES ('"+login+"','"+password+"')");
			}

	public void modifier(String newlogin,String newpassword,String
					login,String password) {
					miseAJour("UPDATE users SET login = '"+newlogin+"',password='"+newpassword+"' where login = '"+login+"' and password = '"+password+"'");
					}

	public boolean existeDeja(String login, String password) {
		lire("SELECT * FROM users where login = '" + login + "' and password = '" + password + "'");
		return suivant();
	}

	public void arr�t() {
		try {
			connexion.close();
		} catch (SQLException ex) {
			System.err.println("Erreur sur larr�t de la connexion � la base de donn�es");
		}
	}
}
