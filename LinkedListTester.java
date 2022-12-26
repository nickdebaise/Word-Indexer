package proj5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  The test file to test the LinkedList ADT
 *  Author: Nick DeBaise
 *  Date: 10/19/2002
 *  Honor Code: I affirm that I have followed the Union College Honor Code.
 */

public class LinkedListTester {
    @Test
    public void testConstructor() {
        LinkedList ll = new LinkedList<String>();

        assertEquals(ll.getLength(), 0);
        assertEquals(ll.toString(), "{>}");
    }

    @Test
    public void testGetLength() {
        LinkedList ll = new LinkedList();

        assertEquals(ll.getLength(), 0);
        ll.add("Hello");
        assertEquals(ll.getLength(), 1);
    }

    @Test
    public void testInsert() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("World");

        assertEquals(ll.toString(), "{>Hello, World}");
    }

    @Test
    public void testInsertHead() {
        LinkedList ll = new LinkedList();

        ll.addAtHead("Hello");
        ll.addAtHead("World");

        assertEquals(ll.toString(), "{>World, Hello}");
    }

    @Test
    public void testInsertMultiple() {
        LinkedList ll = new LinkedList();

        ll.addAtHead("Hello");
        ll.add("World");
        ll.addAtHead("New head!");
        ll.add("Back of the list");

        assertEquals(ll.toString(), "{>New head!, Hello, World, Back of the list}");
    }

    @Test
    public void testToString() {
        LinkedList ll = new LinkedList();

        assertEquals(ll.toString(), "{>}");

        ll.add("Hey!");

        assertEquals(ll.toString(), "{>Hey!}");
    }

    @Test
    public void testFindStart() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("World");
        assertEquals(ll.indexOf("Hello"), 0);
    }

    @Test
    public void testFindEnd() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("World");
        assertEquals(ll.indexOf("World"), 1);
    }

    @Test
    public void testFindMiddle() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("Hey");
        ll.addAtHead("Head");
        ll.add("World");
        assertEquals(ll.indexOf("Hey"), 2);
    }

    @Test
    public void testFindNotFound() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("Hey");
        ll.addAtHead("Head");
        ll.add("World");
        assertEquals(ll.indexOf("NOT FOUND"), -1);
    }

    @Test
    public void testFindEmpty() {
        LinkedList ll = new LinkedList();
        assertEquals(ll.indexOf("NOT FOUND"), -1);
    }

    @Test
    public void testIsEmpty() {
        LinkedList ll = new LinkedList();

        assertEquals(ll.isEmpty(), true);
        ll.add("Hello");
        assertEquals(ll.isEmpty(), false);
    }

    @Test
    public void testHeadNode() {
        LinkedList ll = new LinkedList();

        assertEquals(ll.getHead(), null);

        ll.add("Hello");
        ll.addAtHead("World");

        assertEquals(ll.getHead().data, "World");
    }

    @Test
    public void testGetNode() {
        LinkedList ll = new LinkedList();


        ll.add("Hello");
        ll.addAtHead("World");

        assertEquals(ll.getNode(0).data, "World");
        assertEquals(ll.getNode(1).data, "Hello");

    }

    @Test
    public void testGetNodeOutOfBounds() {
        LinkedList ll = new LinkedList();


        ll.add("Hello");
        ll.addAtHead("World");

        assertEquals(ll.getNode(2), null);
        assertEquals(ll.getNode(-1), null);
    }

    @Test
    public void testGetNodeEmpty() {
        LinkedList ll = new LinkedList();

        assertEquals(ll.getNode(0), null);
    }

    @Test
    public void testInsertAtPositionMiddle() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("World");
        ll.add("3");
        ll.addAtIndex("Middle", 2);

        assertEquals(ll.toString(), "{>Hello, World, Middle, 3}");
        assertEquals(ll.getLength(), 4);

    }

    @Test
    public void testInsertAtPositionEnd() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("World");
        ll.add("3");
        ll.addAtIndex("Middle", 3);

        assertEquals(ll.toString(), "{>Hello, World, 3, Middle}");
        assertEquals(ll.getLength(), 4);

    }

    @Test
    public void testInsertAtPositionStart() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("World");
        ll.add("3");
        ll.addAtIndex("Start", 0);
        assertEquals(ll.toString(), "{>Start, Hello, World, 3}");
        assertEquals(ll.getLength(), 4);
        assertEquals(ll.getHead().data, "Start");

    }

    @Test
    public void testRemoveHead() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");

        assertTrue(ll.removeHead());
        assertFalse(ll.removeHead());
        assertEquals(ll.getLength(), 0);

        ll.add("Hello");
        ll.add("World");
        ll.add("End");
        ll.removeHead();
        assertEquals("{>World, End}", ll.toString());
        assertEquals(ll.getLength(), 2);
    }

    @Test
    public void testRemoveTail() {
        LinkedList ll = new LinkedList();


        ll.add("Hello");
        ll.add("World");
        ll.add("End");

        ll.removeItem(2);

        assertEquals("{>Hello, World}", ll.toString());
        assertEquals(ll.getLength(), 2);
    }

    @Test
    public void testRemoveMiddle() {
        LinkedList ll = new LinkedList();

        ll.add("Hello");
        ll.add("Hello 2");
        ll.add("World");
        ll.add("End");

        ll.removeItem(2);

        assertEquals("{>Hello, Hello 2, End}", ll.toString());
        assertEquals(ll.getLength(), 3);
    }
}
