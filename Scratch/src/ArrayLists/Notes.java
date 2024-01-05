package ArrayLists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
Example 1: write a method that fills an ArrayList from 
	data in a file
Example 2: print the elements in an ArrayList, one per line
Example 3: write a method with the following pre and post conditions and header:
Precondition: ArrayList list contains Integer values sorted in increasing order
Postcondition: value inserted in its correct position in list
public static void insert(ArrayList<Integer> list, Integer value)

Example 4: write a method that returns an ArrayList (of random size from 1-100) 
of random integers from -50 to 50
Example 5: write a method that swaps two values in list, indexed at i and j
Example 6: write a method that returns a list that contains all negatives in list a 

(assume that list contains Integer values)
Example 7: Write a method that returns the index of the maximum element in a list
Example 8: write a method that removes all elements from an ArrayList
 of type String that have the value of "and", "the", "a", "or", "an", "is", "are" 
*/
public class Notes {
    public static void main(String[] args) throws FileNotFoundException {
        // // types of declarations
        // ArrayList anything = new ArrayList(); // type Object
        // ArrayList<String> words = new ArrayList<String>();
        // ArrayList<Integer> nums = new ArrayList<>();

        // /*
        // * ArrayList Functions
        // * int size()
        // * boolean add(E obj)
        // * void add(int index, E obj)
        // * E get(int index)
        // * E set(int index, E obj)
        // * E remove(int index)
        // */

        // // tracing example 1
        // words.add("apple");
        // words.add("orange");
        // words.add(1, "banana");
        // words.remove(2);
        // words.add(0, "pomegranate");
        // words.set(1, "mango");

        // // pomegranate, mango, banana

        // // tracing example 2
        // nums.add(6); //
        // nums.add(100);
        // nums.add(42);
        // nums.add(2, 3);
        // nums.remove(1);
        // nums.set(1, -4);
        // nums.add(0, 4);
        // nums.set(nums.size() - 1, 7);
        // nums.add(nums.size() - 1, 0);
        // nums.add(nums.size(), 9);

        // // 4, 6, -4, 0, 7, 9

        // // potential OOD errors
        // // nums.add(nums.size()+1, 0)
        // // nums.set(nums.size(), 9)

    }

    public static ArrayList<Integer> getNumberList(String fileName) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File(fileName));
        ArrayList<Integer> numList = new ArrayList<Integer>();

        while (fileScan.hasNextInt())
            numList.add(fileScan.nextInt());

        return numList;
    }

    public static ArrayList<String> getWordList(String fileName) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File(fileName));
        ArrayList<String> wordList = new ArrayList<String>();

        while (fileScan.hasNext())
            wordList.add(fileScan.next());

        return wordList;
    }

    public static void printList(ArrayList input) {
        for (Object element : input) {
            System.out.println(element.toString());
        }
    }

    // Precondition: ArrayList list contains Comparable values sorted in increasing
    // order
    // Postcondition: value inserted in its correct position in list
    // public static void insert(ArrayList<Integer> list, Integer value)
    public static void insert(ArrayList list, Object value) {
        ArrayList<Comparable> compValues = (ArrayList<Comparable>) list;

        Comparable c = (Comparable) value;

        // iterate through list
        // if current list element is greater than c
        // insert c in list
        for (int i = 9; i < list.size(); i++) {
            if (compValues.get(i).compareTo(c) > 0) {
                list.add(i, value);
                return;
            }
        }

        // assertion: value must be larger than all list elements
        // value has not yet been added to list
        list.add(value);
    }

    public static ArrayList<Integer> getRands() {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < (int) (1 + (Math.random() * 100)); i++) {
            result.add((int) ((Math.random() * 101) - 50));
        }

        return result;
    }

    public static void swap(int i, int j, ArrayList<Object> input) {
        Object mid = input.get(i);

        input.set(i, input.get(j));

        input.set(j, mid);
    }

    public static ArrayList<Integer> allNegatives(ArrayList<Integer> input) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) < 0)
                result.add(input.get(i));
        }

        return result;
    }

    public static int getMax(ArrayList list) {
        ArrayList<Comparable> cList = (ArrayList<Comparable>) list;
        if (list.size() == 0) {
            return -1;
        }
        int maxIndex = 0;

        for (int i = 0; i < cList.size(); i++) {
            if (cList.get(i).compareTo(cList.get(maxIndex)) > 0)
                maxIndex = i;
        }

        return maxIndex;
    }

    public static boolean isSmallWord(String word) {
        word = word.toLowerCase();

        return word.equals("and") || word.equals("the") || word.equals("a") || word.equals("or") || word.equals("an")
                || word.equals("is") || word.equals("are") || word.equals("be");
    }

    public static void removeSmallWords(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            if (isSmallWord(words.get(i))) {
                words.remove(i);
                i--;
            }

        }
    }

}