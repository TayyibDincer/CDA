package vue;

import java.util.Scanner;

public class IhmJeux {
    private Scanner in;
    public IhmJeux() {
        this.in = new Scanner(System.in);
    }
    public String nomJoueur(String nom1) {
        String nom2 = "";
        do {
            if (nom1 != null) {
                System.out.println("Le nom de joueur 2:");
                nom2=in.next();
                if (nom1.equals(nom2)) {
                    System.out.println("Ce nom est déjà pris");
                }
            }
            else {
                System.out.println("Le nom de joueur 1:");
                nom2=in.next();
            }
        } while (nom2.equals(nom1));

        return nom2;
    }

    /** Cette fonction demande le nom du joueur 1 (surcharge) */
    public String nomJoueur() {
        return nomJoueur(null);
    }

    /** Cette fonction demande si la personne veut rejouer une partie ou quitter et elle renvoie true si la personne désire rejouer et false sinon.*/
    public boolean rejouerOuQuitter(){
        String ch="";
        while (true){
            System.out.println("Voulez-vous rejouer ou quitter le jeu ? (r/q)");
            if (in.hasNext()){
                ch=in.next();
                if (ch.equalsIgnoreCase("r")){
                    return true;
                }
                else if (ch.equalsIgnoreCase("q")) {
                    return false;
                }
            }
        }
    }

    /** affiche le nombre de parties gagnées pour un joueur */
    public void afficherPartiesGagnees(String nom, int nbPartiesGagnees) {
        System.out.println(nom.toString() + " a gagné " + nbPartiesGagnees);
    }

    /** Affiche le gagnant */
    public void afficherGagnant(String nom1) {
        afficherGagnant(nom1, null);
    }
    public void afficherGagnant(String nom1, String nom2) {
        if (nom2 == null) {
            System.out.println("Le gagnant est " + nom1.toString());
        }
        else {
            System.out.println("C'est un ex aequo pour " + nom1.toString() + " et " + nom2.toString());
        }
    }
    public void afficherErreur(String e) {
        System.out.println(e);
    }
    public void afficherGagnantPartie(String nom) {
        System.out.println("Le gagnant de cette partie est " + nom);
    }

    public int choixJeu() {
        int choix = 0;
        System.out.println("A quel jeu voulez-vous jouez ?\n1 - Jeu de Nim\n2 - Jeu de Puissance 4");
        while(choix <= 0 || choix > 2) {
            if (in.hasNextInt()) {
                choix = in.nextInt();
            }
            if (choix <= 0 || choix > 2) {
                System.out.println("Ce choix est invalide");
            }
        }
        return choix;
    }
}
