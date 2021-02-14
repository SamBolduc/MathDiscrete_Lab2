package ca.samb.lab2.error;

import org.beryx.textio.InputReader;

import java.util.ArrayList;
import java.util.List;

public class InvalidOptionError implements InputReader.ErrorMessagesProvider {

    @Override
    public List<String> getErrorMessages(String s, String s1) {
        List<String> ret = new ArrayList<>();
        ret.add("");
        ret.add("L'option spécifiée est invalide, veuillez spécifier un nombre entre 1 et 5");
        return ret;
    }
}