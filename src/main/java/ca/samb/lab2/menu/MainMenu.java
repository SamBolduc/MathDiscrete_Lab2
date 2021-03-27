package ca.samb.lab2.menu;

import ca.samb.lab2.action.*;
import ca.samb.lab2.error.InvalidOptionError;
import ca.samb.lab2.manager.MatrixManager;
import ca.samb.lab2.manager.NumberManager;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu(TextIO textIO, TextTerminal<?> terminal, MatrixManager matrixManager, NumberManager numberManager) {
        super(textIO, terminal, matrixManager, numberManager);
    }

    @Override
    public void show() {
        List<String> menu = new ArrayList<String>();
        menu.add("0 - Quitter.");
        menu.add("1 - Définir les matrices.");
        menu.add("2 - Transposer la première matrice.");
        menu.add("3 - Calculer le déterminant de la première matrice.");
        menu.add("4 - Additionner les matrices.");
        menu.add("5 - Multiplier les matrices.");
        menu.add("6 - Appliquer la règle de Cramer.");
        menu.add("7 - Convertir un nombre vers une autre base.");
        menu.add("8 - Plus grand commun diviseur (PGCD)");
        menu.add("9 - Nombre premier.");
        menu.add("10 - Générateur de nombre aléatoire.");
        menu.add("");
        menu.add("Veuillez choisir une option:");

        while (true) {
            int action = this.getTextIO().newIntInputReader().withParseErrorMessagesProvider(new InvalidOptionError()).withMinVal(0).withMaxVal(10).read(menu);

            switch (action) {
                case 0:
                    new LeaveAction(this).execute();
                    break;
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
                    new DecimalConverter(this).execute();
                    break;
                case 8:
                    new GreatestCommonDivisor(this).execute();
                    break;
                case 9:
                    new PrimeValidator(this).execute();
                    break;
                case 10:
                    new NumberGenerator(this).execute();
                    break;
            }
        }
    }
}
