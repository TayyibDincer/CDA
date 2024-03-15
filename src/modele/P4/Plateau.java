package modele.P4;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    /** Le nombre de jetons de joueurs présent sur le plateau.*/
    private int nbJetons;

    /** Le nombre de cases totales du plateau de jeu.*/
    private final int cases;

    /** Le plateau de jeu*/
    private final int[][] plateau;

    /** Une liste de "Pair" qui est un couple (int x, int y) où x représente l'index des colonnes du plateau et y l'index de l'élément vide le plus en bas.*/
    private List<Pair> lp;

    /** Le constructeur par défaut de Plateau. Il initialise :
     * {@link #plateau},
     * {@link #nbJetons} à 0,
     * {@link #cases} à 7*7,
     * la liste {@link #lp} et la remplie de 7 Pair (i, 6) pour tout i de 0 à 6 (représentant les index des colonnes du plateau).*/
    public Plateau() {
        this.plateau = new int[7][7];
        this.nbJetons = 0;
        this.cases = 7*7;
        this.lp = new ArrayList<>(){};
        for (int i = 0; i < 7; i++) {
            lp.add(i, new Pair(i, 6));
        }
    }

    /** Retourne le nombre de jetons sur le plateau*/
    public int getNbJetons() {
        return nbJetons;
    }

    /** Retourne true si le plateau est plein, et false sinon*/
    public boolean plateauEstPlein() {
        return nbJetons == cases;
    }

    /**
     * @param colonne un int qui représente l'index de la colonne du plateau
     * @param couleur un entier qui représente la couleur du pion :1 pour la couleur joueur1, -1 pour la couleur joueur2
     * @throws WrongColorException Survient lorsque la variable couleur est différente de -1 ou de 1.*/
    public void placerPion(int colonne, int couleur) throws WrongColorException {
        if (couleur != -1 || couleur != 1) { // J'ai pensé à créer un id pour chaque joueur et prendre cet id en paramètre à la place du int couleur.
            throw new WrongColorException("La couleur du pion doit être -1 si c'est le joueur 2 qui place le pion et 1 si c'est le joueur 1 qui le place.");
        }
        Pair p = lp.get(colonne);
        this.plateau[p.getX()][p.getY()] = couleur;
        p.setY(p.getY() - 1);
    }

    public boolean coupValide(int colonne) {
        return lp.get(colonne).getY() != -1;
    }

    /** Classe interne Pair*/
    public static class Pair {
        private final int[] pair;
        public Pair(int x, int y) {
            this.pair = new int[]{x, y};
        }
        public int getX() {
            return pair[0];
        }
        public int getY() {
            return pair[1];
        }
        public void setY(int y) {
            this.pair[1] = y;
        }
    }
}