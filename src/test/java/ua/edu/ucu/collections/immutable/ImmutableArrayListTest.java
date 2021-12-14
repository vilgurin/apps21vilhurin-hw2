package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.util.Arrays;

public class ImmutableArrayListTest extends TestCase {
    private ImmutableArrayList list;

    public void setUp() throws Exception {
        super.setUp();
        Object[] arr = {1,2,3,4,5,6,7,8,9};
        list = new ImmutableArrayList(arr);
    }

    public void testAdd() {
        ImmutableArrayList temp = (ImmutableArrayList) list.add(100);
        assertEquals(100,temp.get(temp.size()-1));


    }

    public void testTestAdd() {
        ImmutableArrayList temp = (ImmutableArrayList) list.add(4,100);
        assertEquals(100,temp.get(4));

    }

    public void testGet() {
        assertEquals(5,list.get(4));
    }

    public void testRemove() {
        ImmutableArrayList temp = (ImmutableArrayList) list.remove(5);
        assertEquals(7,temp.get(5));

    }

    public void testSet() {
        assertEquals(100,list.set(5,100).get(5));
    }

    public void testIndexOf() {
        assertEquals(2,list.indexOf(3));
    }

    public void testSize() {
        assertEquals(9,list.size());
    }

    public void testClear() {
        assertEquals(0,list.clear().size());
    }

    public void testIsEmpty() {
        assertEquals(0,list.clear().size());
    }

    public void testToArray() {
        Object[] arr = {1,2,3,4,5,6,7,8,9};
        assertEquals(Arrays.toString(arr),Arrays.toString(list.toArray()));
    }

}