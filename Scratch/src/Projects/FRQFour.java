package Projects;

public class FRQFour {
    public static void main(String[] args) {
    }

    // returns the length of longest streak of {letter} in {str}
    public static int longestStreak(String str, char letter) {
        int longestStreak = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter) {
                int counter = 0;
                int tempIndex = i;

                while (str.charAt(tempIndex) == letter) {
                    counter++;
                    tempIndex++;

                    if (tempIndex == str.length()) {
                        if (counter > longestStreak) {
                            return counter;
                        }
                        return longestStreak;
                    }
                }

                if (counter > longestStreak) {
                    longestStreak = counter;
                }
                i = tempIndex - 1;
            }
        }

        return longestStreak;
    }
}
