package Projects.RPS;

import java.util.Scanner;

public class RPSGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();

        Player user = new Player(firstName, lastName);
        Player computer = new Player();

        while (true) {
            try {
                System.out.print("Starting Cash for Both Players: ");
                int cash = sc.nextInt();
                sc.nextLine();

                user.setCash(cash);
                computer.setCash(cash);
                break;
            } catch (InvalidCashAmount e) {
                System.out.println("Invalid Cash Amount");
            }
        }

        int round = 1;

        while (true) {
            System.out.println("Round: " + round);

            while (true) {
                try {
                    System.out.print("Bet Amount: ");
                    int bet = sc.nextInt();
                    sc.nextLine();

                    user.setBet(bet);
                    computer.setBet(bet);
                    break;
                } catch (InvalidBetAmount e) {
                    System.out.println("Bet Too High or Negative");
                    continue;
                }
            }

            while (true) {
                try {
                    System.out.print("Weapon Choice (rock/paper/scissors): ");
                    String currentWeapon = sc.next();
                    sc.nextLine();

                    user.setWeapon(currentWeapon);
                    break;
                } catch (InvalidWeaponChoice e) {
                    System.out.println("Invalid Weapon Choice");
                    continue;
                }
            }

            computer.setWeapon();

            switch (user.checkOutcome(computer)) {
                case (1):
                    System.out.println("You Win!");
                    user.win();
                    computer.lose();
                    System.out.println("You now have " + user.getCash() + " dollars.");
                    System.out.println("The computer now has " + computer.getCash() + " dollars.");
                    break;
                case (-1):
                    System.out.println("You lose :(");
                    user.lose();
                    computer.win();
                    System.out.println("You now have " + user.getCash() + " dollars.");
                    System.out.println("The computer now has " + computer.getCash() + " dollars.");
                    break;
                case (0):
                    System.out.println("Tie");
                    System.out.println("You have " + user.getCash() + " dollars.");
                    System.out.println("The computer has " + computer.getCash() + " dollars.");
                    break;
            }

            if (computer.getCash() <= 0) {
                System.out.println("You have won the game! The computer has ran out of money.");
                break;
            } else if (user.getCash() <= 0) {
                System.out.println("You have ran out of money. You have officially lost.");
                break;
            }

            String answer;

            while (true) {
                System.out.print("Would you like to play again (Y/N)? ");
                answer = sc.next();

                if (answer.equals("N") || answer.equals("Y"))
                    break;
                else
                    System.out.println("Please enter Y or N");
            }

            if (answer.equals("N")) {
                System.out.println("Thanks for playing!");
                System.out.println(user);
                System.out.println(computer);
                break;
            }

            round++;
        }

        sc.close();

    }
}
