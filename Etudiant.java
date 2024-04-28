package GestionScolaire;
import java.sql.*;
import java.util.ArrayList;

public class Etudiant extends Utilisateur {
    private String numeroEtudiant;
    private ArrayList<Etudiant> listeEtudiants;

    // Constructeur
    public Etudiant(String nom, String prenom, String identifiant, String motDePasse, String numeroEtudiant) {
        super(nom, prenom, identifiant, motDePasse);
        this.numeroEtudiant = numeroEtudiant;
        this.listeEtudiants = new ArrayList<>();
    }

    public void setNumeroEtudiant(String numeroEtudiant){
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getNumeroEtudiant(){
        return numeroEtudiant;
    }

    // Méthode pour inscrire un étudiant
    public void inscrireEtudiant(Etudiant etudiant) {
        listeEtudiants.add(etudiant);
    }

    // Méthode pour modifier un étudiant
    public void modifierEtudiant(Etudiant ancienEtudiant, Etudiant nouveauEtudiant) {
        for (int i = 0; i < listeEtudiants.size(); i++) {
            if (listeEtudiants.get(i).equals(ancienEtudiant)) {
                listeEtudiants.set(i, nouveauEtudiant);
                return;
            }
        }
        // Si l'étudiant à modifier n'est pas trouvé, on lance une exception
        throw new IllegalArgumentException("L'étudiant à modifier n'existe pas.");
    }

    // Méthode pour supprimer un étudiant
    public void supprimerEtudiant(Etudiant etudiant) {
        if (!listeEtudiants.remove(etudiant)) {
            // Si l'étudiant à supprimer n'est pas trouvé, on lance une exception
            throw new IllegalArgumentException("L'étudiant à supprimer n'existe pas.");
        }
    }

    public boolean authentifier(String identifiant, String motDePasse) {
        String query = "SELECT * FROM etudiants WHERE identifiant = ? AND motPasse = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionScolaire", "root", "teningThiam2002!");
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, identifiant);
            statement.setString(2, motDePasse);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}