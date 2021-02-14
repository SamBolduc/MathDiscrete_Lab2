package ca.samb.lab2.menu;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

public abstract class Menu {

    private TextIO textIO;
    private TextTerminal<?> terminal;

    public Menu(TextIO textIO, TextTerminal<?> terminal){
        this.textIO = textIO;
        this.terminal = terminal;
    }

    public abstract void show();

    public TextIO getTextIO(){
        return this.textIO;
    }

    public TextTerminal<?> getTerminal(){
        return this.terminal;
    }
}