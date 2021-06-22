package com.muntian.datastructures.queue;

import com.muntian.datastructures.stack.LinkedStack;
import com.muntian.datastructures.stack.Stack;

public class Dequeue implements Stack, Queue {
    Stack stack = new LinkedStack();

    @Override
    public void enqueue(Object value) {
        stack.push(value);
    }

    @Override
    public void enqueue(Queue queue) {
        stack.pushAll((Stack) queue);
    }

    @Override
    public Object dequeue() {
        return stack.pop();
    }

    @Override
    public int size() {
        return stack.size();
    }


    @Override
    public void push(Object value) {
        stack.push(value);
    }

    @Override
    public void pushAll(Stack stack) {
        stack.pushAll(stack);
    }

    @Override
    public Object pop() {
        return stack.pop();
    }

    @Override
    public boolean contains(Object value) {
        return stack.contains(value);
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue();
        dequeue.push("A");
        dequeue.push("B");
        dequeue.push("C");

        System.out.println(dequeue.toString());
    }
}
