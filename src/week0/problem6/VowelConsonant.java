package week0.problem6;

import java.util.Scanner;

public class VowelConsonant {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Character: ");
        Character cha = sc.next().charAt(0);
        if (Character.isLetter(cha)) {
            switch (cha) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                case 'æ':
                case 'ø':
                case 'å':
                    System.out.println(cha + " is a vowel!");
                    break;
                default:
                    System.out.println(cha + " is a consonant!");
            }
        } else {
            System.out.println("Not a letter");
        }

        sc.close();
    }
}
