package GestionScolaire;

import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        // Interface utilisateur pour l'authentification
        JTextField identifiantField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        Object[] fields = {"identifiant:", identifiantField, "Password:", passwordField};
        int result = JOptionPane.showConfirmDialog(null, fields, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // Authentification réussie
            String username = identifiantField.getText();
            String password = new String(passwordField.getPassword());
            
            Etudiant etudiant = new Etudiant("1", "fabian", "navaro", "fabian@gmail.com", "password123");

            // Création d'un cours
            Cour cours1 = new Cour("Mathématiques");

            // Création d'une note pour l'étudiant et le cours
            Note note1 = new Note(etudiant, cours1, 15.5);

            // Ajout de la note
            note1.ajouterNote(etudiant, cours1, 15.5);

            // Modification de la note
            note1.modifierNote(etudiant, cours1, 17.0);

            // Consultation des notes pour le cours spécifié
            Note[] notesCours = note1.consulterNotes(cours1);

            // Création d'un StringBuilder pour construire le message à afficher
            StringBuilder message = new StringBuilder();
            message.append("Notes pour le cours ").append(cours1.getNom()).append(":\n");
            for (Note note : notesCours) {
                message.append("Étudiant: ").append(note.getEtudiant().getNom()).append(", Note: ").append(note.getValeur()).append("\n");
            }

            // Affichage des notes du cours dans une boîte de dialogue
            JOptionPane.showMessageDialog(null, message.toString());
        } else {
            // Authentification annulée ou échouée
            JOptionPane.showMessageDialog(null, "Authentication failed. Exiting program.");
            System.exit(0);
        }
    }
}