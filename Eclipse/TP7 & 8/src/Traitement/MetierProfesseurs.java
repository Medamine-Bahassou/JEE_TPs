package Traitement;

import hibernate.Professeur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MetierProfesseurs {
	private Session session;
	private Logger log;
	
	public MetierProfesseurs(){}

			public Professeur[] getAllProfesseurs() {
				List professeurs = new ArrayList();
				//Session session = null;
				Transaction tx = null;
				session = HibernateUtil.currentSession();
				tx = session.beginTransaction();
				List tmpprofesseurs = session.createQuery("select o from Professeur as o").list();
				for (Iterator iter = tmpprofesseurs.iterator(); iter.hasNext();) {
					professeurs.add((Professeur) iter.next());
					
			     for (int i=0;i<professeurs.size();i++)
			    	 {Professeur per=(Professeur)professeurs.get(i);
			    		 System.out.println("Nom :"+per.getNom()+" Prenom :"+per.getPrenom()+" Adreese :"+per.getAdresse());}
					
				}
				tx.commit();
				return (Professeur[]) professeurs.toArray(new Professeur[0]);
				}
			
			
			//   Suppression d'un enregistrement
			public void SupprimerProfesseur(Integer id) {
				
				Transaction tx = null;

				session = HibernateUtil.currentSession();

				if(existe(id)){
					tx = session.beginTransaction();
					Professeur u = (Professeur) session.get(Professeur.class, id);
					session.delete(u);
					tx.commit();
				}
				else{
					System.out.println("Professeur Absent !");
				}


				HibernateUtil.closeSession();

			}
			
			public boolean existe(Integer id){
				
				List professeurs = new ArrayList();

				boolean exist = false;
				session = HibernateUtil.currentSession();
				List tmp = session.createQuery("from Professeur").list();
				for (Iterator iter = tmp.iterator(); iter.hasNext();) {
					professeurs.add((Professeur) iter.next());
				}

				for (int i = 0; i < professeurs.size(); i++) {
					Professeur prof = (Professeur) professeurs.get(i);
					if(prof.getId().equals(id)){

						exist=true;
					}
				}

		       return exist;

			}
			

	

	protected void setUp() throws Exception {
		session = HibernateUtil.currentSession();
		log = Logger.getLogger(this.getClass());
		}
	protected void tearDown() throws Exception {
		HibernateUtil.closeSession();
		}
	public Session getSession() {
		return session;
		}
	public void setSession(Session session) {
		this.session = session;
		}
}

