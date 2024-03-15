package vue;

import java.util.Scanner;

public class IhmJeuNim extends IhmJeux{

    private Scanner in;

    public IhmJeuNim() {
        this.in = new Scanner(System.in);
    }

    /** Cette fonction demande le nombre de tas. */
    public int nbTas(){
        int nb = 0;
        while (nb < 1) {
            System.out.println("Le nombre de tas :");
            if (in.hasNextInt()) {
                nb = in.nextInt();
            } else {
                System.out.println("Veuillez saisir un nombre strictement plus grand que 0.");
                in.next();
            }
        }
        return nb;
    }

    /** Cette fonction demande le nom du joueur 2*/


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
        int[] tab=new int[2];
        while(true) {
            System.out.println(nom+" : à vous de jouer un coup sous la forme 'm n' où m est le tas choisi et n le nombre d'allumettes à retirer dans ce tas");
            if (in.hasNextLine()) {
                String ligne = in.nextLine();
                Scanner sc2 = new Scanner(ligne);
                int numTas = 0;
                int nb = 0;
                if (sc2.hasNextInt()) {
                    numTas = sc2.nextInt();
                }
                if (sc2.hasNextInt()) {
                    nb = sc2.nextInt();
                }
                if (nb != 0) {
                    tab[0]=numTas-1;
                    tab[1]=nb;
                    return tab;
                } else {
                    in.nextLine();
                }
            }

        }
    }
}