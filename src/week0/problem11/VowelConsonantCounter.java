package week0.problem11;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VowelConsonantCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Word(s): ");
        String word = sc.nextLine();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (Character.isLetter(c)) {
                if (isVowel(c)) vowels++;
                else consonants++;
            }
        }

        System.out.println("The word(s) \"" + word + "\" contains " + vowels + " vowels and " + consonants + " consonants.");

        sc.close();
    }

    public static boolean isVowel(Character c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
            case 'æ':
            case 'ø':
            case 'å':
                return true;
        }
        return false;
    }
}
