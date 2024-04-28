package GestionScolaire;
import java.sql.*;
	public class Administrateur extends Utilisateur{
	    // Constructeur
	    public Administrateur(String nom, String prenom, String identifiant, String motDePasse) {
	        super(nom, prenom, identifiant, motDePasse);
	    }
	    // Méthode d'authentification spécifique à un administrateur

	    public boolean authentifier(String identifiant, String motDePasse) {
	        String query = "SELECT * FROM administrateur WHERE identifiant = ? AND motPasse = ?";
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


