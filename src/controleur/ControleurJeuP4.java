package controleur;

import modele.Joueur;
import modele.P4.WrongColorException;
import modele.P4.Plateau;

import vue.IhmJeuP4;

public class ControleurJeuP4 {
    IhmJeuP4 ihm;

    public ControleurJeuP4 (IhmJeuP4 i) {
        this.ihm = i;
    }

    public void jouer() {
        String nom1 = ihm.nomJoueur();
        String nom2 = ihm.nomJoueur(nom1);
        Joueur joueur1 = new Joueur(nom1);
        Joueur joueur2 = new Joueur(nom2);
        Joueur joueurActuel = joueur1;

        Plateau p = new Plateau();

        boolean continuer = true;
        while(continuer) {
            System.out.println("\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34");
            System.out.println("\uD83D\uDD35\uD83D\uDFE1\uD83D\uDFE1\uD83D\uDFE1\u26AB\u26AB\uD83D\uDFE1");
            try {
                p.placerPion(5, 8);
            }
            catch (WrongColorException e) {
                ihm.afficherErreur("Erreur avec l'utilisation de la méthode Plateau.placerPion : " + e.getMessage());
                break;
            }
        }
    }
}
