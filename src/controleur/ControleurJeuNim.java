package controleur;
import modele.Joueur;
import vue.Ihm;
import modele.GrpTas;

public class ControleurJeuNim {
    Ihm ihm;
    public ControleurJeuNim(Ihm i){
        this.ihm=i;
    }
public void jouer() {
    int nb=ihm.nbTas();
    String nom1=ihm.nomJoueur();
    String nom2=ihm.nomJoueur(nom1);

    GrpTas tas=new GrpTas(nb);
    Joueur joueur1=new Joueur(nom1);
    Joueur joueur2=new Joueur(nom2);

    int[] tab=tas.creation();
    Joueur joueurActuel = joueur1;
    boolean continuer=true;

    while (continuer) {
        ihm.afficherTas(tab,nb);
        int[] coup=ihm.ligneEtNbAllumette(joueurActuel.getNom());

        boolean estRetiree = tas.retirer(coup[0], coup[1]);
        if (!estRetiree) { /* throws. */
            ihm.afficherErreur();
            continue;
        }
        else {
            if (tas.estPartieTerminee()) {
                joueurActuel.partieGagnee();

                boolean h = ihm.rejouerOuQuitter();
                if (h){ /* Ici le code pour relancer une partie */
                    tas =new GrpTas(tas.getNbInitial());

                    tab=tas.creation();

                    continue;
                }
                else {/* Ici le code pour quitter le jeu et afficher le vaiqueur */
                    continuer = false;
                    ihm.afficherPartiesGagnees(joueur1.getNom(), joueur1.getNbPartieGagnee());
                    ihm.afficherPartiesGagnees(joueur2.getNom(), joueur2.getNbPartieGagnee());

                    int gagnantJoueur1 = Joueur.jeuGagnee(joueur1, joueur2);

                    if (gagnantJoueur1>0){
                        ihm.afficherGagnant(joueur1.getNom());
                    }
                    else if (gagnantJoueur1<0) {
                        ihm.afficherGagnant(joueur2.getNom());
                    }
                    else {
                        ihm.afficherGagnant(joueur1.getNom(), joueur2.getNom());
                    }
                }
            }
        }
        if (joueurActuel.equals(joueur1)){
            joueurActuel=joueur2;
        }
        else{
            joueurActuel=joueur1;
        }
    }
}
}
