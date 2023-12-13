package Projects.Yahtzee;

public class Dice {
    private int roll;
    private boolean confirmed;

    public Dice() {
        rollDice();
        confirmed = false;
    }

    public int getRoll() {
        return roll;
    }

    public boolean getConfirmed() {
        return confirmed;
    }

    public void rollDice() {
        roll = ((int) (Math.random() * 6)) + 1;
    }

    public void confirm() {
        confirmed = true;
    }
}
