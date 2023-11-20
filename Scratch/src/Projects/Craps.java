package Projects;

import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        String name;
        int diceOne, diceTwo, sum, point;
        Scanner sc = new Scanner(System.in);
        String userInput = "Y";

        System.out.println("Welcome to APCS Casino!");
        System.out.print("Please enter your name: ");
        name = sc.nextLine();
        System.out.println("Hello, " + name + ", let's play!");

        do {

            diceOne = (int) (Math.random() * 6 + 1);
            diceTwo = (int) (Math.random() * 6 + 1);
            point = diceOne + diceTwo;
            System.out.println("You rolled " + diceOne + " + " + diceTwo + " = " + point);
            switch (point) {
                case 2:
                    System.out.println("Because the sum is 2, you lost!");
                    break;
                case 3:
                    System.out.println("Because the sum is 3, you lost!");
                    break;
                case 12:
                    System.out.println("Because the sum is 12, you lost!");
                    break;
                case 7:
                    System.out.println("Because the sum is 7, you won!");
                    break;
                case 11:
                    System.out.println("Because the sum is 11, you won!");
                    break;
                default:
                    System.out.println(point + " is now the point!");

                    do {
                        diceOne = (int) (Math.random() * 6 + 1);
                        diceTwo = (int) (Math.random() * 6 + 1);
                        sum = diceOne + diceTwo;

                        System.out.println("You rolled " + diceOne + " + " + diceTwo + " = " + sum);

                    } while (sum != point && sum != 7);
                    if (sum == 7) {
                        System.out.println("You Lose!");
                    } else
                        System.out.println("You win!");
            }

            do {
                System.out.print("Would you like to play again? (Y/N): ");
                userInput = sc.nextLine();
            } while (!userInput.equals("Y") && !userInput.equals("N"));

        } while (userInput.equals("Y"));

        sc.close();
    }
}
