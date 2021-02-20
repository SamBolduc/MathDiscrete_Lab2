package ca.samb.lab2.manager;

import java.util.ArrayList;
import java.util.List;

public class MatrixManager {

    private double[][] firstMatrix;
    private double[][] secondMatrix;

    public List<String> asPrintable(double[] matrix) {
        List<String> ret = new ArrayList<>();

        StringBuilder line = new StringBuilder();
        line.append("[");
        for (double el : matrix) {
            line.append(String.format("%.4f  ", el));
        }
        ret.add(line.toString().trim() + "]");
        ret.add("");

        return ret;
    }

    public List<String> asPrintable(double[][] matrix) {
        List<String> ret = new ArrayList<>();

        for (double[] row : matrix) {
            StringBuilder line = new StringBuilder();
            for (double el : row) {
                line.append(String.format("%.2f  ", el));
            }
            ret.add(line.toString());
            ret.add("");
        }

        return ret;
    }

    public int getRowCount(double[][] matrix) {
        int rows = matrix.length;
        return rows == 0 ? -1 : rows;
    }

    public boolean isHomogeneous(double[][] matrix) {
        for (double[] rows : matrix) {
            for (double el : rows) {
                if (el != 0) return false;
            }
        }
        return true;
    }

    public int getColCount(double[][] matrix) {
        return this.getRowCount(matrix) == -1 ? -1 : matrix[0].length;
    }

    public void setFirstMatrix(double[][] firstMatrix) {
        this.firstMatrix = firstMatrix;
    }

    public double[][] getFirstMatrix() {
        return this.firstMatrix;
    }

    public void setSecondMatrix(double[][] secondMatrix) {
        this.secondMatrix = secondMatrix;
    }

    public double[][] getSecondMatrix() {
        return this.secondMatrix;
    }
}
