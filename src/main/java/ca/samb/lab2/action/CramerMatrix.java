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

        if (firstRowCount != 3 || firstColsCount != 3) {
            this.getMenu().showError("LA MATRICE 'A' DOIT FAIRE 3x3");
            return;
        }

        if (secondRowCount != 3 || secondColsCount != 1) {
            this.getMenu().showError("LA MATRICE 'B' DOIT FAIRE 3x1");
            return;
        }


        int detA = DeterminantMatrix.getDeterminant(firstMatrix, 3, 3);
        if (detA == 0) {
            if (manager.isHomogeneous(secondMatrix)) {
                this.getMenu().showError("IL Y A UNE INFINITÉ DE SOLUTIONS");
            } else {
                this.getMenu().showError("IL Y A SOIT UNE INFINITÉ DE SOLUTIONS, SOIT AUCUNE SOLUTION");
            }

            return;
        }

        textIO.getTextTerminal().println();

        for (int i = 0; i < 3; i++) {
            int[][] tmp = new int[3][3];
            for (int index = 0; index < firstMatrix.length; index++) {
                System.arraycopy(firstMatrix[index], 0, tmp[index], 0, firstMatrix[0].length);
                tmp[index][i] = secondMatrix[index][0];
            }

            textIO.getTextTerminal().println("x" + i + ": " + DeterminantMatrix.getDeterminant(tmp, 3, 3) / detA);
        }

        textIO.getTextTerminal().println();

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }

    private int getDeterminant(int matrix[][], int initialSize, int size) {
        int result = 0;

        if (size == 1) return matrix[0][0];

        int tmp[][] = new int[initialSize][initialSize];

        int sign = 1;
        for (int i = 0; i < size; i++) {
            this.getCofactor(matrix, tmp, 0, i, size);
            result += this.getDeterminant(tmp, initialSize, size - 1) * matrix[0][i] * sign;
            sign *= -1;
        }

        return result;
    }

    private void getCofactor(int matrix[][], int tmp[][], int p, int q, int matrixSize) {
        int row = 0;
        int col = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == p || j == q) continue;

                tmp[row][col++] = matrix[i][j];
                if (col == matrixSize - 1) {
                    col = 0;
                    row++;
                }
            }
        }
    }
}
