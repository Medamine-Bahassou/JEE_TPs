package personne;
import java.util.Iterator;
import java.util.List;
import org.jdom.Element;
public class selection_bdd {
    public selection_bdd() {
    }
    public boolean dejaExist(String N, String P) {

        try {
            xml v=new xml();
// fichier = new xml(v.chemin+"/tp1.xml");
            xml file = new xml(v.chemin+"/tp1.xml");
            List listemodule = file.racine.getChildren("etudiant");
            Iterator it = listemodule.iterator();
            while (it.hasNext()) {
                Element courant = (Element) it.next();
                if (courant.getChild("prenom").getValue().equals(P) &
                        courant.getChild("nom").getValue().equals(N)) {
                    return true;
                }
                else System.out.println("Etudiant inéxistant");
            }
        } catch (Exception exp) {
            System.out.println("erreur=" + exp);
        }
        return false;
    }
    public String identificateur(String N, String P) {
        String a="";
        try {
            xml v=new xml();
            xml file = new xml(v.chemin+"/tp1.xml");
            List listemodule = file.racine.getChildren("etudiant");
            Iterator it = listemodule.iterator();
            while (it.hasNext()) {
                Element courant = (Element) it.next();
                if (courant.getChild("prenom").getValue().equals(P) &
                        courant.getChild("nom").getValue().equals(N)) {
                    a=courant.getAttribute("id").getValue();
                }
            }
        } catch (Exception exp) {
            System.out.println("erreur=" + exp);
        }
        return a;
    }
}

