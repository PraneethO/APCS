package Projects.RandomFRQs;

import java.util.ArrayList;

public class AP19_3 {
    private String openDel;
    private String closeDel;

    public static void main(String[] args) {

    }

    public ArrayList<String> getDelimiterList(String[] tokens) {
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(openDel) || tokens[i].equals(closeDel)) {
                result.add(tokens[i]);
            }
        }

        return result;
    }

    public boolean isBalanced(ArrayList<String> delimiters) {
        int numOpen = 0;
        int numClosed = 0;
        for (int i = 0; i < delimiters.size(); i++) {
            if (delimiters.get(i).equals(openDel))
                numOpen++;
            else
                numClosed++;

            if (numClosed > numOpen)
                return false;
        }
        if (numOpen != numClosed)
            return false;
        return true;
    }
}