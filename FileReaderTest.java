package proj5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the FileReader
 */
public class FileReaderTest {

    @Test
    public void test_getWords() {
        FileReader fr = new FileReader("testInput.txt");

        assertEquals("{>AAA, BBB, CCC, #, DDD, EEE, AAA, AAA, CCC, BBB, #, AAA, BBB, CCC, #, AAA, BBB, CCC, #, BBB, #, AAA, #, BBB, CCC, DDD, #, CCC}", fr.getWords().toString());
    }

}
