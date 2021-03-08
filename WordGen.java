// Aidan Loten
// 3/6/2021
// Lab 3 - Infinite Monkey Theorem

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * WordGen
 *
 * This program reads in a text file and an int k and print out a string
 * for the user to see. It is supposed to imitate the style of the
 * input text.
 * k refers to the lenght of the sequences to add to the HashMaps of
 * the other classes.
 * @author Aidan Loten
 */
public class WordGen {

    /**
     * Read the contents of a file into a string. If the file does not
     * exist or cannot be read for any reason, returns null.
     * @param filename The name of the file to read.
     * @return The contents of the file as a string, or null.
     */
    private static String readFileAsString(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Driver of the program. Typical main function with relevant comments within.
     * @param args
     */
    public static void main(String[] args) {
        // Read in text filename
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file to read (without '.txt'): ");
        String filename = input.nextLine();

        // Read in input level k
        System.out.println("Enter desired value of k: ");
        int k = input.nextInt();

        // Get text file as string. Assuming that text file is in a folder "text-files" which
        // is in the same folder (src) as the Java classes
        String text = readFileAsString("src/text-files/" + filename + ".txt");


        // Declare/initialize a SequenceTable and populate with FrequencyMaps from input text
        // by looping over input text string
        SequenceTable sequenceTable = new SequenceTable(k);

        for (int i = 0; i < text.length() - k; i++) {
            String sequenceAndChar = "";

            for (int j = 0; j <= k; j++) {
                sequenceAndChar += text.charAt(i + j);
            }

            sequenceTable.addString(sequenceAndChar);
        }

//        // Print out SequenceTable object
//        System.out.println(sequenceTable.toString());

        // Generate text
        String newText = text.substring(0, k);

        for (int i = 0; i < 500 - k; i++) {
            String nextCharacter = "" + sequenceTable.getNextCharacter(text.substring(i, k + i));
            newText += nextCharacter;
        }

        // Print out new text
        System.out.println("\n\nNew Text: \n\n" + newText);

    } // end of main method

} // end of WordGen class
