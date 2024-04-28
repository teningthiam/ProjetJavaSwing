package GestionScolaire;

public class Note {
    private Etudiant etudiant;
    private Cour cour;
    private double valeur;
    private Note[] tableauNotes; 
    private int taille; 

    // Constructeur
    public Note(Etudiant etudiant, Cour cour, double valeur) {
        this.etudiant = etudiant;
        this.cour = cour;
        this.valeur = valeur;
        this.tableauNotes = new Note[10]; 
        this.taille = 0; 
    }

    // Getter et Setter pour l'étudiant
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    // Getter et Setter pour le cours
    public Cour getCour() {
        return cour;
    }

    public void setCour(Cour cour) {
        this.cour = cour;
    }

    // Getter et Setter pour la valeur
    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    // Méthode pour ajouter une note
    public void ajouterNote(Etudiant etudiant, Cour cour, double valeur) {
        // Vérifier si une note existe déjà pour cet étudiant et ce cours
        for (int i = 0; i < taille; i++) {
            if (tableauNotes[i].getEtudiant().equals(etudiant) && tableauNotes[i].getCour().equals(cour)) {
                // Si une note existe déjà, vous pouvez lancer une exception 
                throw new IllegalArgumentException("Une note pour l'étudiant " + etudiant.getNom() + " pour le cours " + cour.getNom() + " existe déjà.");
            }
        }
        // Si aucune note correspondante n'a été trouvée, ajouter une nouvelle note au tableau
        Note nouvelleNote = new Note(etudiant, cour, valeur);
        if (taille == tableauNotes.length) {
            // Si le tableau est plein, agrandissez-le en créant un nouveau tableau avec une capacité plus grande
            Note[] nouveauTableau = new Note[taille * 2]; 
            // Copiez les éléments de l'ancien tableau dans le nouveau tableau
            System.arraycopy(tableauNotes, 0, nouveauTableau, 0, taille);
            tableauNotes = nouveauTableau; 
        }
        tableauNotes[taille] = nouvelleNote; 
        taille++; 
    }

    // Méthode pour modifier une note
    public void modifierNote(Etudiant etudiant, Cour cour, double nouvelleValeur) {
        // Parcourir le tableau des notes pour trouver la note correspondante
        for (int i = 0; i < taille; i++) {
            if (tableauNotes[i].getEtudiant().equals(etudiant) && tableauNotes[i].getCour().equals(cour)) {
                // Mettre à jour la valeur de la note
                tableauNotes[i].setValeur(nouvelleValeur);
                return; 
            }
        }
        // Si aucune note correspondante n'a été trouvée, onlancer une exception 
        throw new IllegalArgumentException("La note pour l'étudiant " + etudiant.getNom() + " pour le cours " + cour.getNom() + " n'existe pas.");
    }

    // Méthode pour consulter les notes pour un cours donné
    public Note[] consulterNotes(Cour cour) {
        // Créer un tableau pour stocker les notes du cours spécifié
        Note[] notesCours = new Note[taille];
        int index = 0; 
        // Parcourir le tableau des notes pour trouver les notes du cours spécifié
        for (int i = 0; i < taille; i++) {
            if (tableauNotes[i].getCour().equals(cour)) {
                notesCours[index] = tableauNotes[i]; 
                index++; 
            }
        }
		return notesCours;
        
    }
}