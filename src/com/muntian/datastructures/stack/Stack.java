package com.muntian.datastructures.stack;

public interface Stack {
    // return number of elements in stack
    int size();

    // add element into stack
    void push(Object value);

    // add all elements into stack
    void pushAll(Stack stack);

    // remove and return element from stack
    Object pop();

    // return true if value present in stack
    boolean contains(Object value);

    // [A, B, C]
    String toString();
}
