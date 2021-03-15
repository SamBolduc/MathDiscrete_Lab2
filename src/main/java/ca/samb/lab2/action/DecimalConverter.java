package ca.samb.lab2.action;

import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DecimalConverter extends Action {
    public DecimalConverter(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();

        int number = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer le nombre entier positif à convertir:");

        List<String> binary = new ArrayList<>();
        int i = number;
        while (i > 0) {
            binary.add(0, String.valueOf(i % 2));

            i /= 2;
        }

        List<String> hex = new ArrayList<>();
        i = number;

        int res;
        while (i > 0) {
            res = i % 16;

            if (res > 9) {
                hex.add(0, String.valueOf((char) (res + 55)));
            } else {
                hex.add(0, String.valueOf(res));
            }

            i /= 16;
        }

        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("Binaire: " + this.join(binary, ""));
        textIO.getTextTerminal().println("Hexadécimal: " + this.join(hex, ""));
        textIO.getTextTerminal().println();

        int wait = textIO.newIntInputReader().withDefaultValue(0).read("Appuyer sur [ENTER] pour continuer...");
    }

    private String join(Collection col, String spacer) {
        StringBuffer buffer = new StringBuffer();

        for (Iterator it = col.iterator(); it.hasNext(); buffer.append((String) it.next())) {
            if (buffer.length() != 0) {
                buffer.append(spacer);
            }
        }

        return buffer.toString();
    }
}
