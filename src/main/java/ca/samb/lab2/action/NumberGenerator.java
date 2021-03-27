package ca.samb.lab2.action;

import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

public class NumberGenerator extends Action {
    public NumberGenerator(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();

        int a = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le a:");
        int c = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le c:");
        int m = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le m:");

        if (m <= 0) {
            this.getMenu().showError("LE NOMBRE D'ENTIER À GÉNÉRER DOIT ÊTRE POSITIF ET PLUS GRAND QUE 0");
            return;
        }

        int x0 = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le x0:");
        int min = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le min:");
        int max = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le max:");

        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println(DecimalConverter.join(this.getMenu().getNumberManager().pseudo(a, c, m, x0, min, max), ", "));
        textIO.getTextTerminal().println();
        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }
}
