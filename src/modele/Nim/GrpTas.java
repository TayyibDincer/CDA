package modele.Nim;

public class GrpTas {
    /** Le nombre de tas initial */
    private final int nb;

    /** Un tableau représentant le tas */
    private final int[] tas;

    /**Constructeur de la classe GrpTas
     * @param nb Le nombre de tas du jeu de Nim*/
    public GrpTas(int nb) {
        this.nb=nb;
        tas=new int[nb];
    }

    /** Retourne le nombre de tas initial du jeu
     * @return nombre de tas initial */
    public int getNb() {
        return nb;
    }

    /** Retourne le tas sous la forme d'un tableau d'int
     * @return tableau de tas sous la forme : à la jème case il y a 2*j+1*/
    public int[] creation(){
        for (int j=0;j<nb;j++){
            tas[j]=2*j+1;
        }
        return tas;
    }

    /** Cette fonction vérifie si le coup 'm n', avec m et n des int, donné par l'utilisateur est valide. C'est-à-dire si m est compris entre 1 et le nombre de tas
     * @return Renvoie true si le coup 'm n' est valide */
    public boolean coupValide(int ligne,int nbAllumette) {
        if (!(nbAllumette<0)) {
            if (tas[ligne] >= nbAllumette) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /** Cette fonction retire une allumette et renvoie true, sinon renvoie false */
    public void retirer(int ligne, int nombreAllumette) {
             tas[ligne]-=nombreAllumette;
    }

    /** Cette fonction vérifie si la partie est terminé */
    public boolean estPartieTerminee() {
        for (int i=0;i<nb;i++) {
            if (tas[i]>0) {
                return false;
            }
        }
        return true;
    }
}
