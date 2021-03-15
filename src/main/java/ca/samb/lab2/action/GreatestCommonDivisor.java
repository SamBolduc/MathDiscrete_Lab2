package ca.samb.lab2.action;

import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

public class GreatestCommonDivisor extends Action {
    public GreatestCommonDivisor(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();

        int firstN = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le premier nombre entier positif:");
        int secondN = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le deuxième nombre entier positif:");

        int mod;
        while (secondN != 0) {
            mod = firstN % secondN;
            firstN = secondN;
            secondN = mod;
        }

        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("PGCD: " + firstN);
        textIO.getTextTerminal().println();

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }
}
