package proj5;

/**
 * The Dictionary class represents a collection of words
 */
public class Dictionary {
    private BinarySearchTree<String> bst;

    /**
     * Default constructor
     */
    public Dictionary() {
        bst = new BinarySearchTree<String>();
    }

    /**
     * Add a word into the dictionary
     *
     * @param word the word to add
     */
    public void addWord(String word) {
        bst.insert(word);
    }

    /**
     * Check to see if dictionary contains word
     * @param word the target word
     * @return true if word is in dictionary, false otherwise
     */
    public boolean contains(String word) {
        return bst.search(word);
    }

    /**
     * Default toString
     * @return the stringified version of Dictionary
     */
    public String toString() {
        String[] list = bst.toArray();
        String ret = "";

        for(Object word : list) {
            ret += word.toString() + "\n";
        }

        return ret;
    }
}
