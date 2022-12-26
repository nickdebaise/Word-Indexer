package proj5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the IndexEntry
 */
public class IndexEntryTest {

    @Test
    public void test_constructor() {
        IndexEntry entry = new IndexEntry("Hello");

        assertEquals("Hello {}", entry.toString());
    }

    @Test
    public void test_addPageNum() {
        IndexEntry entry = new IndexEntry("Hello");

        entry.addPage(10);

        assertEquals("Hello {10}", entry.toString());
    }

    @Test
    public void test_addPageNums() {
        IndexEntry entry = new IndexEntry("Hello");

        entry.addPage(10);
        entry.addPage(56);
        entry.addPage(12);
        entry.addPage(14);

        assertEquals("Hello {10, 56, 12, 14}", entry.toString());
    }

    @Test
    public void test_addPageNums_overflow() {
        IndexEntry entry = new IndexEntry("Hello");

        entry.addPage(10);
        entry.addPage(56);
        entry.addPage(12);
        assertTrue(entry.addPage(14));

        assertEquals("Hello {10, 56, 12, 14}", entry.toString());

        assertFalse(entry.addPage(100));
        assertEquals("Hello {10, 56, 12, 14}", entry.toString());
    }

    @Test
    public void test_compareTo_equals() {
        IndexEntry entry1 = new IndexEntry("A");
        IndexEntry entry2 = new IndexEntry("A");

        assertTrue(entry1.compareTo(entry2) == 0);
        assertTrue(entry1.equals(entry2));
    }

    @Test
    public void test_compareTo_1GT2() {
        IndexEntry entry1 = new IndexEntry("B");
        IndexEntry entry2 = new IndexEntry("A");

        assertTrue(entry1.compareTo(entry2) > 0);
        assertFalse(entry1.equals(entry2));
    }

    @Test
    public void test_compareTo_1LT2() {
        IndexEntry entry1 = new IndexEntry("A");
        IndexEntry entry2 = new IndexEntry("B");

        assertTrue(entry1.compareTo(entry2) < 0);
        assertFalse(entry1.equals(entry2));
    }

    @Test
    public void test_getPages() {
        IndexEntry entry1 = new IndexEntry("B");

        entry1.addPage(3);
        entry1.addPage(10);

        assertEquals(2, entry1.getNumPages());
    }

    @Test
    public void test_getWord() {
        IndexEntry entry1 = new IndexEntry("Hey");

        entry1.addPage(3);

        assertEquals("Hey", entry1.getWord());
    }
}
