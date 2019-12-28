package com.company.QueueFromLinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MyQueue<T> {

    private List<T> data = new LinkedList<>();
    public T dequeue() {
        T number = data.get(0);
        data.remove(0);
        return number;
    }

    public T peek() {
        return data.get(0);
    }

    public void enqueue(T nextInt) {
        data.add(nextInt);
    }

    Stack<Integer> stack = new Stack<>();
}
