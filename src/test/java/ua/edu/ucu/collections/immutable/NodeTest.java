package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class NodeTest extends TestCase {
    Node head;
    Node tail;

    public void setUp() throws Exception {
        super.setUp();
        head = new Node();
        tail = new Node();
        head.setValue(1);
        tail.setValue(2);
        head.setNext(tail);
        tail.setPrevious(head);

    }

    public void testTestToString() {
        assertEquals("1", head.toString());
    }

    public void testGetPrevious() {
        assertEquals(head, tail.getPrevious());
    }

    public void testGetNext() {
        assertEquals(tail, head.getNext());
    }

    public void testGetValue() {
        assertEquals(1, head.getValue());
    }

}