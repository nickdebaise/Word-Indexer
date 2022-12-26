package proj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Class to handle reading a given input file
 */
public class FileReader {

    private Scanner myReader;

    /**
     * Initializes the class with the given file.
     * @param filename
     */
    public FileReader(String filename) {
        try {
            myReader = new Scanner(new File(filename));
            myReader.useDelimiter("[^a-zA-Z#]+");
        } catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
    }

    /**
     * Reads and returns all the words in the file as a linked list of Strings
     */
    public LinkedList<String> getWords() {
        LinkedList<String> list = new LinkedList<>();
        while (myReader.hasNext()) {
            String nextExpression = myReader.next();
            list.add(nextExpression);
        }

        return list;
    }


}
