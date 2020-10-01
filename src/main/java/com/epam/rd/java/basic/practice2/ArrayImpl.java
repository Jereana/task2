package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private Object[] array;
    private int lastIndex = 0;
    private int size;
   
    public ArrayImpl(int size) {
        this.size = size;
        array = new Object[size];
    }

    @Override
    public void clear() {
        Object [] arr =  new Object[0];
        this.array = arr;
        lastIndex = 0;
        size = 0;
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    public Iterator<Object> iterator() {

        return new IteratorImpl(array);
    }

    private class IteratorImpl implements Iterator<Object> {
        private int currentPosition = 0;
        Object[] arrayList;

        public IteratorImpl(Object[] newArray) {
            this.arrayList = newArray;
        }

        @Override
        public boolean hasNext() {
            return (currentPosition < lastIndex);
        }

        @Override
        public Object next() {
            if (currentPosition == lastIndex)
                throw new NoSuchElementException();

            currentPosition++;
            return arrayList[currentPosition - 1];
        }
    }

    @Override
    public void add(Object element) {
        if (lastIndex == size) {
            Object[] temp = new Object[size + size / 3];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
            size = array.length;
        }
        array[lastIndex] = element;
        lastIndex++;
    }

    @Override
    public void set(int index, Object element) {
        if (index < 0 || index>= lastIndex){
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index>= lastIndex){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < lastIndex; i++) {
                if (array[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < lastIndex; i++) {
                if ((array[i]!=null) && array[i].equals(element)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if ((index <= lastIndex - 1) && (index > 0)) {
            Object[] temp = new Object[lastIndex - 1];
            System.arraycopy(array,0, temp, 0, index);
            System.arraycopy(array, index+1, temp, index, lastIndex-index-1);
            array = temp;
            lastIndex--;
        } else
            throw new NoSuchElementException("There is no element with index " + index);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        String stringArray = "";
        for (int i = 0; i < lastIndex; i++){
            s.append(array[i]).append(", ");
            stringArray = s.toString();
        }
        return "[" + (stringArray.substring(0, stringArray.length() - 2)) + "]";
    }

    public static void main(String[] args) {
        ArrayImpl ar = new ArrayImpl(1);
        ar.add("A");
        ar.add("B");
        ar.add("C");
        ar.add("d");
        ar.add("E");
        ar.set(2,null);
    }

}
