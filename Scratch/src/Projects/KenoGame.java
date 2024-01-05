package Projects;

import java.util.Arrays;
import java.util.Scanner;

public class KenoGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to My Casino!");
        System.out.print("What is your name? ");
        String userName = sc.next();
        int userBalance = 100;
        System.out.print("How much would you like to bet? ");
        int userBet = sc.nextInt();

        while (userBet > 100 || userBet < 0) {
            System.out.print("That is an invalid input. How much would you like to bet? ");
            userBet = sc.nextInt();
        }

        System.out.println();

        int[] userNums = getUserNumbers();
        System.out.println();
        System.out.println("Your numbers are: " + Arrays.toString(userNums));

        int[] computerNums = getComputerNumbers();

        // COMPUTER DISPLAY AND DECIDE HOW MUCH MONEY THEY HAVE

        System.out.println("The computer's numbers are: " + Arrays.toString(computerNums));
        System.out.println();

        int matches = totalMatches(userNums, computerNums);
        if (matches < 4) {
            System.out.println("You have only matched " + matches + " numbers, so you don't win any money. ");
            userBalance -= userBet;
        } else if (matches == 4) {
            System.out.println("You have matched 4 numbers, so you win $ " + (userBet * 1));
            userBalance += (userBet * 1);
        } else if (matches == 5) {
            System.out.println("You have matched 5 numbers, so you win $ " + (userBet * 20));
            userBalance += (userBet * 20);
        } else if (matches == 6) {
            System.out.println("You have matched 6 numbers, so you win $ " + (userBet * 200));
            userBalance += (userBet * 200);
        } else if (matches == 7) {
            System.out.println("You have matched 7 numbers, so you win $ " + (userBet * 12000));
            userBalance += (userBet * 12000);
        }

        if (userBalance <= 0) {
            System.out.println("You lose, as you ran out of money.");
        }

        System.out.print(userName + ", you have $" + userBalance + ", would you like to play or quit?");
        String replay = sc.nextLine();

    }

    public static int[] getUserNumbers() {
        Scanner sc = new Scanner(System.in);
        int currentNum = 0;
        System.out.println("Please enter 7 unique numbers between 1 and 80.");
        int[] userNums = new int[7];
        for (int i = 0; i < userNums.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            currentNum = sc.nextInt();
            while (isUnique(userNums, currentNum) == false || (currentNum < 1) || (currentNum > 80)) {
                if ((currentNum < 1) || (currentNum > 80)) {
                    System.out.println(
                            "Sorry, that number is out of range. Please enter another number between 1 and 80.");
                } else
                    System.out.println("Sorry, you've already entered that number. Please choose another.");
                System.out.print("Enter number " + (i + 1) + ": ");
                currentNum = sc.nextInt();
            }
            userNums[i] = currentNum;
        }

        return userNums;

    }

    public static boolean isUnique(int[] ar, int target) {
        for (int j = 0; j < ar.length; j++) {
            if (target == ar[j]) {
                return false;

            }
        }
        return true;
    }

    public static int[] getComputerNumbers() {
        int[] computerNums = new int[20];

        for (int i = 0; i < computerNums.length; i++) {
            int possibleRandomNumber = (int) (Math.random() * 80) + 1;

            while (isUnique(computerNums, possibleRandomNumber) == false) {
                possibleRandomNumber = (int) (Math.random() * 80) + 1;
            }

            computerNums[i] = possibleRandomNumber;
        }

        return computerNums;
    }

    public static int totalMatches(int[] x, int[] y) {
        int matches = 0;

        for (int i = 0; i < x.length; i++) {
            for (int k = 0; k < y.length; k++) {
                if (x[i] == y[k]) {
                    matches++;
                }
            }
        }

        return matches;
    }

}
