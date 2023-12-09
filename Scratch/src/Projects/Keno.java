package Projects;

import java.util.Arrays;
import java.util.Scanner;

public class Keno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to George's Casino!");
        System.out.print("What is your name? ");
        String firstName = sc.nextLine();

        int total = 100;
        System.out.println("You have $100");

        while (true) {
            System.out.print("How much would you like to bet? ");
            int bet = sc.nextInt();
            sc.nextLine();

            while (bet > total || bet < 0) {
                System.out.println("Bet is too high or bet is negative.");
                System.out.print("How much would you like to bet? ");

                bet = sc.nextInt();
                sc.nextLine();
            }

            System.out.println("\n");
            System.out.println("Please enter 7 unique numbers between 1 and 80.");

            int[] userArray = new int[7];
            for (int i = 1; i < 8; i++) {
                System.out.print("Enter number " + i + ": ");
                int userInput = sc.nextInt();
                while ((userInput > 80 || userInput < 1) || (findInList(userArray, userInput) > -1)) {
                    if (userInput > 80 || userInput < 1)
                        System.out.println(
                                "Sorry, that number is outside of the range, please enter another number between 1 and 80");
                    else
                        System.out.println("Sorry, you’ve already entered that number. Please chose another.");

                    System.out.print("Enter number " + i + ": ");
                    userInput = sc.nextInt();
                    sc.nextLine();
                }

                userArray[i - 1] = userInput;
            }

            int[] computerArray = new int[20];
            makeRandomList(computerArray, 20);

            int ocurrences = numOcurrences(userArray, computerArray);

            System.out.println("The computer picks: " + Arrays.toString(computerArray));
            System.out.println("\n");

            switch (ocurrences) {
                case (4):
                    total += bet * 1;
                    System.out.println("You matched 4 numbers. you win $" + (bet * 1));
                    break;
                case (5):
                    total += bet * 20;
                    System.out.println("You matched 5 numbers. you win $" + (bet * 20));
                    break;
                case (6):
                    total += bet * 200;
                    System.out.println("You matched 6 numbers. you win $" + (bet * 200));
                    break;
                case (7):
                    total += bet * 12000;
                    System.out.println("You matched 7 numbers. you win $" + (bet * 12000));
                    break;
                default:
                    System.out.println("You've matched " + ocurrences + " time(s), which doesn't win anything.");
                    total -= bet;
                    break;
            }

            if (total <= 0) {
                System.out.println("You have run out of money. You suck.");
                break;
            }

            System.out.print(firstName + ", you have $" + total + ", would you like to play or quit? (play/quit) ");
            sc.nextLine();
            String answer = sc.nextLine();
            while (!answer.equals("quit") && !answer.equals("play")) {
                System.out.println("Invalid Input");
                System.out.print("Would you like to play or quit? (play/quit) ");
                answer = sc.nextLine();
            }

            if (answer.equals("quit")) {
                break;
            }
        }
        sc.close();
        System.out.println("Thanks for playing!");

    }

    public static int findInList(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static int numOcurrences(int[] arr, int[] arr2) {
        int ocurrences = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i] == arr2[j]) {
                    ocurrences++;
                }
            }
        }

        return ocurrences;
    }

    public static void makeRandomList(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 80) + 1;
            while (findInList(arr, arr[i]) == -1)
                arr[i] = (int) (Math.random() * 78) + 2;
        }
    }

}