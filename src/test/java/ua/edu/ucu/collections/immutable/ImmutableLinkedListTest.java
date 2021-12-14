package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ImmutableLinkedListTest extends TestCase {
    ImmutableLinkedList llist;

    public void setUp() throws Exception {
        super.setUp();
        Object[] arr = {1,2,3,4,5,6,7,8,9};
        llist = new ImmutableLinkedList(arr);
    }

    public void testAdd() {
        ImmutableLinkedList temp = (ImmutableLinkedList) llist.add(100);
        assertEquals(100,temp.getTail().getValue());
    }

    public void testTestAdd() {
        ImmutableLinkedList temp = (ImmutableLinkedList) llist.add(2,100);
        assertEquals(100,temp.get(2));
    }

    public void testAddAll() {
        Object[] arr = {5,6,7};
        ImmutableLinkedList temp = (ImmutableLinkedList) llist.addAll(arr);
        assertEquals(7,temp.getTail().getValue());
    }

    public void testTestAddAll() {
        Object[] arr = {5,6,7};
        ImmutableLinkedList temp = (ImmutableLinkedList) llist.addAll(3,arr);
        assertEquals(5,temp.get(3));

    }

    public void testGet() {
        assertEquals(1,llist.get(0));
    }

    public void testRemove() {
        ImmutableLinkedList temp = (ImmutableLinkedList) llist.remove(3);
        assertEquals(5,temp.get(3));
    }

    public void testSet() {
        ImmutableLinkedList temp = (ImmutableLinkedList) llist.set(3,3);
        assertEquals(3,temp.get(3));
    }

    public void testIndexOf() {
        assertEquals(4,llist.indexOf(5));
    }

    public void testSize() {
        assertEquals(9,llist.size());
    }

    public void testClear() {
        assertEquals(0,llist.clear().size());
    }

    public void testIsEmpty() {
        ImmutableLinkedList temp = new ImmutableLinkedList();
        assertEquals(0,temp.size());
    }

    public void testToArray() {
        Object[] arr = {1,2,3,4,5,6,7,8,9};
        assertEquals(Arrays.toString(arr),Arrays.toString(llist.toArray()));
    }

    public void testAddFirst() {
        ImmutableLinkedList temp = llist.addFirst(100);
        assertEquals(100,temp.getFirst());

    }

    public void testAddLast() {
        ImmutableLinkedList temp = llist.addLast(100);
        assertEquals(100,temp.getLast());
    }

    public void testGetHead() {
        assertEquals(1,llist.getHead().getValue());
    }

    public void testGetTail() {
        assertEquals(9,llist.getTail().getValue());
    }

    public void testGetFirst() {
        assertEquals(1,llist.getFirst());
    }

    public void testGetLast() {
        assertEquals(9,llist.getLast());
    }

    public void testRemoveFirst() {
        ImmutableLinkedList temp = llist.removeFirst();
        assertEquals(2,temp.get(0));
    }

    public void testRemoveLast() {
        ImmutableLinkedList temp = llist.removeLast();
        assertEquals(8,temp.getLast());
    }

}