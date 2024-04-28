package GestionScolaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartieSql {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/GestionScolaire";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "teningThiam2002!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static boolean validerIdentifiant(String identifiant, String motDePasse) {
        String query = "SELECT * FROM etudiants WHERE identifiant = astu AND motPasse = 123";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, identifiant);
            stmt.setString(2, motDePasse);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si une ligne est retournée, les informations d'identification sont valides
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En cas d'erreur, les informations d'identification sont considérées comme invalides
        }
    }
}