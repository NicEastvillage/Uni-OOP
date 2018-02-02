package week0.problem5;

import java.util.Scanner;

public class FeetMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input feet: ");
        Double feet = sc.nextDouble();
        Double meter = feet * 0.3048;

        System.out.println(feet + " feet is " + meter + " meter");
    }
}
