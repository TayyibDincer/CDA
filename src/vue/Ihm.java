package vue;

import java.util.Scanner;

public class Ihm {

    private Scanner in;

    public Ihm() {
        this.in = new Scanner(System.in);
    }

    /** Cette fonction demande le nombre de tas. */
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

    /** Cette fonction demande le nom du joueur 2*/
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

    /** Cette fonction demande le nom du joueur 1 (surcharge) */
    public String nomJoueur() {
        return nomJoueur(null);
    }

    /** Cette fonction affiche le tas dans le terminal */
    public void afficherTas(int [] tas,int nb){
        for (int i=0;i<nb;i++){
            for (int j = 0; j < nb-i-1; j++) {
                    System.out.print(" ");}
            for (int j=0;j<tas[i];j++){
                System.out.print("|");}
            System.out.println();
        }
    }


    /** Cette fonction demande le coup du joueur et la retourne */
    public int[] ligneEtNbAllumette(String nom){
        Scanner in = new Scanner(System.in);
        int[] tab=new int[2];
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
                if (nb != 0) {
                    tab[0]=numTas-1;
                    tab[1]=nb;
                    return tab;
                }
            }
        }
    }

    /** Cette fonction demande si la personne veut rejouer une partie ou quitter et elle renvoie true si la personne désire rejouer et false sinon.*/
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
    public void afficherErreur(){
        afficherErreur("Le coup est invalide");
    }
    public void afficherErreur(String e) {
        System.out.println(e);
    }
    public void afficherGagnantPartie(String nom) {
        System.out.println("Le gagnant de cette partie est " + nom);
    }
}