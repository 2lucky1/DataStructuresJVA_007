package com.muntian.datastructure.list;

import com.muntian.datastructures.list.ArrayList;
import com.muntian.datastructures.list.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public  class ArrayListTest extends AbstractListTest {

    // code from parent

    @Override
    List getList() {
        return (List) new ArrayList();
    }

    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.getList();
    }

    @Test
    public void testListCreatedWithCustomCapacity() {
        ArrayList arrayList = new ArrayList(10);
        assertEquals(10, arrayList.getLength());
    }

    @Test
    public void testTrimToSize() {
        ArrayList arrayList = new ArrayList(10);
        assertEquals(10, arrayList.getLength());
        arrayList.add("A");
        arrayList.trimToSize();
        assertEquals(1, arrayList.getLength());
    }
}