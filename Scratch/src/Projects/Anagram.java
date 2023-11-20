package Projects;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("", ""));
    }

    // returns true if word1 and word2 are anagrams, false otherwise
    public static boolean isAnagram(String word1, String word2) {
        word1 = wordFormatter(word1);
        word2 = wordFormatter(word2);

        for (int i = 97; i <= 122; i++) {
            if (getOcurrences(word1, (char) i).length() != getOcurrences(word2, (char) i).length()) {
                return false;
            }
        }

        return true;
    }

    public static String getOcurrences(String word, char key) {
        String returnedWord = "";

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == key) {
                returnedWord += i + "";
            }
        }

        return returnedWord;
    }

    public static String wordFormatter(String word) {
        word = word.toLowerCase();
        String newWord = "";

        for (int i = 0; i < word.length(); i++) {
            if (122 >= (int) word.charAt(i) && (int) word.charAt(i) >= 97) {
                newWord += word.charAt(i);
            }
        }

        return newWord;
    }
}
