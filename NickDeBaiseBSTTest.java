package proj5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests a regular binary search tree by thoroughly testing each public function
 * for both edge cases and normal cases
 *
 * Author: Nick DeBaise
 * Version: 11/08/22
 * HC: I affirm I have carried out the Union College Honor Code
 */
public class NickDeBaiseBSTTest {

    @Test
    public void test_BST_constructor() {
        BinarySearchTree bst = new BinarySearchTree();

        assertEquals("", bst.toString());
    }

    @Test
    public void test_BST_insertString() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("Hello");

        assertEquals("(  Hello  )", bst.toString());
    }

    @Test
    public void test_BST_insertTwoStrings() {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();

        bst.insert("A");
        bst.insert("a");

        assertEquals("(  A  (  a  ))", bst.toString());
    }

    @Test
    public void test_BST_insertStringLeftRight() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("B");
        bst.insert("A");
        bst.insert("a");

        assertEquals("((  A  )  B  (  a  ))", bst.toString());
    }

    @Test
    public void test_BST_insertAllRight() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("D");
        bst.insert("C");
        bst.insert("B");
        bst.insert("A");

        assertEquals("((((  A  )  B  )  C  )  D  )", bst.toString());
    }

    @Test
    public void test_search_noItems() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        assertFalse(bst.search("Hello"));
    }

    @Test
    public void test_search_noItems_null() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        assertFalse(bst.search(null));
    }

    @Test
    public void test_search_ItemNotFound() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("Hello");

        assertFalse(bst.search("World"));
    }

    @Test
    public void test_search_ItemFound_root_and_leaf() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("A");
        bst.insert("B");

        assertTrue(bst.search("A"));
        assertTrue(bst.search("B"));
        assertFalse(bst.search("C"));
    }

    @Test
    public void test_search_ItemNotFound_multiple_leafs() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        bst.insert("a");
        bst.insert("b");
        bst.insert("c");

        assertFalse(bst.search("D"));
    }

    @Test
    public void test_search_ItemFound_multiple_leafs() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        bst.insert("a");
        bst.insert("b");
        bst.insert("c");

        assertTrue(bst.search("b"));
        assertTrue(bst.search("A"));
        assertTrue(bst.search("B"));
        assertTrue(bst.search("a"));
    }

    @Test
    public void test_toString_noItems() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        assertEquals("", bst.toString());
    }

    @Test
    public void test_toString_onlyRoot() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("item");

        assertEquals("(  item  )", bst.toString());
    }

    @Test
    public void test_toString_onlyRight() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("D");
        bst.insert("C");
        bst.insert("B");
        bst.insert("A");

        assertEquals("((((  A  )  B  )  C  )  D  )", bst.toString());
    }

    @Test
    public void test_toString_onlyLeft() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        bst.insert("D");

        assertEquals("(  A  (  B  (  C  (  D  ))))", bst.toString());
    }

    @Test
    public void test_toString_assortedTree() {
        BinarySearchTree bst = new BinarySearchTree<String>();

        bst.insert("B");
        bst.insert("C");
        bst.insert("A");
        bst.insert("D");

        assertEquals("((  A  )  B  (  C  (  D  )))", bst.toString());
    }

    @Test
    public void test_delete_noItems_Integer() {
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        bst.delete(Integer.valueOf(2));

        assertEquals("", bst.toString());
    }

    @Test
    public void test_delete_root_oneItem() {
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        bst.insert(Integer.valueOf(2));

        assertEquals("(  2  )", bst.toString());

        bst.delete(Integer.valueOf(2));

        assertEquals("", bst.toString());
    }

    @Test
    public void test_delete_root_multipleItems() {
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        bst.insert(Integer.valueOf(2));
        bst.insert(Integer.valueOf(3));
        bst.insert(Integer.valueOf(1));

        assertEquals("((  1  )  2  (  3  ))", bst.toString());

        bst.delete(Integer.valueOf(2));

        assertEquals("(  1  (  3  ))", bst.toString());
    }

    @Test
    public void test_delete_root_multipleItems_LeftRight() {
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        bst.insert(Integer.valueOf(4));
        bst.insert(Integer.valueOf(3));
        bst.insert(Integer.valueOf(1));
        bst.insert(Integer.valueOf(5));
        bst.insert(Integer.valueOf(6));

        assertEquals("(((  1  )  3  )  4  (  5  (  6  )))", bst.toString());

        bst.delete(Integer.valueOf(4));

        assertEquals("((  1  )  3  (  5  (  6  )))", bst.toString());
    }

    @Test
    public void test_delete_leaf() {
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        bst.insert(Integer.valueOf(2));
        bst.insert(Integer.valueOf(3));
        bst.insert(Integer.valueOf(1));

        assertEquals("((  1  )  2  (  3  ))", bst.toString());

        bst.delete(Integer.valueOf(3));

        assertEquals("((  1  )  2  )", bst.toString());
    }

    @Test
    public void test_delete_node_middle() {
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        bst.insert(Integer.valueOf(4));
        bst.insert(Integer.valueOf(3));
        bst.insert(Integer.valueOf(1));
        bst.insert(Integer.valueOf(2));
        bst.insert(Integer.valueOf(5));
        bst.insert(Integer.valueOf(6));

        assertEquals("(((  1  (  2  ))  3  )  4  (  5  (  6  )))", bst.toString());

        bst.delete(Integer.valueOf(1));

        assertEquals("(((  2  )  3  )  4  (  5  (  6  )))", bst.toString());
    }

    @Test
    public void test_delete_node_middle_with_children() {
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        bst.insert(Integer.valueOf(5));
        bst.insert(Integer.valueOf(2));
        bst.insert(Integer.valueOf(1));
        bst.insert(Integer.valueOf(3));
        bst.insert(Integer.valueOf(4));

        assertEquals("(((  1  )  2  (  3  (  4  )))  5  )", bst.toString());

        bst.delete(2);

        assertEquals("((  1  (  3  (  4  )))  5  )", bst.toString());
    }

    @Test
    public void test_delete_node_oneChild() {
        BinarySearchTree bst = new BinarySearchTree<Integer>();

        bst.insert(Integer.valueOf(5));
        bst.insert(Integer.valueOf(4));
        bst.insert(Integer.valueOf(3));
        bst.insert(Integer.valueOf(2));

        assertEquals("((((  2  )  3  )  4  )  5  )", bst.toString());

        bst.delete(3);

        assertEquals("(((  2  )  4  )  5  )", bst.toString());
    }

    @Test
    public void test_BST_insertAllRight_with_IndexEntry() {
        BinarySearchTree bst = new BinarySearchTree<IndexEntry>();

        bst.insert(new IndexEntry("D"));
        bst.insert(new IndexEntry("C"));
        bst.insert(new IndexEntry("B"));
        bst.insert(new IndexEntry("A"));

        assertEquals("((((  A {}  )  B {}  )  C {}  )  D {}  )", bst.toString());
    }
}
