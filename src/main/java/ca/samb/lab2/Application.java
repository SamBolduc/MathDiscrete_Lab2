package ca.samb.lab2;

import ca.samb.lab2.menu.MainMenu;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class Application {

    private String[] args;
    private TextIO textIO;
    private TextTerminal<?> terminal;

    private MainMenu mainMenu;

    public Application(String[] args) {
        this.args = args;
        this.textIO = TextIoFactory.getTextIO();
        this.terminal = this.textIO.getTextTerminal();

        this.mainMenu = new MainMenu(this.textIO, this.terminal);
        this.mainMenu.show();
    }
}
