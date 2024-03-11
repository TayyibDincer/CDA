package modele;

import java.util.ArrayList;

public class GrpTas {
    /**
     * @param nb - la nombre des Tas
     * @throws ArrayIndexOutOfBoundsException- si le paramètre superieur à la taille du tableau ou inférieur à 0.
     */
    private int nb;

    public int getNbInitial() {
        return nbInitial;
    }

    private final int nbInitial;
    private int[] tas;

    public GrpTas(int nb) {
        this.nb=nb;
        tas=new int[nb];
        this.nbInitial = nb;
    }

    /* Cette fonction crée le tas */
    public int[] creation(){
        for (int j=0;j<nb;j++){
            tas[j]=2*j+1;
        }
        return tas;
    }

    /* Cette fonction vérifie si le coup 'm n' donné par l'utilisateur est valide après vérification du type */
    public boolean coupValide(int ligne,int nbAllumette) throws ArrayIndexOutOfBoundsException{
      if (0>(ligne) || (ligne)>(nb-1)){
          throw new ArrayIndexOutOfBoundsException("la ligne doit être entre 0 et " + (nb - 1));}
      else{
          if (tas[ligne]>=nbAllumette){
              return true;
          }
          else{
              return false;
          }
      }
    }

    /* Cette fonction retire une allumette et renvoie true, sinon renvoie false */
    public boolean retirer(int ligne, int nombreAllumette) {
        if (coupValide(ligne, nombreAllumette)) {
            tas[ligne]-=nombreAllumette;
            return true;
        }
        else {
            return false;
        }
    }

    /* Cette fonction vérifie si la partie est terminé */
    public boolean estPartieTerminee() {
        for (int i=0;i<nb;i++) {
            if (tas[i]>0) {
                return false;
            }
        }
        return true;
    }

}
