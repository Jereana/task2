package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {

    private Object [] queue;
    private  int lastIndex = -1;
    private int size = 0;
    private int maxArraySize = 10;
        
    public QueueImpl() {
        queue = new Object[maxArraySize];
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
        return new IteratorImpl(queue);
    }

    private class IteratorImpl implements Iterator<Object> {

        private int currentPosition = 0;
        Object[] myQueue;

        public IteratorImpl(Object[] newQueue) {
            this.myQueue = newQueue;
        }

        @Override
        public boolean hasNext() {
            return (currentPosition <= lastIndex);
        }

        @Override
        public Object next() {
            if (currentPosition == size)
                throw new NoSuchElementException();

            currentPosition++;
            return myQueue[currentPosition - 1];
        }
    }

    @Override
    public void enqueue(Object element) {
         if (lastIndex == maxArraySize) {
            Object[] temp = new Object[maxArraySize + maxArraySize / 3];
            System.arraycopy(queue, 0, temp, 0, queue.length);
            queue = temp;
        }
        queue[++lastIndex] = element;
        size++;
    }

    @Override
    public Object dequeue() {
        if (size == 1) {
            clear();
        } else {
            if (size > 0) {
                Object first = queue[0];
                Object[] temp = new Object[size - 1];
                System.arraycopy(queue, 1, temp, 0, size - 1);
                queue = temp;
                lastIndex--;
                size--;
                return first;
            }
        }
        return null;
    }

    @Override
    public Object top() {
        if (size!=0){
            return queue[0];
        } else
            return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        String stringArray = "";
        for (int i = 0; i < size; i++){
            s.append(queue[i]).append(", ");
            stringArray = s.toString();
        }
        return "[" + (stringArray.substring(0, stringArray.length() - 2)) + "]";
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue(null);
    }

}
