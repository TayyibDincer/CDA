package main;

import controleur.ControleurJeux;
import vue.IhmJeuNim;

public class Main {
    public static void main(String[] args) {
        IhmJeuNim ihm = new IhmJeuNim();
        ControleurJeux controleurJeux=new ControleurJeux(ihm);
        controleurJeux.jouer();
    }
}