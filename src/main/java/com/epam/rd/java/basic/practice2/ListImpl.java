package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    private int size = 0;
    private Node head;

    public ListImpl() {
        head = null;
    }

    private class Node {
        private Object data;
        private Node next;

        private Node(Object data) {
            this.data = data;
            this.next = null;
        }

        private Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int currentPosition = 0;
        Node element = head;

        @Override
        public boolean hasNext() {
            return (element != null);
        }

        @Override
        public Object next() {
            if (currentPosition == size)
                throw new NoSuchElementException();
            currentPosition++;
            Object currentData = element.data;
            element = element.next;
            return currentData;
        }

    }

    private Node getNode(int index) {
        if (size == 0) {
            return null;
        } else if (index >= 0 && index < size) {

            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        return null;
    }

    @Override
    public void addFirst(Object element) {
        head = new Node(element, head);
        size++;
    }

    @Override
    public void addLast(Object element) {
        if (size == 0) {
            addFirst(element);
        } else {
            Node node = getNode(size - 1);
            if(node != null){
                node.next = new Node(element);
                size++;
            }
        }
    }

    @Override
    public void removeFirst() {
        if (size > 0) {
            head = head.next;
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (size == 1) {
            removeFirst();
        } else if (size > 0) {
            Node node = getNode(size - 1);
            if (node != null){
                node.next = null;
                size--;
            }
        }
    }

    @Override
    public Object getFirst() {
        if (size == 0) {
            return null;
        }
        Node node = head;
        return node.data;
    }

    @Override
    public Object getLast() {
        if (size == 0) {
            return null;
        }
        Node node = head;
        for (int i = 0; i < size - 1; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public Object search(Object element) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if ((element != null) && (element.equals(node.data))){
                return node.data;
           } else {
                if (node.data == null) {
                    return node.data;
                }
            }
          node = node.next;
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        boolean result = true;
        Node node = head;
        Node previous = null;

        for (int i = 0; i < size; i++){
            if (((element != null) && element.equals(node.data)) || ((element == null) && (node.data == null))){
                if (i == 0) {
                    removeFirst();
                    return result;
                } else if (i == size - 1) {
                    removeLast();
                    return result;
                } else {
                    previous.next = node.next;
                    size--;
                    return result;
                }
            }
            previous = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        String stringList = "";
        Node node = head;
        for (int i = 0; i < size; i++) {
            s.append(node.data).append(", ");
            stringList = s.toString();
            node = node.next;
        }
        return "[" + (stringList.substring(0, stringList.length() - 2)) + "]";
    }

    public static void main(String[] args) {
        
        ListImpl list = new ListImpl();
        list.addFirst("B");
        list.addLast("C");
        list.addFirst("A");
        list.addLast(null);
        System.out.println(list.remove("A"));
        list.search(null);
    }
}
