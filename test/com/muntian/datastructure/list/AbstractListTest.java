package com.muntian.datastructure.list;

import com.muntian.datastructures.list.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractListTest {
    List listWithZeroElements;
    List listWithFiveElements;
    List listWithTenElements;

    @Before
    public void before() {
        listWithZeroElements = getList();

        listWithFiveElements = getList();
        for (int i = 0; i < 5; i++) {
            listWithFiveElements.add(i);

        }

        listWithTenElements = getList();
        for (int i = 0; i < 10; i++) {
            listWithTenElements.add(i);
        }
    }

    abstract List getList();

    @Test
    public void testSizeOnEmptyList() {
        assertEquals(0, listWithZeroElements.size());
    }

    @Test
    public void testSizeOnNonEmptyList() {
        assertEquals(5, listWithFiveElements.size());
    }

    @Test
    public void testAddByIndex() {
        listWithFiveElements.add(6, 1);
        assertEquals(6, listWithFiveElements.get(1));
        assertEquals(6, listWithFiveElements.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByInvalidIndex() {
        listWithFiveElements.add(12, 12);
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, listWithTenElements.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetByIndexLessThenZero() {
        listWithZeroElements.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetByIndexAfterSize() {
        listWithFiveElements.get(6);
    }

    @Test
    public void testClearList() {
        listWithFiveElements.clear();
        assertTrue(listWithFiveElements.isEmpty());
    }

    @Test
    public void testContains() {
        boolean actual = listWithTenElements.contains(5);
        assertTrue(actual);
    }

    @Test
    public void testIndexOf() {
        listWithTenElements.add(1, 2);
        int expected = 1;
        int actual = listWithTenElements.indexOf(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testLastIndexOf() {
        listWithTenElements.add(1, 2);
        int expected = 2;
        int actual = listWithTenElements.lastIndexOf(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSet() {
        int changedValue = (int) listWithFiveElements.set(7, 1);
        assertEquals(1, changedValue);
        assertEquals(7, listWithFiveElements.get(1));
    }

    @Test
    public void testRemove() {
        Object removedValue = listWithFiveElements.remove(3);
        assertEquals(3, removedValue);
        assertEquals(4, listWithFiveElements.get(3));
        assertEquals(4, listWithFiveElements.size());
    }

}
