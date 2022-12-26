package proj5;


import java.util.StringJoiner;

/**
 * Driver for the index maker project
 *
 * Creates the index and dictionary for a given input file
 * 
 * @author Nick DeBaise
 * @version 11/14/22
 *
 * HC: I affirm I have carried out the Union College Honor Code
 */
public class Client
{
    public static void main(String[] args)
    {
        makeIndex("GSTestInput.txt");
    }

    /**
     * Makes an index out of fileName. Gradescope needs this function.
     * 
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {
    	FileReader reader = new FileReader(fileName);
        LinkedList<String> words = reader.getWords();

        Index index = new Index();
        Dictionary dictionary = new Dictionary();


        int currPageNum = 1;
        int currIndex = 0;

        while(words.getNode(currIndex) != null) {
            ListNode word = words.getNode(currIndex++);
            String w = (String) word.data;

            if(w.equals("#")) {
                currPageNum++;
                continue;
            }

            if(w.length() <= 2) {
                continue;
            }

            if(!dictionary.contains(w)) {
                boolean wordWasAdded = index.handleWord(w, currPageNum);

                if(!wordWasAdded) {
                    dictionary.addWord(w);
                }
            }
        }

        printIndex(index);
        printDictionary(dictionary);
    }

    private static void printIndex(Index index) {
        String s = index.toString().replaceAll(" ", "").trim();
        System.out.println(s);
    }

    private static void printDictionary(Dictionary dict) {
        String s = dict.toString().replaceAll(" ", "").trim();
        System.out.println(s);
    }
}
