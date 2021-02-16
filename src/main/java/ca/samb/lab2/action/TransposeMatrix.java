package ca.samb.lab2.action;

import ca.samb.lab2.manager.MatrixManager;
import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

import java.util.List;

public class TransposeMatrix extends Action {
    public TransposeMatrix(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();
        MatrixManager manager = this.getMenu().getMatrixManager();

        int[][] array = this.getMenu().getMatrixManager().getFirstMatrix();

        if (array == null) {
            this.getMenu().showError("LA MATRICE N'A PAS ÉTÉ DÉFINIE");
            return;
        }

        int rowCount = manager.getRowCount(array);
        int colsCount = manager.getColCount(array);

        if (colsCount == -1 || rowCount != colsCount) {
            this.getMenu().showError("LA MATRICE N'EST PAS CARRÉE");
            return;
        }

        int[][] result = new int[rowCount][colsCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                result[i][j] = array[j][i];
            }
        }

        List<String> prompts = this.getMenu().getMatrixManager().asPrintable(result);
        textIO.getTextTerminal().println("Voici la transposé !");
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println(prompts);

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }
}
