package controleur;

import modele.Joueur;
import modele.Nim.GrpTas;

import vue.IhmJeuNim;

public class ControleurJeuNim {
    /**
     * L'IhmJeuNim
     */
    IhmJeuNim ihm;

    /**
     * Constructeur de la classe ControleurJeuNim
     *
     * @param i L'ihm
     */
    public ControleurJeuNim(IhmJeuNim i) {
        this.ihm = i;
    }
    private int melina;

    public void jouer() {
        /* Demande le nombre de tas "nb" le nom du joueur 1 "nom1" et le nom du joueur 2 "nom2" */
        int nb = ihm.nbTas();
        String nom1 = ihm.nomJoueur();
        String nom2 = ihm.nomJoueur(nom1);

        /* Crée une instance de GrpTas "tas" */
        GrpTas tas = new GrpTas(nb);

        /* Crée des instances de Joueur pour les deux joueurs */
        Joueur joueur1 = new Joueur(nom1, Joueur.ROUGE);
        Joueur joueur2 = new Joueur(nom2, Joueur.ROUGE);

        /* Extrait un tableau de tas */
        int[] tab = tas.creation();

        Joueur joueurActuel = joueur1;
        boolean continuer = true;

        /* Boucle qui gère les parties. La boucle est quittée si l'utilisateur décide de quitter le jeu */
        while (continuer) {
            /* Affiche le tas dans le terminal et récupère le coup 'm n' sous la forme d'un tableau à deux valeurs */
            ihm.afficherTas(tab, nb);
            int[] coup = ihm.ligneEtNbAllumette(joueurActuel.getNom());
            if ((coup[0] <= nb - 1) && (coup[0] >= 0)) {
                if (tas.coupValide(coup[0], coup[1])) {
                    tas.retirer(coup[0], coup[1]);
                    /* Si le coup est valide on teste si la partie est terminée */
                    if (tas.estPartieTerminee()) {
                        joueurActuel.partieGagnee();
                        ihm.afficherGagnantPartie(joueurActuel.getNom());
                        /* True s'ils veulent rejouer et false sinon */
                        boolean h = ihm.rejouerOuQuitter();

                        if (h) { /* Ici le code pour rejouer une partie */

                            /* Réinitialise tas avec le nb d'allumettes donné au début du jeu */
                            tas = new GrpTas(tas.getNb());

                            /* Réinitialise le tableau d'int */
                            tab = tas.creation();

                            continue;
                        } else { /* Ici le code pour quitter le jeu et afficher le vainqueur */
                            /* On met continuer à false pour quitter la boucle while */
                            continuer = false;

                            /* On affiche le nombre de parties gagnées pour chaque joueur */
                            ihm.afficherPartiesGagnees(joueur1.getNom(), joueur1.getNbPartieGagnee());
                            ihm.afficherPartiesGagnees(joueur2.getNom(), joueur2.getNbPartieGagnee());

                            /* Affichage du gagnant ou ex aequo */
                            int gagnantJoueur1 = Joueur.jeuGagnee(joueur1, joueur2);

                            if (gagnantJoueur1 > 0) {
                                ihm.afficherGagnant(joueur1.getNom());
                            } else if (gagnantJoueur1 < 0) {
                                ihm.afficherGagnant(joueur2.getNom());
                            } else {
                                ihm.afficherGagnant(joueur1.getNom(), joueur2.getNom());
                            }
                        }
                    }
                    /* changer de joueur à chaque tour de jeu */
                    if (joueurActuel.equals(joueur1)) {
                        joueurActuel = joueur2;
                    } else {
                        joueurActuel = joueur1;
                    }
                }
                else {
                    ihm.afficherErreur("Coup invalide. Il n'y a pas assez d'allumettes dans le tas choisi.");
                }

            }
            /* On affiche une erreur si le coup est invalide */
            else {
                ihm.afficherErreur("la ligne doit être ente 1 et " + nb);
            }


        }
    }
}

