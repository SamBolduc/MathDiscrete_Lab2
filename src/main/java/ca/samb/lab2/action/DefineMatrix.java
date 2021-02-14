package ca.samb.lab2.action;

import ca.samb.lab2.error.InvalidOptionError;
import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

import java.util.List;

public class DefineMatrix extends Action {
    public DefineMatrix(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();

        for (int matrixIndex = 0; matrixIndex < 2; matrixIndex++) {
            String matrix = matrixIndex == 0 ? "PREMIÈRE MATRICE" : "DEUXIÈME MATRICE";
            textIO.getTextTerminal().println("************** " + matrix + " **************");

            int rows = textIO.newIntInputReader().withParseErrorMessagesProvider(new InvalidOptionError()).withMinVal(2).read("Entrez le nombre de ligne:");
            int cols = textIO.newIntInputReader().withParseErrorMessagesProvider(new InvalidOptionError()).withMinVal(2).read("Entrez le nombre de colonne:");

            int[][] array = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    List<String> prompts = this.getMenu().getMatrixManager().asPrintable(array);
                    prompts.add("Entrez la valeur de l'élément de l'emplacement [" + (i + 1) + "," + (j + 1) + "]:");

                    int value = textIO.newIntInputReader().withParseErrorMessagesProvider(new InvalidOptionError()).read(prompts);
                    array[i][j] = value;
                }
            }

            if (matrixIndex == 0) {
                this.getMenu().getMatrixManager().setFirstMatrix(array);
            } else {
                this.getMenu().getMatrixManager().setSecondMatrix(array);
            }
        }
    }
}
