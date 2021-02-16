package ca.samb.lab2.action;

import ca.samb.lab2.manager.MatrixManager;
import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

import java.util.List;

public class MultiplyMatrix extends Action {
    public MultiplyMatrix(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();
        MatrixManager manager = this.getMenu().getMatrixManager();

        int[][] firstMatrix = this.getMenu().getMatrixManager().getFirstMatrix();
        int[][] secondMatrix = this.getMenu().getMatrixManager().getSecondMatrix();

        if (firstMatrix == null || secondMatrix == null) {
            this.getMenu().showError("LES MATRICES N'ONT PAS ÉTÉ DÉFINIES");
            return;
        }

        int firstRowCount = manager.getRowCount(firstMatrix);
        int firstColsCount = manager.getColCount(firstMatrix);

        int secondRowCount = manager.getRowCount(secondMatrix);
        int secondColsCount = manager.getColCount(secondMatrix);

        if (firstRowCount == -1 || secondRowCount == -1 || firstColsCount != secondRowCount) {
            this.getMenu().showError("LE NOMBRE DE COLONNES DE LA PREMIÈRE MATRICE DOIT ÊTRE ÉGAL AU NOMBRE DE LIGNES DE LA DEUXIÈME MATRICE");
            return;
        }

        int[][] result = new int[firstRowCount][secondColsCount];
        for (int i = 0; i < firstColsCount; i++) {
            for (int j = 0; j < secondColsCount; j++) {
                result[i][j] = 0;
                for (int k = 0; k < firstColsCount; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        List<String> prompts = this.getMenu().getMatrixManager().asPrintable(result);
        textIO.getTextTerminal().println("Voici la multiplication des matrices !");
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println(prompts);

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }
}
