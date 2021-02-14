package ca.samb.lab2.menu;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

public class MainMenu extends Menu {

    public MainMenu(TextIO textIO, TextTerminal<?> terminal) {
        super(textIO, terminal);
    }

    public void show() {
        this.getTerminal().println("Salut cmt cava");
        String user = this.getTextIO().newStringInputReader()
                .withDefaultValue("admin")
                .read("Username");
    }
}
