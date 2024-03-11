package vue;

import java.util.Scanner;

public class Ihm {

    private Scanner in;

    public Ihm() {
        this.in = new Scanner(System.in);
    }

    /* Cette fonction demande le nombre de tas. */
    public int nbTas(){
        int nb = 0;
        Scanner sc = new Scanner(System.in);
        while (nb < 1) {
            System.out.println("Le nombre de tas:");
            if (sc.hasNextInt()) {
                nb = sc.nextInt();
            } else {
                sc.next();
            }
        }
        return nb;
    }

    public String nomJoueur(String nom1) {
        String nom2 = "";
        Scanner sc = new Scanner(System.in);
        do {
            if (nom1 != null) {
                System.out.println("Le nom de joueur 2:");
                nom2=sc.next();
                if (nom1.equals(nom2)) {
                    System.out.println("Ce nom est déjà pris");
                }
            }
            else {
                System.out.println("Le nom de joueur 1:");
                nom2=sc.next();
            }
        } while (nom2.equals(nom1));

        return nom2;
    }
    public String nomJoueur() {
        return nomJoueur(null);
    }
    public void afficherTas(int [] tas,int nb){
        for (int i=0;i<nb;i++){
            for (int j = 0; j < tas.length-i-1; j++) {
                    System.out.print(" ");}
            for (int j=0;j<tas[i];j++){
                System.out.print("|");}
            System.out.println();
        }
    }
    public int[] ligneEtNbAllumette(String nom){
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println(nom+" : à vous de jouer un coup sous la forme 'm n' où m est le tas choisi et n le nombre d'allumettes à retirer dans ce tas");
            if (in.hasNextLine()) {
                String ligne = in.nextLine();
                Scanner sc = new Scanner(ligne);
                int numTas = 0;
                int nb = 0;
                if (sc.hasNextInt()) {
                    numTas = sc.nextInt();
                }
                if (sc.hasNextInt()) {
                    nb = sc.nextInt();
                }
                if (numTas != 0 && nb != 0) {

                    return new int[]{numTas-1, nb};
                }
            }
        }
    }
    public boolean rejouerOuQuitter(){
        Scanner sc =new Scanner(System.in);
        String ch="";
        while (true){
            System.out.println("Voulez-vous rejouer ou quitter le jeu ? (r/q)");
            if (sc.hasNext()){
                ch=sc.next();
                if (ch.equalsIgnoreCase("r")){
                    return true;
                }
                else if (ch.equalsIgnoreCase("q")) {
                    return false;
                }
                else {
                    sc.next();
                }
            }
        }
    }

    public void afficherPartiesGagnees(String nom, int nbPartiesGagnees) {
        System.out.println(nom.toString() + " a gagné " + nbPartiesGagnees);
    }

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
    public void afficherErreur(){
        System.out.println("le coup est invalide");
    }
}