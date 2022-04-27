package com.company;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private static class MyNode<T>{
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList(T data) {

        MyNode mynode = new MyNode(data);
    }

    public void add(T t) {
        MyNode<T> newNode = new MyNode<>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public boolean remove(T t) {
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else {
            MyNode<T> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            MyNode<T> current = previous.next;
            previous.next = current.next;
            length--;
            return current.data;
        }
    }


    @Override
    public void add(T t, int index) {
        MyNode<T> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        MyNode<T> temp = current.next;
        current.next = new MyNode<T>(t);
        (current.next).next = temp;
        length++;
    }


    @Override
    public void clear() {
        length = 0;
        head = tail = null;
    }

    public T get(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        }
        MyNode<T> temp = head;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.data;
    }


    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> current = head;
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(o))
                lastIndex = i;
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            if (current.data.equals(o))
                return i;
            current = current.next;
        }
        return 0;
    }

    @Override
    public void sort() {
        MyNode<T> current = head, index = null;
        T temp;
        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.data.equals(index.data)){
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<T> current = head;
        if (current.data.equals(o))
            return true;
        current = current.next;
        return false;
    }
}
