package ca.samb.lab2.action;

import ca.samb.lab2.manager.NumberManager;
import ca.samb.lab2.menu.Menu;
import org.beryx.textio.TextIO;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RSA extends Action{

    int p, q, n, z, d = 0, e, i, c;
    int msg;
    String text;

    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public RSA(Menu menu) {
        super(menu);
    }

    private int indexOf(char c) {
        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] == c)
                return i;
        }
        return -1;
    }

    @Override
    public void execute() {
        TextIO textIO = this.getMenu().getTextIO();
        StringBuilder decryptedMessage = new StringBuilder();
        StringBuilder cryptedMessage = new StringBuilder();

        text = textIO.newStringInputReader().withDefaultValue("bonjour").read("Veuillez entrer le texte à chiffrer");
        e = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer la valeur de E");
        p = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer la valeur de P");
        q = textIO.newIntInputReader().withDefaultValue(0).read("Veuillez entrer la valeur de Q");

        n = p*q;
        z = (p-1)*(q-1);

        NumberManager numberManager = new NumberManager();
        for (e = 2; e < z; e++) {
            if (numberManager.pgcd(e, z) == 1)
                break;
        }

        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }

        for(int i = 0; i < this.text.length(); i++) {
            msg = this.indexOf(this.text.charAt(i));
            c = (int)(Math.pow(msg, e) % n);
            cryptedMessage.append(c).append(" ");
        }

        textIO.getTextTerminal().println("La chaine chiffré est : " + cryptedMessage.toString());

        String[] numbers = cryptedMessage.toString().split(" ");
        for (String s : numbers) {
            int number = Integer.parseInt(s);
            decryptedMessage.append(this.alphabet[(int)(Math.pow(number, d) % n)]);
        }
        textIO.getTextTerminal().println("Le message déchiffré est : " + decryptedMessage.toString());
    }
}
