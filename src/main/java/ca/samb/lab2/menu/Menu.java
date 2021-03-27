package ca.samb.lab2.menu;

import ca.samb.lab2.manager.MatrixManager;
import ca.samb.lab2.manager.NumberManager;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

public abstract class Menu {

    private TextIO textIO;
    private TextTerminal<?> terminal;
    private MatrixManager matrixManager;
    private NumberManager numberManager;

    public Menu(TextIO textIO, TextTerminal<?> terminal, MatrixManager matrixManager, NumberManager numberManager) {
        this.textIO = textIO;
        this.terminal = terminal;
        this.matrixManager = matrixManager;
        this.numberManager = numberManager;
    }

    public abstract void show();

    public void showError(String msg) {
        this.terminal.println();
        this.terminal.println("**************** " + msg + " ****************");
        this.terminal.println();
    }

    public TextIO getTextIO() {
        return this.textIO;
    }

    public TextTerminal<?> getTerminal() {
        return this.terminal;
    }

    public MatrixManager getMatrixManager() {
        return this.matrixManager;
    }

    public NumberManager getNumberManager() {
        return this.numberManager;
    }
}