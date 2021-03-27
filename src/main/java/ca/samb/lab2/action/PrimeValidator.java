package ca.samb.lab2.action;

import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

public class PrimeValidator extends Action {
    public PrimeValidator(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();

        int number = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le premier nombre entier positif:");

        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("Nombre premier: " + (this.getMenu().getNumberManager().estPremier(number) ? "Oui" : "Non"));
        textIO.getTextTerminal().println();

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }
}
