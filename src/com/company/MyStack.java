package com.company;

public class MyStack<T extends Comparable<T>> implements StackQueue<T> {
    MyArrayList<T> stack = new MyArrayList<>();
    int size = 0;

    @Override
    public void push(T data) {
        stack.add(data);
        size++;
    }

    public T peek(){
        return stack.get(size-1);
    }

    @Override
    public T pop(){
        T helper = stack.get(size-1);
        stack.remove(size-1);
        size--;
        return helper;
    }
}
