package ca.samb.lab2.action;

import ca.samb.lab2.manager.MatrixManager;
import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

import java.util.List;

public class SumMatrix extends Action {
    public SumMatrix(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();
        MatrixManager manager = this.getMenu().getMatrixManager();

        double[][] firstMatrix = this.getMenu().getMatrixManager().getFirstMatrix();
        double[][] secondMatrix = this.getMenu().getMatrixManager().getSecondMatrix();

        if (firstMatrix == null || secondMatrix == null) {
            this.getMenu().showError("LES MATRICES N'ONT PAS ÉTÉ DÉFINIES");
            return;
        }

        int firstRowCount = manager.getRowCount(firstMatrix);
        int firstColsCount = manager.getColCount(firstMatrix);

        int secondRowCount = manager.getRowCount(secondMatrix);
        int secondColsCount = manager.getColCount(secondMatrix);

        if (secondRowCount == -1 || firstRowCount != secondRowCount || firstColsCount != secondColsCount) {
            this.getMenu().showError("LES MATRICES NE SONT PAS DE LA MÊME TAILLE");
            return;
        }

        double[][] result = new double[firstRowCount][firstColsCount];
        for (int i = 0; i < firstRowCount; i++) {
            for (int j = 0; j < firstColsCount; j++) {
                result[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        List<String> prompts = this.getMenu().getMatrixManager().asPrintable(result);
        textIO.getTextTerminal().println("Voici l'addition des matrices !");
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println(prompts);

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }
}
