
public class ChipotleEntree {
    boolean type; // bowl or burrito
    String toppings;
    int calories;

    // Constructors
    public ChipotleEntree(boolean type, String toppings) {
        this.type = type;
        this.toppings = toppings;
    }

    public ChipotleEntree(boolean type) {
        this.type = type;
    }

    // Accessor Functions

    public int getCalories() {
        return calories;
    }

    public String getToppings() {
        return toppings;
    }

    // Mutator Functions
    public void addToppings(String additionalToppings) {
        toppings += ", " + additionalToppings;
        calories += 1000; // Each chipotle topping is 1000 calories
    }

    public void lieAboutCalories() {
        calories = 1000; // Changes the number of calories ot the entree to lie to prospective consumers
    }

    public String toString() {
        return type ? "This burrito has " + calories + " calories and has these toppings: " + toppings
                : "This bowl " + calories + " calories and has these toppings: " + toppings;
    }

    // Fun Function
    public void randOrder() {
        switch ((int) Math.random() * 2) {
            case 0:
                type = false;
            case 1:
                type = true;
        }

        String possibleToppings = "chicken steak peppers lettuce black pinto salsa sour cheese";

        for (int i = 0; i < Math.random() * 10; i++) {
            for (int j = 0; j < Math.random() * 10; j++) {
                this.toppings = "";
                int counter = 0;
                for (int k = 0; k < possibleToppings.length(); k++) {
                    if (possibleToppings.charAt(i) == ' ') {
                        counter += 1;
                    }
                    if (counter == k) {
                        int l = k;
                        String result = "";
                        while (possibleToppings.charAt(l) != ' ') {
                            result += possibleToppings.charAt(l);
                            l++;
                        }
                        this.toppings += result;
                    }
                }
            }
        }
    }

}
