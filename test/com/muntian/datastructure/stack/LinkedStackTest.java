package com.muntian.datastructure.stack;

import com.muntian.datastructures.stack.LinkedStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LinkedStackTest {
    @Test
    public void testPushAndPeek (){
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("A");
        assertEquals("A", linkedStack.pop());

        linkedStack.push("B");
        linkedStack.push("C");

        assertEquals(2, linkedStack.size());
        assertEquals("C", linkedStack.pop());

    }

    @Test
    public void testPushAndPop (){
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("A");
        assertEquals(1, linkedStack.size());
        assertEquals("A", linkedStack.pop());
        assertEquals(0, linkedStack.size());

        linkedStack.push("B");
        linkedStack.push("C");

        assertEquals(2, linkedStack.size());
        assertEquals("C", linkedStack.pop());
        assertEquals("B", linkedStack.pop());
        assertEquals(0, linkedStack.size());
    }

}
