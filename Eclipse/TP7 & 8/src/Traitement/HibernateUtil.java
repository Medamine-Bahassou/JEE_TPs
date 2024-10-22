package Traitement;

import hibernate.Professeur;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Configuration config = new Configuration();
	 public static final ThreadLocal session = new ThreadLocal();

	 static {
		   try {
			   //Créer la SessionFactory
			   Configuration config = new Configuration();
			   sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

		   }catch (HibernateException ex) {
			   throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
		   }
	 }



 public static Session currentSession()
		throws HibernateException {
   Session s = (Session) session.get();
   // Ouvre une nouvelle Session, si ce Thread n'en a aucune
   if (s == null) {
   s = sessionFactory.openSession();
   session.set(s);
   }
   return s;
   }

 public static void closeSession()
		throws HibernateException {
   Session s = (Session) session.get();
   session.set(null);
   if (s != null)
   s.close();
   }
 }

