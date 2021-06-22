package com.muntian.datastructures.list;

import java.util.Iterator;

public class LinkedList implements List, Iterable {
    Node head;
    Node tail;

    private int size;

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        size++;
    }

    @Override
    public void add(Object value, int index) {
        validateIndexForAdd(index);
        Node newNode = new Node(value);

        if (index == 0) {
            newNode.prev = null;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
        } else {
            Node existingNode = getNodeByIndex(index);
            newNode.next = existingNode;
            newNode.prev = existingNode.prev;
            existingNode.prev = newNode;
            existingNode.prev.next = newNode;
        }
        size++;
    }


    @Override
    public Object remove(int index) {
        validateIndex(index);
        Node node = getNodeByIndex(index);
        Object removedObj = node.value;

        if (index == 0) {
            head = node.next;
            node.next.prev = null;
        } else if (index == size - 1) {
            tail = node.prev;
            node.prev.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return removedObj;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return getNodeByIndex(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        Node node = getNodeByIndex(index);
        Object oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        Node node = head;
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(value)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node node = tail;
        for (int i = size - 1; i >= 0; i++) {
            if (node.value.equals(value)) {
                return i;
            }
            node = node.prev;
        }
        return -1;
    }

    private Node getNodeByIndex(int index) {
        Node node;
        if (size / 2 >= index) {
            node = head;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    return node;
                }
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i >= index; i++) {
                if (i == index) {
                    return node;
                }
                node = node.prev;
            }
        }
        return null;
    }

    private void validateIndexForAdd(int index) {
        if (0 > index || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    private void validateIndex(int index) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator{
        Node currentNode;
        public LinkedListIterator(){
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Object next() {
            return currentNode;
        }

        @Override
        public void remove() {
        LinkedList.this.size--;
            if(currentNode.prev != null){
                if(currentNode.next != null){
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
            }
            currentNode = currentNode.next;
            //TODO
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list.toString());

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }

        System.out.println(list.toString());
    }
}
