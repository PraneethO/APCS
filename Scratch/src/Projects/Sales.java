package Projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.Scanner;

public class Sales {
    public static void main(String[] args) throws FileNotFoundException {
        salesCalculator("sales.txt", "output.txt");
    }

    public static void salesCalculator(String inFile, String outFile) throws FileNotFoundException {
        // go through the file

        // max variable

        // while there is a next line
        // read in the next line --> month
        // keep reading in while the next line is an int
        // keep a running total
        // if the next line isn't an int, continue with the loop

        Scanner fileScan = new Scanner(new File(inFile));
        PrintWriter pw = new PrintWriter(outFile);

        String currentMonth = "";
        double current = 0;

        String maxMonth = "";
        double max = 0;

        NumberFormat df = new DecimalFormat("$###,###.00");

        pw.println("Month               TotalSales\n");

        while (fileScan.hasNext()) {
            currentMonth = fileScan.next();

            while (fileScan.hasNextDouble()) {
                current += fileScan.nextDouble();
            }

            if (current > max) {
                max = current;
                maxMonth = currentMonth;
            }

            pw.print(currentMonth);
            for (int i = 0; i < (20 - currentMonth.length()); i++) {
                pw.print(" ");
            }
            pw.println(df.format(current));

            current = 0;
        }

        pw.println("\nMonth with the highest sales: " + maxMonth);

        pw.close();
    }
}
