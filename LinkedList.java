package proj5;

/**
 *  Author: Nick DeBaise
 *  Date: 11/01/22
 *
 *  The LinkedList class is a standard LinkedList ADT that
 *  holds a head node that references a next node, and so on
 *
 *  HC: I affirm that I have carried out the Union College Honor Code
 */
public class LinkedList<T>
{
    private int length;
    private ListNode firstNode;

    public LinkedList()
    {
        length = 0;
        firstNode = null;
    }

    /**
     * Return whether the list is empty or not
     * @return true if the list is empty or false otherwise
     */
    public boolean isEmpty() { return getLength() == 0; }

    /**
     * Return the length of the list
     * @return length of the list
     */
    public int getLength() { return length; }


    /**
     * Remove the head of the list if available
     * @return true if it was removed, false otherwise
     */
    public boolean removeHead() {
        if(getHead() != null) {
            firstNode = firstNode.next;
            length--;
            return true;
        }
        return false;
    }


    /**
     * Remove the item at the given index
     * @param index the index of the item to remove
     * @return true if the item was removed, false otherwise (out of bounds/doesn't exist)
     */
    public boolean removeItem(int index) {
        if(index >= 0 && index < getLength()) {
            if(index == 0) {
                return removeHead();
            }

            ListNode runner = firstNode;

            for (int i = 0; runner != null && i < index - 1; i++) {
                runner = runner.next;
            }

            if(runner == null || runner.next == null) {
                return false;
            }

            ListNode next = runner.next.next;

            runner.next = next;
            length--;
        }

        return false;
    }


    /**
     * Given an index, return the node at the ith index
     * @param index the index of the node to find
     * @return the node at given index or null
     */
    public ListNode getNode(int index) {
        //if index is out of bounds, return null
        if(isEmpty() || index > getLength() - 1 || index < 0) {
            return null;
        }

        ListNode runner = firstNode;

        int i = 0;
        while(i < index && runner.next != null) {
            runner = runner.next;
            i++;
        }

        return runner == null ? null : new ListNode(runner.data);
    }

    /**
     * Return the head or first node
     *
     * @return the first node in the list
     */
    public ListNode getHead() {
        return firstNode == null ? null : new ListNode(firstNode.data);
    }

    /**
     * Given a data of type T, return the index of the item in the list or -1 if not found
     * @param data data to find
     * @return -1 if not found or index of first item if found
     */
    public int indexOf(T data) {
        ListNode runner = firstNode;
        int index = 0;
        while(runner != null) {
            if(runner.data.equals(data)) {
                return index;
            }
            runner = runner.next;
            index++;
        }

        return -1;
    }

    /**
     * Given an index and a data, insert a new node at the index
     * @param data the value to insert
     * @param index the position to insert
     */
    public void addAtIndex(T data, int index) {

        if(index > getLength()) {
            return;
        }

        if(isEmpty()) {
            firstNode = new ListNode(data);
        } else {
            ListNode runner = firstNode;

            if(index == 0) {
                addAtHead(data);
                return;
            }

            int i = 1;
            while(runner.next != null && i < index) {
                runner = runner.next;
                i++;
            }

            ListNode newNode = new ListNode(data, runner.next);

            runner.next = newNode;
        }

        length++;
    }

    /**
     * Given a data of type T, insert the new data as a node at the head
     * @param data the data to insert
     */
    public void addAtHead(T data)
    {
        ListNode newNode = new ListNode(data);
        if (!isEmpty()) {
            newNode.next = firstNode;
        }
        firstNode=newNode;
        length++;
    }

    /**
     * Insert a new node with data of type T at the end of the list
     * @param data the data to insert
     */
    public void add(T data) {
        addAtIndex(data, length);
    }


    /**
     * Stringified version of the list
     * @return string representing the list
     */
    public String toString(){
        String toReturn = "{>";
        ListNode runner = firstNode;
        while(runner != null){
            toReturn = toReturn + runner;
            runner = runner.next;
            if(runner != null){
                toReturn = toReturn + ", ";
            }
        }
        toReturn = toReturn + "}";
        return toReturn;
    }

    /**
     * Return the LinkedList as an array of Strings
     * @return
     */
    public String[] toArray() {
        String[] arr = new String[getLength()];

        for(int i = 0; i < getLength(); i++) {
            arr[i] = this.getNode(i).toString();
        }

        return arr;
    }

}


