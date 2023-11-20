package Projects.RPS;

public class Weapon {
    private String type;

    // Constructors
    public Weapon() {
        switch ((int) (Math.random() * 3) + 1) {
            case (1):
                type = "rock";
            case (2):
                type = "paper";
            default:
                type = "scissors";
        }
    }

    // precondition: type is "Rock", "Paper", or "Scissor"
    // postcondition: this.type is set to type
    public Weapon(String type) throws InvalidWeaponChoice {
        if (type != "rock" && type != "paper" && type != "scissors")
            throw new InvalidWeaponChoice();
        this.type = type;
    }

    // returns the type instance variable
    public String getWeapon() {
        return type;
    }

    // postcondition: this.type is set to a random weapon
    public void setWeapon() {
        switch ((int) (Math.random() * 3) + 1) {
            case (1):
                type = "rock";
            case (2):
                type = "paper";
            default:
                type = "scissors";
        }
    }

    // precondition: type is a legitimate weapon string
    // postcondition: this.type is set to type
    public void setWeapon(String type) throws InvalidWeaponChoice {
        if (!type.equals("rock") && !type.equals("scissors") && !type.equals("paper"))
            throw new InvalidWeaponChoice();
        this.type = type;
    }

    // returns a String representing the object
    public String toString() {
        return type;
    }
}
