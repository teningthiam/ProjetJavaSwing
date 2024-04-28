package GestionScolaire;

import java.util.ArrayList;

public class Cour {
    private String nom;
    private ArrayList<Cour> listeCours;

    // Constructeur avec le nom de la cour
    public Cour(String nom) {
        this.nom = nom;
        this.listeCours = new ArrayList<>();
    }

    // Getter et Setter pour le nom de la cour
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour ajouter un cours
    public void ajouterCour(Cour cours) {
        listeCours.add(cours);
    }

    // Méthode pour modifier un cours
    public void modifierCour(Cour coursAModifier, Cour nouveauCours) {
        for (int i = 0; i < listeCours.size(); i++) {
            if (listeCours.get(i).equals(coursAModifier)) {
                listeCours.set(i, nouveauCours);
                return;
            }
        }
        // Si le cours à modifier n'est pas trouvé, vous pouvez lancer une exception 
        throw new IllegalArgumentException("Le cours à modifier n'existe pas.");
    }

    // Méthode pour supprimer un cours
    public void supprimerCour(Cour coursASupprimer) {
        if (!listeCours.remove(coursASupprimer)) {
            // Si le cours à supprimer n'est pas trouvé, vous pouvez lancer une exception ou gérer le cas selon vos besoins
            throw new IllegalArgumentException("Le cours à supprimer n'existe pas.");
        }
    }
}