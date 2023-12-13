package Projects;

public class NumberCube {

    public int toss() {
        return (int) (6 * Math.random()) + 1;
    }

    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        int[] allTosses = new int[numTosses];
        for (int i = 0; i < numTosses; i++) {
            allTosses[i] = cube.toss();
        }
        return allTosses;
    }

    public static int getLongestRun(int[] values) {
        int index = 0;
        int longest = 0;
        int current = 0;
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                current++;
            } else {
                if (current > longest) {
                    longest = current;
                    index = i - current;
                }
                current = 0;
            }
        }
        return index;
    }
}
