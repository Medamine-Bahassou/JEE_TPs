package personne;

public class Personne {
    private String nom;
    private String prenom;
    private String motDePasse;
    private String adresse;
    private String identifiant;

    public Personne() { }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public boolean enregistrer() {
        selection_bdd s = new selection_bdd();
        if (s.dejaExist(nom, prenom)) {
            return false; // Corrigé : ajout de l'accolade pour fermer l'instruction if
        } else {
            Insertion_bdd f = new Insertion_bdd();
            f.ajout_etudiant(nom, prenom, motDePasse, adresse);
            return true;
        }
    }

    public String identificateur() {
        selection_bdd s = new selection_bdd();
        String a = s.identificateur(nom, prenom); // Utiliser le nom sans accent
        return a;
    }
}
