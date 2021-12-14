package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = Arrays.copyOf(elements,elements.length);
    }

    public ImmutableArrayList() {
        this.elements = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(elements.length,new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index,new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(elements.length,c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > elements.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Object[] arr = new Object[elements.length+c.length];

        for (int i = 0;i < elements.length+c.length;i++){
            if (i >= index && counter<c.length){
                arr[i] = c[counter];
                System.out.println(c[counter]);
                counter += 1;
            }
            else{
            arr[i] = elements[i-counter];
        }}
        return new ImmutableArrayList(arr);
    }

    @Override
    public Object get(int index) {
        if (index > elements.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index > elements.length || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Object[] arr = new Object[elements.length-1];
        for (int i = 1; i< elements.length;i++){
            if (i < index){
                arr[i-1] = elements[i-1];
            }
            else{
                arr[i-1] = elements[i];
            }
        }
        return new ImmutableArrayList(arr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index > elements.length || index <0){
            throw new IndexOutOfBoundsException();
        }
        Object[] arr = new Object[elements.length];
        for (int i =0;i < elements.length;i++){
            if (i != index){
                arr[i] = elements[i];
            }
            else{
                arr[i] = e;
            }        }

        return new ImmutableArrayList(arr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0 ;i < elements.length;i++){
            if (Objects.equals(elements[i],e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if (elements.length == 0){
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[elements.length];
        for (int i =0; i< elements.length;i++){
            arr[i] = elements[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        Object[] arr = {1,2,3,4,5};
        Object[] c = {100,200,300};
        ImmutableArrayList list = new ImmutableArrayList(arr);
        ImmutableArrayList newList = list;
        ImmutableArrayList n1 = (ImmutableArrayList) list.addAll(c);
        System.out.println(Arrays.toString(list.elements));
        System.out.println(Arrays.toString(n1.elements));
    }
}