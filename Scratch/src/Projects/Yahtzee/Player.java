package Projects.Yahtzee;

public class Player {
    private String name;
    private int[] categories = new int[13];
    int total;

    public Player(String name) {
        this.name = name;
        for (int i = 0; i < categories.length; i++) {
            categories[i] = -1;
        }
        total = 0;
    }

    public String getName() {
        return name;
    }

    public int[] getCategories() {
        return categories;
    }

    // category is the category starting at 1
    public int[] changeCategory(int[] arr, int category, int value) {
        arr[category - 1] = value;

        return arr;
    }

    public int getUpper() {
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            if (categories[i] > -1) {
                counter += categories[i];
            }
        }

        return counter;
    }

    public int getLower() {
        int counter = 0;
        for (int i = 6; i < 13; i++) {
            if (categories[i] > -1) {
                counter += categories[i];
            }
        }

        return counter;
    }
}
