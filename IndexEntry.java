package proj5;

import java.util.StringJoiner;

/**
 * The IndexEntry models an entry into the index which contains a word and a page list
 */
public class IndexEntry implements Comparable<IndexEntry> {
    private String word; // the word in the index
    private int[] pages; //the pages that are associated with the word -> -1 meaning no page
    private int numPages; //represents the current number of pages in the list

    private final static int MAX_PAGES = 4;

    /**
     * Default constructor
     * @param word
     */
    public IndexEntry(String word) {
        this.word = word;
        pages = new int[MAX_PAGES];
        numPages = 0;

        for(int i = 0; i < pages.length; i++) {
            pages[i] = -1;
        }
    }
    /**
     * Add a page to the page numbers for the word
     *
     * @param page the page number to add
     * @return true if the page was added, false if this was the fifth entry (not added)
     */
    public boolean addPage(int page) {
        if(numPages == MAX_PAGES) {
            return false;
        } else {
            if(!this.containsPage(page)) {
                pages[numPages] = page;
                numPages++;
            }

            return true;
        }
    }

    /**
     * Given a page, see if it is already in the page list
     *
     * @param page the page to see if it is in page list
     * @return true if in page list, false otherwise
     */
    public boolean containsPage(int page) {
        for(int p : pages) {
            if(p == page) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get a copy of the word
     * @return a copy of the word in the index entry
     */
    public String getWord() {
        return new String(this.word);
    }

    /**
     * Get the number of pages in the page list
     * @return int representing # of pages
     */
    public int getNumPages() {
        return this.numPages;
    }

    /**
     * Compare one index entry to another
     * @param o the other object to compare
     * @return value less than 0 if this is less than o, 0 if equal, greater than 0 if this is greater than o
     */
    @Override
    public int compareTo(IndexEntry o) {
        return this.word.compareTo(o.word);
    }

    /**
     * default toString
     * @return a stringified version of an index entry
     */
    @Override
    public String toString() {

        StringJoiner s = new StringJoiner(", ");

        for(int i = 0; i < numPages; i++) {
            s.add(String.valueOf(pages[i]));
        }

        return this.word + " {" + s + "}";
    }

    /**
     * Compare two entries for equality
     * @param o the other entry to compare
     * @return true of this and other are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IndexEntry)) {
            return false;
        }

        return this.word.compareTo(((IndexEntry) o).word) == 0;
    }
}
