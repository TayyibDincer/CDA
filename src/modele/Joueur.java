package modele;

public class Joueur {
    /** Le nom du joueur */
    private final String nom;

    /** Le nombre de parties gagnées du joueur */
    private int nbPartieGagnee;

    /** Le constructeur de la classe Joueur
     * @param nom Le nom du Joueur */
    public Joueur(String nom)  {
       this.nom=nom;
       nbPartieGagnee = 0;
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
}