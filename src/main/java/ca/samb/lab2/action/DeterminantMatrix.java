package ca.samb.lab2.action;

import ca.samb.lab2.manager.MatrixManager;
import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

public class DeterminantMatrix extends Action {
    public DeterminantMatrix(Menu menu) {
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

        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("Le déterminant de la première matrice est: " + getDeterminant(array, rowCount, rowCount));
        textIO.getTextTerminal().println();

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }

    public static int getDeterminant(int matrix[][], int initialSize, int size) {
        int result = 0;

        if (size == 1) return matrix[0][0];

        int tmp[][] = new int[initialSize][initialSize];

        int sign = 1;
        for (int i = 0; i < size; i++) {
            getCofactor(matrix, tmp, 0, i, size);
            result += getDeterminant(tmp, initialSize, size - 1) * matrix[0][i] * sign;
            sign *= -1;
        }

        return result;
    }

    public static void getCofactor(int matrix[][], int tmp[][], int p, int q, int matrixSize) {
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
