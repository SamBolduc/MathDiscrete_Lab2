package ca.samb.lab2.manager;

import java.util.ArrayList;
import java.util.List;

public class NumberManager {

    public boolean estPremier(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int pgcd(int first, int second) {
        int mod;
        while (second != 0) {
            mod = first % second;
            first = second;
            second = mod;
        }

        return first;
    }

    public boolean hasDecimal(double number) {
        return number % 1 != 0;
    }

    private boolean divide(int divider, int divided) {
        return (double) divided % divider == 0;
    }

    private boolean estKnuth(List<String> result, int a, int c, int m) {
        //First criteria
        if (this.pgcd(c, m) != 1) {
            result.add("Le critère #1 n'est pas respecté.");
        }

        //Second criteria
        for (int p = 2; p <= m; p++) {
            if (this.estPremier(p) && this.divide(p, m)) {
                if (!this.divide(p, a - 1)) {
                    result.add("Le critère #2 n'est pas respecté.");
                }
            }
        }

        //Third criteria
        if (this.divide(4, m)) {
            if (!this.divide(4, a - 1)) {
                result.add("Le critère #3 n'est pas respecté.");
            }
        }

        //Fourth criteria
        if (c <= 0 || c >= m) {
            result.add("Le critère #4 n'est pas respecté.");
        }

        return result.isEmpty();
    }

    public List<String> pseudo(int a, int c, int m, int x0, int min, int max) {
        List<String> result = new ArrayList<>();

        if (!this.estKnuth(result, a, c, m)) {
            return result;
        }

        if (!hasDecimal((double) (max - min) / (double) m)) {
            result.add("L'équation (max - min) / m ne doit pas donner comme résultat un entier");
            return result;
        }

        int res = x0;
        for (int i = 0; i < m; i++) {
            result.add(String.valueOf(res));
            res = (a * res + c) % m;
        }
        return result;
    }
}
