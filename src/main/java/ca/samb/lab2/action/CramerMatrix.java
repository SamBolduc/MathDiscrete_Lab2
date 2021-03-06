package ca.samb.lab2.action;

import ca.samb.lab2.manager.MatrixManager;
import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

public class CramerMatrix extends Action {
    public CramerMatrix(Menu menu) {
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

        if (firstRowCount != 3 || firstColsCount != 3) {
            this.getMenu().showError("LA MATRICE 'A' DOIT FAIRE 3x3");
            return;
        }

        if (secondRowCount != 3 || secondColsCount != 1) {
            this.getMenu().showError("LA MATRICE 'B' DOIT FAIRE 3x1");
            return;
        }


        double detA = DeterminantMatrix.getDeterminant(firstMatrix, 3, 3);
        if (detA == 0) {
            if (manager.isHomogeneous(secondMatrix)) {
                this.getMenu().showError("IL Y A UNE INFINITÉ DE SOLUTIONS");
            } else {
                this.getMenu().showError("IL Y A SOIT UNE INFINITÉ DE SOLUTIONS, SOIT AUCUNE SOLUTION");
            }

            return;
        }

        double res[] = new double[3];
        for (int i = 0; i < 3; i++) {
            double[][] tmp = new double[3][3];
            for (int index = 0; index < firstMatrix.length; index++) {
                System.arraycopy(firstMatrix[index], 0, tmp[index], 0, firstMatrix[0].length);
                tmp[index][i] = secondMatrix[index][0];
            }

            res[i] = DeterminantMatrix.getDeterminant(tmp, 3, 3) / detA;
        }

        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("Le SEL admet une solution unique.");
        textIO.getTextTerminal().println(manager.asPrintable(res));
        textIO.getTextTerminal().println();

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }
}
