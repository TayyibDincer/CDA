package modele;

public class Joueur {
    /** Le nom du joueur */
    private final String nom;
    private int couleur ; // rouge 1 ou jaune -1

    /** Le nombre de parties gagnées du joueur */
    private int nbPartieGagnee;
   /*les couleurs suivantes sont en int pour facilter le travail , ca n'as
   rien a voir avec l'affichage des couleur dans l'ihm
    */
    public static final int ROUGE = 1;
    public static final int JAUNE = -1;

    /**
     * Le constructeur de la classe Joueur
     *
     * @param nom   Le nom du Joueur
     * @param rouge
     */
    public Joueur(String nom, int rouge)  {
       this.nom=nom;
       nbPartieGagnee = 0;
       this.couleur=couleur;
    }

    public int getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }
    public int getNbPartieGagnee() {
        return nbPartieGagnee;
    }

    /** Ajoute 1 aux nombres de parties gagnées du joueur */
    public void partieGagnee() {
        nbPartieGagnee++;
    }

    /** Cette fonction renvoie 0 si les deux joueurs sont à ex aequo, 1 si c'est joueur1 qui a gagné la partie, ou -1 si c'est le joueur2.
     * @param joueur1 Le joueur 1
     * @param joueur2 Le joueur 2*/
    public static int jeuGagnee(Joueur joueur1, Joueur joueur2) {
        if (joueur1.getNbPartieGagnee() > joueur2.getNbPartieGagnee()) {
            return 1;
        }
        else if (joueur1.getNbPartieGagnee() < joueur2.getNbPartieGagnee()) {
            return -1;
        }
        else {
            return 0;
        }
    }
    public static boolean verifierVainqueur(int[][] plateau, int couleur) {
        // Vérification horizontale
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                if (plateau[i][j] == couleur &&
                        plateau[i][j+1] == couleur &&
                        plateau[i][j+2] == couleur &&
                        plateau[i][j+3] == couleur) {
                    return true;
                }
            }
        }

        // Vérification verticale
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (plateau[i][j] == couleur &&
                        plateau[i+1][j] == couleur &&
                        plateau[i+2][j] == couleur &&
                        plateau[i+3][j] == couleur) {
                    return true;
                }
            }
        }

        // Vérification diagonale (de gauche à droite)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (plateau[i][j] == couleur &&
                        plateau[i+1][j+1] == couleur &&
                        plateau[i+2][j+2] == couleur &&
                        plateau[i+3][j+3] == couleur) {
                    return true;
                }
            }
        }

        // Vérification diagonale (de droite à gauche)
        for (int i = 0; i < 4; i++) {
            for (int j = 6; j >= 3; j--) {
                if (plateau[i][j] == couleur &&
                        plateau[i+1][j-1] == couleur &&
                        plateau[i+2][j-2] == couleur &&
                        plateau[i+3][j-3] == couleur) {
                    return true;
                }
            }
        }
        // dans le cas ou il n'y a pas d'alignement de meme couleur
        return false;
    }



}

