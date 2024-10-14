package web;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

// Votre Run
public class ConnectionClass {
    // La m�thode qui appelera votre fonction Run
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Votre fonction Run
                // Vos information de connexion � une base de donn�es
                String BDD = "jee";
                String url = "jdbc:mysql://localhost:8080/" + BDD;
                String user = "root";
                String passwd = "root";
                // L'essaie de connexion � votre base de don�es
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(url, user, passwd);
                    System.out.println("Connecter");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
            }
        });
    }

}
