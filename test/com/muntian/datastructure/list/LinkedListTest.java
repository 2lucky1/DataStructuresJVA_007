package com.muntian.datastructure.list;

import com.muntian.datastructures.list.LinkedList;
import com.muntian.datastructures.list.List;

public class LinkedListTest extends AbstractListTest {

    @Override
    List getList() {
        return new LinkedList();
    }
}