package Projects.RPS;

public class Player implements Comparable<Player> {
    private String firstName;
    private String lastName;
    private int numWin;
    private int numLoss;
    private int cash;
    private int currentBet;
    private Weapon currentChoice;

    public Player() {
        firstName = "George";
        lastName = "Devol";
        numWin = 0;
        numLoss = 0;
        cash = 0;
        currentBet = 0;
        currentChoice = new Weapon();
    }

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        numWin = 0;
        numLoss = 0;
        cash = 0;
        currentBet = 0;
        currentChoice = new Weapon();
    }

    public void win() {
        cash += currentBet;
        numWin++;
    }

    public void lose() {
        cash -= currentBet;
        numLoss++;
    }

    public void setBet(int bet) throws InvalidBetAmount {
        if (bet > cash || bet < 0) {
            throw new InvalidBetAmount();
        }

        this.currentBet = bet;
    }

    public void setCash(int cash) throws InvalidCashAmount {
        if (cash <= 0) {
            throw new InvalidCashAmount();
        }

        this.cash = cash;
    }

    public void setWeapon() {
        currentChoice.setWeapon();
    }

    public void setWeapon(String choice) throws InvalidWeaponChoice {
        currentChoice.setWeapon(choice);
    }

    public Weapon getWeapon() {
        return currentChoice;
    }

    public int getCash() {
        return cash;
    }

    public String toString() {
        return "Player: " + firstName + " " + lastName + "\nCash Balance: " + cash + "\nWins: " + numWin + "\nLosses: "
                + numLoss;
    }

    public int compareTo(Player o) {
        // Makes sure divide by 0 doesn't happen
        if (this.numLoss == 0 || o.numLoss == 0 || this.numWin == 0 || this.numLoss == 0)
            return (this.numWin - this.numLoss) - (o.numWin - o.numLoss);

        // returns the integer difference in win percentage (percentage * 100) then
        // subtract
        return (int) (100 * (float) this.numWin / this.numLoss) - (int) (100 * (float) o.numWin / o.numLoss);
    }

    // precondition: Object entered is of type Player
    // returns a 1 if this player wins the round, -1 if the passed player wins the
    // round, and 0 if it is a tie
    public int checkOutcome(Player o) {
        if (currentChoice == o.currentChoice) {
            return 0;
        }

        String thisWeapon = currentChoice.getWeapon();
        String oWeapon = o.currentChoice.getWeapon();

        switch (thisWeapon) {
            case "rock":
                if (oWeapon == "scissors")
                    return 1;
                else
                    return -1;
            case "paper":
                if (oWeapon == "rock")
                    return 1;
                else
                    return -1;
            case "scissors":
                if (oWeapon == "paper")
                    return 1;
                else
                    return -1;
            default:
                return 2;
        }
    }

}
