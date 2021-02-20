package ca.samb.lab2.manager;

import java.util.ArrayList;
import java.util.List;

public class MatrixManager {

    private int[][] firstMatrix = {{1, 1, -1}, {2, -1, -1}, {0, -1, -1}};
    private int[][] secondMatrix = {{2}, {3}, {1}};

    public List<String> asPrintable(int[][] matrix) {
        List<String> ret = new ArrayList<>();

        for (int[] row : matrix) {
            StringBuilder line = new StringBuilder();
            for (int el : row) {
                line.append(String.format("%4d", el));
            }
            ret.add(line.toString());
            ret.add("");
        }

        return ret;
    }

    public int getRowCount(int[][] matrix) {
        int rows = matrix.length;
        return rows == 0 ? -1 : rows;
    }

    public boolean isHomogeneous(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int el : rows) {
                if (el != 0) return false;
            }
        }
        return true;
    }

    public int getColCount(int[][] matrix) {
        return this.getRowCount(matrix) == -1 ? -1 : matrix[0].length;
    }

    public void setFirstMatrix(int[][] firstMatrix) {
        this.firstMatrix = firstMatrix;
    }

    public int[][] getFirstMatrix() {
        return this.firstMatrix;
    }

    public void setSecondMatrix(int[][] secondMatrix) {
        this.secondMatrix = secondMatrix;
    }

    public int[][] getSecondMatrix() {
        return this.secondMatrix;
    }
}
