package Arrays;

/*
terms to know
array - a homogeneous (data is all of the same type) and contiguous (elements are stored sequentially)
	list with a defined length
base type - the data type being stored in an array
array element - a single data point in an array
length - the number of elements in the array
index/subscript - what you can use to identify a particular array element
	valid indexes range from 0 to length-1
ArrayIndexOutOfBoundsException - the run time error that occurs when a programmer tries to
	access an element that doesn't exist (via an invalid index)
for each loop (enhanced for loop).  Can be used if:
	1. you don't need to modify array elements (using =)
	2. you don't need to refer to the index of an element for any reason
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayNotes {
    public static void main(String[] args) throws FileNotFoundException {

    }

    // postcondition: ar is unchanged
    // returns the number of even numbers in ar
    public static int countEvents(int[] ar) {
        int count = 0;

        for (int i = 0; i < ar.length; i++) { // here, i refers to an INDEX
            if (ar[i] % 2 == 0)
                count++;
        }

        count = 0;

        for (int temp : ar) { // here, temp refers to an ARRAY ELEMENT
            if (temp % 2 == 0)
                count++;
        }

        return count;
    }

    // precondition: the text file fileName contains exactly n integers
    // postcondition: returns an int array that contains the numbers in fileName in
    // the same order
    public static int[] getArray(String fileName, int n) throws FileNotFoundException {
        int[] numbers = new int[n];
        Scanner fileScan = new Scanner(new File(fileName));

        for (int i = 0; i < n; i++)
            numbers[i] = fileScan.nextInt();

        fileScan.close();
        return numbers;
    }

    // precondition: arr.length > 0
    // returns the value of the minimum element in arr
    public static int findMinElement(int[] arr) {
        int min = arr[0];

        for (int temp : arr)
            if (temp < min)
                min = temp;

        return min;
    }

    // precondition: arr.length > 0
    // returns the index of the first ocurrence of the max elemeent in arr
    public static int findIndexOfMax(int[] arr) {
        int indexOfMax = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > indexOfMax) {
                indexOfMax = i;
            }
        }

        return indexOfMax;
    }

    public static void squareContents(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
    }

    // precondition: 0 <= i <= arr.length and 0 <= j < arr.length
    // postcondition: arr[i] and arr[j] have been swapped
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // postcondition: arr has not been changed.
    // returns the sum of the values in ar
    public static double getSum(double[] arr) {
        double counter = 0;
        for (double temp : arr) {
            counter += temp;
        }
        return counter;
    }

    public static int getSum(int[] arr) {
        int counter = 0;
        for (int temp : arr) {
            counter += temp;
        }
        return counter;
    }

    // postcondition: arr has not been changed.
    // returns the sum of the values in ar
    public static double getAverage(double[] arr) {
        double counter = 0;
        for (double temp : arr) {
            counter += temp;
        }
        return counter / arr.length;
    }

    public static int getAverage(int[] arr) {
        int counter = 0;
        for (int temp : arr) {
            counter += temp;
        }
        return counter / arr.length;
    }

    // postcondition: ar is unchanged
    // returns the index of the first occurrence of element in ar, -1 if DNE
    public static int indexOf(double[] ar, double element) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static double[] getDeepCopy(double[] ar) {
        double[] returnedList = new double[ar.length];

        for (int i = 0; i < ar.length; i++)
            returnedList[i] = ar[i];

        return returnedList;
    }

    // postcondition: ar is unchanged
    // returns an array that is the reverse of ar
    public static int[] getReverse(int[] ar) {
        int[] returnedList = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            returnedList[ar.length - i - 1] = ar[i];
        }

        return returnedList;
    }

    // postcondition: ar is unchanged
    // returns true if ar is in ascending order, false otherwise
    public static boolean isAscending(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1])
                return false;
        }
        return true;
    }

    // post: ar is unchanged
    // returns the range of the data in ar
    public static double getRange(double[] ar) {
        double min = ar[0];
        double max = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (min > ar[i])
                min = ar[i];
            if (max < ar[i])
                max = ar[i];
        }
        return max - min;
    }

    // post: ar is unchanged
    // returns the max difference between consecutive elements
    public static double getMaxJump(double[] ar) {
        double difference = 0;
        for (int i = 0; i < ar.length; i++) {
            if (Math.abs(ar[i + 1] - ar[i]) > difference) {
                difference = Math.abs(ar[i + 1] - ar[i]);
            }
        }

        return difference;
    }

}

/*
 * EXAMPLES
 * 1. write a function that returns an array filled with numbers from a file
 * 2: count the number of even numbers that exist in an array of type int
 * 3: public static int findMinElement(int[] arr)
 * 4: public static int findMinIndex(int[] arr)
 * 5: public static void squareContents(int[] arr)
 * 6: public static void swap(int[] arr, int i, int j)
 * 7: return the sum of an int array
 * 8. return the average of an int array
 * 9. find the index of the first occurrence of an element (return -1 if DNE)
 * 10. create a deep copy of an array
 * 11. reverse an array of type int
 * 12. print common elements between two arrays
 * 13. return true if an array is in ascending order, false otherwise
 * 14. return the difference between the largest and smallest values in an int
 * array
 */