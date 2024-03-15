package controleur;

import vue.*;

public class ControleurJeux {
    IhmJeux ihm;

    public ControleurJeux (IhmJeux i) {
        this.ihm = i;
    }

    public void jouer() {
        int choix = ihm.choixJeu();
        switch (choix) {
            case 1 -> {
                jouerJeuNim();
            }
            case 2 -> {
                jouerJeuP4();
            }
            default -> {
                ihm.afficherErreur("Ce choix n'existe pas");
            }
        }
    }

    public void jouerJeuNim() {
        IhmJeuNim ihmNim = new IhmJeuNim();
        ControleurJeuNim c = new ControleurJeuNim(ihmNim);
        c.jouer();
    }

    public void jouerJeuP4() {
        IhmJeuP4 ihmP4 = new IhmJeuP4();
        ControleurJeuP4 c = new ControleurJeuP4(ihmP4);
        c.jouer();
    }


}
