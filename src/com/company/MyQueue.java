package com.company;

public class MyQueue<T extends Comparable<T>> implements StackQueue<T>{
    MyArrayList<T> queue = new MyArrayList<>();
    int size=0;

    @Override
    public T pop() {
        T helper = queue.get(0);
        queue.remove(0);
        size--;
        return helper;
    }

    @Override
    public void push(T data) {
        queue.add(data);
        size++;
    }

    @Override
    public T peek() {
        return queue.get(0);
    }
}
