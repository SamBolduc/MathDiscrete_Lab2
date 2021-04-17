package ca.samb.lab2.menu;

import ca.samb.lab2.action.*;
import ca.samb.lab2.error.InvalidOptionError;
import ca.samb.lab2.manager.MatrixManager;
import ca.samb.lab2.manager.NumberManager;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu(TextIO textIO, TextTerminal<?> terminal, MatrixManager matrixManager, NumberManager numberManager) {
        super(textIO, terminal, matrixManager, numberManager);
    }

    @Override
    public void show() {
        List<String> menu = new ArrayList<String>();
        menu.add("0 - Quitter.");
        menu.add("1 - RSA.");
        menu.add("");
        menu.add("Veuillez choisir une option:");

        while (true) {
            int action = this.getTextIO().newIntInputReader().withParseErrorMessagesProvider(new InvalidOptionError()).withMinVal(0).withMaxVal(10).read(menu);

            switch (action) {
                case 0:
                    new LeaveAction(this).execute();
                    break;
                case 1:
                    new RSA(this).execute();
                    break;
            }
        }
    }
}
