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
        Joueur joueur1 = new Joueur(nom1, Joueur.ROUGE); // Joueur 1 avec la couleur rouge
        Joueur joueur2 = new Joueur(nom2, Joueur.JAUNE); // Joueur 2 avec la couleur jaune
        Joueur joueurActuel = joueur1;

        Plateau p = new Plateau();

        boolean continuer = true;
        /*while (continuer) {
            ihm.afficherPlateau(p); // Afficher le plateau avant chaque tour

            // Demander au joueur actuel de placer un pion
            try {
                int colonne = ihm.choisirColonne(joueurActuel.getNom());
                p.placerPion(colonne, joueurActuel);
            } catch (WrongColorException e) {
                ihm.afficherErreur("Erreur : Mauvaise couleur de joueur !");
            }

            // Vérifier s'il y a un gagnant ou si la grille est pleine
            if (Joueur.verifierVainqueur(p, joueurActuel.getCouleur())) {
                // Afficher le plateau final
                ihm.afficherPlateau(p.getPlateau());
                // Afficher le nom du joueur gagnant
                ihm.afficherMessage(joueurActuel.getNom() + " remporte la partie !");
                // Mettre à jour le nombre de parties gagnées du joueur
                joueurActuel.partieGagnee();
                // Demander aux joueurs s'ils veulent rejouer
                continuer = ihm.rejouerPartie();
            } else if (p.plateauEstPlein()) {
                // Afficher le plateau final
                ihm.afficherPlateau(p.getPlateau());
                // Afficher un message de match nul
                ihm.afficherMessage("Match nul !");
                // Demander aux joueurs s'ils veulent rejouer
                continuer = ihm.rejouerPartie();
            }

            // Changer de joueur pour le prochain tour
            if (joueurActuel == joueur1) {
                joueurActuel = joueur2;
            } else {
                joueurActuel = joueur1;
            }
        }*/


        while(continuer) {
            System.out.println("\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34\uD83D\uDD34");
            System.out.println("\uD83D\uDD35\uD83D\uDFE1\uD83D\uDFE1\uD83D\uDFE1\u26AB\u26AB\uD83D\uDFE1");//je comprends pas
            try{
                p.placerPion(5,joueurActuel);}

            catch (WrongColorException e){
                ihm.afficherErreur("Erreur : Index en dehors des limites du plateau !");

            }

        }
    }
}
