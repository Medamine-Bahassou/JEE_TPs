package personne;
import org.jdom.*;

import java.util.Random;

public class Insertion_bdd {
    public Insertion_bdd() {
    }
    int RandomId(){
        Random r = new Random();
        return r.nextInt(10000);
    }
    public void ajout_etudiant(String Nom,String Prenom,String Mdp,String Adresse) {
        xml fichier = null;
        try {
            xml v = new xml();
            fichier = new xml(v.chemin + "/tp1.xml");
            Element etudiant = new Element("etudiant");
            fichier.add_noeud_xml(fichier.racine, etudiant, "");
            fichier.add_attribut_xml(etudiant, "id", RandomId() + "");
            Element nom = new Element("nom");
            fichier.add_noeud_xml(etudiant, nom, Nom);
            Element prenom = new Element("prenom");
            fichier.add_noeud_xml(etudiant, prenom, Prenom);
            Element mdp = new Element("mdp");
            fichier.add_noeud_xml(etudiant, mdp, Mdp);
            Element adresse = new Element("adresse");
            fichier.add_noeud_xml(etudiant, adresse, Adresse);
            fichier.save(fichier.chemin + "/tp1.xml");
        } catch (Exception ex) {
            System.out.print("erreur");
        }
    }
}



