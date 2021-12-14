package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Queue {
    private ImmutableLinkedList queue = new ImmutableLinkedList();
    public Object peek() {
        if (queue.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return queue.getHead().getValue();
    }

    public Object dequeue() {
        if (queue.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        Object first = queue.getFirst();
        queue = queue.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
