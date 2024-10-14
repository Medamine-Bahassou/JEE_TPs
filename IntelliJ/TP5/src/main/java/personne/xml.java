package personne;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class xml {

        public Element racine;
        public static Document document;
        public static Iterator j;
        public static Element courant;
        public String chemin = "C:/Users/hp/Desktop";
        //-----------------------------------------------------------------
//contsructeur par defaut
        public xml() {}
        // contsructeur parametrer
        public xml(String chemin1) throws Exception {
            SAXBuilder sxb = new SAXBuilder();
            document = sxb.build(new File(chemin1));
            racine = document.getRootElement();
        }
        //creer fichier xml
        public void creat_xml(String fichier, String nomracine) {
            racine = new Element(nomracine);
            document = new Document(racine);
            save(fichier);
        }
        //enregistrer fichier xml
        public void save(String fichier) {
            try {
                XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                sortie.output(document, new FileOutputStream(fichier));
            } catch (java.io.IOException e) {}
        }
        // ajouter noeud dans fichier xml
        public void add_noeud_xml(Element pere, Element fils, String texte) {
//Element fils = new Element(noeud);
            fils.setText(texte);
            pere.addContent(fils);
        }
        public void add_attribut_xml(Element pere, String id, String valeur) {
            Attribute idNoeud = new Attribute(id, valeur);
            pere.setAttribute(idNoeud);
        }
    }

