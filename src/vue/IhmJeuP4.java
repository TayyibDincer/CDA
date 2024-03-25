package vue;

import modele.Joueur;

import java.util.Scanner;

public class IhmJeuP4 extends IhmJeux {
    private Scanner in;
    private String rouge = "\uD83D\uDD34";
    private String jaune = "\uD83D\uDFE1";
    private String noir = "\u26AB";

    public IhmJeuP4() {
        this.in = new Scanner(System.in);
    }
    public void afficherPlateau(int[][] plateau) {
        // Afficher les numéros de colonnes
        System.out.println(" 1  2  3  4  5  6  7");
        // Parcourir le plateau ligne par ligne
        for (int i = 0; i < plateau.length; i++) {
            // Afficher le numéro de ligne
            System.out.print("|");
            // Afficher les jetons de chaque joueur sur la ligne
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[i][j] == Joueur.ROUGE) { // Jeton du joueur 1 (rouge)
                    System.out.print(" \uD83D\uDD34 "); // Caractère Unicode pour le jeton rouge
                } else if (plateau[i][j] == Joueur.JAUNE) { // Jeton du joueur 2 (jaune)
                    System.out.print(" \uD83D\uDFE1 "); // Caractère Unicode pour le jeton jaune
                } else { // Case vide
                    System.out.print(" \u26AB "); // Caractère Unicode pour une case vide
                }
                System.out.print("|");
            }
            // Aller à la ligne pour afficher la prochaine ligne
            System.out.println();
        }
    }
}
