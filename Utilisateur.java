package GestionScolaire;

public class Utilisateur {
	    private String nom;
	    private  String prenom;
	    private String identifiant;
	    private String motPasse;

	    public Utilisateur(String nom, String prenom, String identifiant, String motPasse){
	        this.nom=nom;
	        this.prenom=prenom;
	        this.identifiant=identifiant;
	        this.motPasse=motPasse;
	    }

	    // les accesseurs
	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	    public String getIdentifiant() {
	        return identifiant;
	    }

	    public void setIdentifiant(String identifiant) {
	        this.identifiant = identifiant;
	    }

	    public String getMotPasse() {
	        return motPasse;
	    }

	    public void setMotPasse(String motPasse) {
	        this.motPasse = motPasse;
	    }
	}



