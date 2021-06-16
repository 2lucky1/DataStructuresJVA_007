package com.muntian.datastructures.list;

public class ArrayList implements List {
    public static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] array = new Object[DEFAULT_CAPACITY];

    public ArrayList() {

    }

    public ArrayList(int initialSize) {
        array = new Object[initialSize];
    }


    @Override
    public void add(Object value) {
        checkCapacityForIncreasing();
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        validateIndex(index);
        checkCapacityForIncreasing();
        size++;

        Object[] newArray = new Object[array.length];
        newArray[index] = value;
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index, newArray, index + 1, size - index);
        array = newArray;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        checkCapacityForDecreasing();
        size--;

        Object oldValue = get(index);

        if (size > 0) {
            Object[] newArray = new Object[array.length];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, size - index);
            array = newArray;
        } else {
            array[index] = null;
        }
        return oldValue;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        Object oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
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
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void validateIndex(int index) {
        if (0 > index || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    private void checkCapacityForIncreasing() {
        if (Integer.MAX_VALUE - size < 1) {
            throw new ArrayStoreException("You are trying to add more elements than an ArrayList can contain");
        }
        if (array.length != Integer.MAX_VALUE) {
            if (size + 1 > array.length) {
                if (Integer.MAX_VALUE - (size / 2 + 1) < size) {
                    correctInnerArrayCapacity(Integer.MAX_VALUE);
                } else {
                    int newCapacity = size + size / 2 + 1;
                    correctInnerArrayCapacity(newCapacity);
                }
            }
        }
    }

    private void checkCapacityForDecreasing() {
        if (Integer.MAX_VALUE - size > size) {
            if (array.length > size * 2 && size > DEFAULT_CAPACITY) {
                int newCapacity = size + size / 2 + 1;
                correctInnerArrayCapacity(newCapacity);
            }
        }
    }

    private void correctInnerArrayCapacity(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public int getLength() {
        return array.length;
    }

    public void trimToSize(){
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
