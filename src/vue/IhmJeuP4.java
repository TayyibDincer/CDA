package vue;

import java.util.Scanner;

public class IhmJeuP4 extends IhmJeux {
    private Scanner in;
    private String rouge = "\uD83D\uDD34";
    private String jaune = "\uD83D\uDFE1";
    private String noir = "\u26AB";

    public IhmJeuP4() {
        this.in = new Scanner(System.in);
    }
}
