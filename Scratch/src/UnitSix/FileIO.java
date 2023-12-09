package UnitSix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws FileNotFoundException {
        writeNeatly("messy.txt", "output.txt");
    }

    // precondition: each line in inFile contains exactly one comma
    // postcondition: data has been written neatly to outFile
    public static void writeNeatly(String inFile, String outFile) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File(inFile));
        PrintWriter pw = new PrintWriter(outFile);
        String line, part1, part2;
        int commaIndex;

        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            commaIndex = line.indexOf(",");
            part1 = line.substring(0, commaIndex);
            part2 = line.substring(commaIndex + 1);

            part1 = part1.trim();
            part2 = part2.trim();

            pw.println(part1 + ", " + part2);
        }

        pw.close();
    }
}
