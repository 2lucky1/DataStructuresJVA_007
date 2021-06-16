package com.muntian.datastructures.stack;

public class LinkedStack implements Stack {
    Node last;
    int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(Object value) {
        Node newNode = new Node(value);

        if (size != 0) {
            newNode.prev = last;
        }

        last = newNode;
        size++;
    }

    @Override
    public void pushAll(Stack stack) {
        Stack reversed = new LinkedStack();

        for (int i = 0; i < stack.size(); i++) {
            reversed.push(stack.pop());
        }

        for (int i = 0; i < reversed.size(); i++) {
            push(reversed.pop());
        }
    }

    @Override
    public Object pop() {
        Object result = last.data;
        last = last.prev;
        size--;
        return result;
    }

    @Override
    public boolean contains(Object value) {
        Node currentNode = last;
        for (int i = 0; i < size; i++) {
            if (currentNode.data.equals(value)) {
                return true;
            }
            currentNode = currentNode.prev;
        }
        return false;
    }


}
