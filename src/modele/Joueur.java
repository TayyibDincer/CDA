package modele;

public class Joueur {
    /**
     *
     * @param nom
     */
    private String nom;
    private int nbPartieGagnee;

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

    public void partieGagnee() {
        nbPartieGagnee++;
    }

    /* Cette fonction renvoie 0 si les deux joueurs sont à ex aequo,
    1 si c'est joueur1 qui a gagné la partie ou -1 si c'est le joueur2. */
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