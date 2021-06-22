package com.muntian.datastructures.queue;

public interface Queue {
    // return number of elements in stack
    int size();

    // add element into stack
    void enqueue(Object value);

    // add all elements into stack
    void enqueue(Queue queue);

    // remove and return element from stack
    Object dequeue();

    // return true if value present in stack
    boolean contains(Object value);

    // [A, B, C]
    String toString();
}
