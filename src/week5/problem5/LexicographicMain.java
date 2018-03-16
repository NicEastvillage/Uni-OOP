package week5.problem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LexicographicMain {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("cuiusvis, hominis, est, errare, nullius, nisi, insipientis, in, errore, perseverare".split(", ")));

        Collections.sort(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
