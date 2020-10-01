package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private int size;
    Object [] stack;
    private  int lastIndex;
    private int maxSize = 10;

    public StackImpl(){
        stack = new Object[maxSize];
    }

    @Override
    public void clear() {
        lastIndex = -1;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl(stack);
    }

    private class IteratorImpl implements Iterator<Object> {

        private int currentPosition = size;
        Object[] myStack;

        public IteratorImpl(Object[] newStack) {
            this.myStack = newStack;
        }
        
        @Override
        public boolean hasNext() {
            return (currentPosition > 0);
        }

        @Override
        public Object next() {
            if (currentPosition < 0)
                throw new NoSuchElementException();

            currentPosition--;
            return myStack[currentPosition];
        }

    }

    @Override
    public void push(Object element) {
        stack[lastIndex++] = element;
        size++;
    }

    @Override
    public Object pop() {
        if (size != 0){
            size--;
            return stack[--lastIndex];
        } else
            return null;
    }

    @Override
    public Object top() {
        if (lastIndex >=0 ){
            return stack[lastIndex];
        } else
            return null;
    }

    @Override
    public String toString() {
        if (size > 0) {
            StringBuilder s = new StringBuilder("");
            String stringArray = "";
            for (int i = 0; i < size; i++) {
                s.append(stack[i]).append(", ");
                stringArray = s.toString();
            }
            return "[" + (stringArray.substring(0, stringArray.length() - 2)) + "]";
        } else
            return "";
    }

    public static void main(String[] args) {
         StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push(null);
    }

}
