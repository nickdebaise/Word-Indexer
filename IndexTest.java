package proj5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the Index
 */
public class IndexTest {

    @Test
    public void test_constructor() {
        Index index = new Index();

        assertEquals("", index.toString());
    }

    @Test
    public void test_handleWord_initialWord() {
        Index index = new Index();

        index.handleWord("Hello", 1);

        assertEquals("(  Hello {1}  )", index.toString());
    }

    @Test
    public void test_handleWord_initialWord_updateWord() {
        Index index = new Index();

        index.handleWord("Hello", 1);
        index.handleWord("Hello", 4);
        index.handleWord("Hello", 12);

        assertEquals("(  Hello {1, 4, 12}  )", index.toString());
    }

    @Test
    public void test_handleWord_initialWord_multipleWords() {
        Index index = new Index();

        index.handleWord("Hello", 1);
        index.handleWord("Hello", 4);
        index.handleWord("World", 7);
        index.handleWord("Hello", 12);
        index.handleWord("World", 19);

        assertEquals("(  Hello {1, 4, 12}  (  World {7, 19}  ))", index.toString());
    }

    @Test
    public void test_handleWord_delete_first_word() {
        Index index = new Index();

        index.handleWord("Hello", 1);
        index.handleWord("Hello", 4);
        index.handleWord("World", 7);
        index.handleWord("Hello", 12);
        index.handleWord("World", 19);
        index.handleWord("Hello", 21);
        index.handleWord("Hello", 23);


        assertEquals("(  World {7, 19}  )", index.toString());
    }

    @Test
    public void test_handleWord_delete_all_words() {
        Index index = new Index();

        index.handleWord("Hello", 1);
        index.handleWord("Hello", 4);
        index.handleWord("World", 7);
        index.handleWord("Hello", 12);
        index.handleWord("World", 19);
        index.handleWord("Hello", 21);
        index.handleWord("Hello", 23);
        index.handleWord("World", 24);
        index.handleWord("World", 25);
        index.handleWord("World", 26);



        assertEquals("", index.toString());
    }

    @Test
    public void test_handleWord_delete_last_inserted() {
        Index index = new Index();

        index.handleWord("Hello", 1);
        index.handleWord("Hello", 4);
        index.handleWord("World", 7);
        index.handleWord("Hello", 12);
        index.handleWord("World", 19);
        index.handleWord("World", 24);
        index.handleWord("World", 25);
        index.handleWord("World", 26);



        assertEquals("(  Hello {1, 4, 12}  )", index.toString());
    }

}
