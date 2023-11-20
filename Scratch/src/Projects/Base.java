package Projects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int initialNumber;
        int base;

        while (true) {
            while (true) {
                try {
                    System.out.print("Enter base 10 number: ");
                    initialNumber = sc.nextInt();
                    if (initialNumber < 0) {
                        System.out.println("Invalid decimal number: " + initialNumber);
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid decimal number");
                    sc.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Enter desired base: ");
                    base = sc.nextInt();
                    if (base <= 1 || base > 36) {
                        System.out.println("Invalid base number: " + base + ". Base has to be between 2 and 36");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid base number. Base number is an integer.");
                    sc.nextLine();
                }
            }

            System.out.println(initialNumber + " in base " + base + " is " + baseConvert(initialNumber, base));

            sc.nextLine();
            System.out.print("Do you want to play again (y/n): ");
            String nextInput = sc.nextLine();

            if (!nextInput.equals("y")) {
                break;
            }
        }

        sc.close();
    }

    // precondition: num is in base 10, base isn't 0, base is in between 1 and 16
    // returns a string with base (base) from num with base 10
    public static String baseConvert(int num, int base) {
        if (num == 0) {
            return "0";
        } else if (base == 0) {
            return "-1";
        }

        String result = "";

        // is this the most efficient way to do this? no. do I care? no.
        for (int i = largestExp(num, base); i >= 0; i--) {

            int nextNum = num / power(base, i);

            if (nextNum == 0) {
                result += "0";
                continue;
            }

            if (nextNum > 9) {
                result += (char) (nextNum + 55);
            } else {
                result += "" + nextNum;
            }

            num -= power(base, i) * nextNum;

        }

        return result;
    }

    // returns largest exponent that goes into num (base is base)
    public static int largestExp(int num, int base) {
        int exp = 0;

        while (num >= power(base, exp)) {
            exp += 1;
        }

        return exp - 1;
    }

    // returns num to the power of power
    public static int power(int num, int power) {

        int initialNum = 1;
        for (int i = 0; i < power; i++) {
            initialNum *= num;
        }

        return initialNum;
    }
}
