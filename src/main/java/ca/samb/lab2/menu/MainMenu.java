package ca.samb.lab2.menu;

import ca.samb.lab2.action.*;
import ca.samb.lab2.error.InvalidOptionError;
import ca.samb.lab2.manager.MatrixManager;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu(TextIO textIO, TextTerminal<?> terminal, MatrixManager matrixManager) {
        super(textIO, terminal, matrixManager);
    }

    @Override
    public void show() {
        List<String> menu = new ArrayList<String>();
        menu.add("1 - Définir les matrices.");
        menu.add("2 - Transposer la première matrice.");
        menu.add("3 - Calculer le déterminant de la première matrice.");
        menu.add("4 - Additionner les matrices.");
        menu.add("5 - Multiplier les matrices.");
        menu.add("6 - Appliquer la règle de Cramer.");
        menu.add("7 - Quitter.");
        menu.add("");
        menu.add("Veuillez choisir une option:");

        while (true) {
            int action = this.getTextIO().newIntInputReader().withParseErrorMessagesProvider(new InvalidOptionError()).withMinVal(1).withMaxVal(7).read(menu);

            switch (action) {
                case 1:
                    new DefineMatrix(this).execute();
                    break;
                case 2:
                    new TransposeMatrix(this).execute();
                    break;
                case 3:
                    new DeterminantMatrix(this).execute();
                    break;
                case 4:
                    new SumMatrix(this).execute();
                    break;
                case 5:
                    new MultiplyMatrix(this).execute();
                    break;
                case 6:
                    new CramerMatrix(this).execute();
                    break;
                case 7:
                    new LeaveAction(this).execute();
                    break;
            }
        }
    }
}
