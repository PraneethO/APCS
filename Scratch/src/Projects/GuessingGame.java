package Projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int numGuesses = 0;

        while (true) {
            System.out.println("Welcome to the guessing game!");
            int number = (int) ((Math.random() + .1) * 9);

            System.out.print("Enter a guess: ");
            int guess = sc.nextInt();
            numGuesses++;

            while (number != guess) {
                if (number > guess) {
                    System.out.println("Too low!");
                } else if (number < guess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Just right!");
                    break;
                }

                System.out.print("Enter a guess: ");
                guess = sc.nextInt();
                numGuesses++;
            }

            appendFile("output.txt", numGuesses + "");
            System.out.println("Here is your average number of guesses: " + getAverage("output.txt"));

            System.out.print("Do you want to keep playing (Y/N)? ");
            String ask = sc.next();

            while (!ask.equals("Y") && !ask.equals("N")) {
                System.out.println("Invalid Input");
                System.out.print("Do you want to keep playing (Y/N)? ");
                ask = sc.next();
            }

            if (ask.equals("N"))
                break;
        }
        sc.close();
    }

    public static void appendFile(String inputFile, String message) throws FileNotFoundException {
        String currentFile = "";
        try {
            Scanner fileScan = new Scanner(new File(inputFile));
            while (fileScan.hasNext()) {
                currentFile += fileScan.nextLine() + "\n";
            }
            PrintWriter pw = new PrintWriter(inputFile);
            pw.print(currentFile);
            pw.println(message);
            pw.close();
        } catch (FileNotFoundException e) {
            PrintWriter pw = new PrintWriter(inputFile);
            pw.println(message);
            pw.close();
        }
    }

    public static double getAverage(String inputFile) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File(inputFile));

        int total = 0;
        int numNumbers = 0;

        while (fileScan.hasNextInt()) {
            total += fileScan.nextInt();
            numNumbers++;
        }

        return (double) total / numNumbers;
    }
}
