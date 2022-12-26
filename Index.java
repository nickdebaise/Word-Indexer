package proj5;

/**
 * The index class represents an ADT that holds words associated with page numbers, similar to the
 * index in the back of a book
 */
public class Index {
    private BinarySearchTree<IndexEntry> bst;

    /**
     * Default constructor
     */
    public Index() {
        bst = new BinarySearchTree<IndexEntry>();
    }

    /**
     * Add a word into the tree.
     * If it already exists, update its page number. If too many pages, delete it.
     *
     * @return if it gets deleted from the index, return false, else return true
     */
    public boolean handleWord(String word, int pageNumber) {
        IndexEntry entry = new IndexEntry(word);

        if(bst.search(entry)) {
            //word exists -> update its page number
            IndexEntry node = bst.getNode(entry);
            boolean added = node.addPage(pageNumber);

            if(!added) {
                System.out.println("Deleting '" + node.toString() + "' from index");
                bst.delete(entry);
                return false;
            }
        } else {
            entry.addPage(pageNumber);
            bst.insert(entry);
        }

        return true;
    }

    /**
     * Default toString
     * @return the stringified version of the index
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
