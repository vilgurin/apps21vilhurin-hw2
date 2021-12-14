package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int length;
    public ImmutableLinkedList(Object[] elements) {
        if (elements.length == 0){
            new ImmutableLinkedList();
        }
        else {
            this.head = new Node();
            this.head.setValue(elements[0]);
            this.head.setNext(null);
            this.length = elements.length;
            Node current = this.head;
            for (int i = 1; i < elements.length; i++) {
                Node temp = new Node();
                temp.setValue(elements[i]);
                temp.setPrevious(current);
                temp.setNext(null);
                current.setNext(temp);
                current = temp;
            }
            this.tail = current;
        }
    }

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public ImmutableList add(Object e) {

        return addAll(this.length,new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {

        return addAll(index,new Object[]{e});
    }
    @Override
    public ImmutableList addAll(Object[] c) {

        return addAll(this.length,c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Node current = this.head;
        Object[] arr = new Object[this.length+c.length];

        int counter = 0;
        for (int i =0;i<this.length+c.length;i++){
            if (i >= index && counter<c.length){
                arr[i] = c[counter];
                counter += 1;
            }
            else{
                arr[i] = current.getValue();
                current = current.getNext();
            }
        }

        return new ImmutableLinkedList(arr);
    }

    @Override
    public Object get(int index) {
        if (index > this.length || index <0){
            throw new IndexOutOfBoundsException();
        }
        Node current = this.head;
        for (int i = 0; i<= index;i++){
            if (i == index){
                return current.getValue();
            }
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index > this.length || index <0){
            throw new IndexOutOfBoundsException();
        }
        Node current = this.head;
        Object[] arr = new Object[this.length-1];

        for (int i = 0; i <this.length-1; i++){
            if (i == index){
                current = current.getNext();
            }
            arr[i] = current.getValue();
            current = current.getNext();

        }
        return new ImmutableLinkedList(arr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index > this.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        Object[] arr = new Object[this.length];
        for (int i =0; i<this.length;i++){
            if (index == i){
                arr[i] = e;
                current = current.getNext();
            }
            else{
            arr[i] = current.getValue();
            current = current.getNext();
        }}
        return new ImmutableLinkedList(arr);
    }

    @Override
    public int indexOf(Object e) {
        Node current = this.head;
        for (int i =0;i<this.length;i++){
            if (current.getValue() == e){
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (this.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.length];
        Node current = this.head;
        for (int i =0;i<this.length;i++){
            arr[i] = current.getValue();
            current = current.getNext();
        }
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0,new Object[]{e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) addAll(this.length,new Object[]{e});
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return head.getValue();
    }


    public Object getLast() {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (ImmutableLinkedList) remove(this.length-1);
    }

    public static void main(String[] args) {
        Object[] arr = {1,2,3};
        ImmutableLinkedList llist = new ImmutableLinkedList(arr);
        ImmutableLinkedList new_list = (ImmutableLinkedList) llist.addAll(arr);
        System.out.println(llist.getHead());
        Node current = new_list.head;
        for (int i = 0; i<new_list.length;i++){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}


