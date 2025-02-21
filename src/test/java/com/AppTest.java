package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataStructureTests {
    private DoubleLinkedList<Integer> doubleLinkedList;
    private SingleLinkedList<Integer> singleLinkedList;
    private VectorStack<Integer> vectorStack;

    @BeforeEach
    void setUp() {
        doubleLinkedList = new DoubleLinkedList<>();
        singleLinkedList = new SingleLinkedList<>();
        vectorStack = new VectorStack<>();
    }

    @Test
    void testDoubleLinkedListPushAndPeek() {
        doubleLinkedList.push(10);
        doubleLinkedList.push(20);
        assertEquals(20, doubleLinkedList.peek());
    }

    @Test
    void testDoubleLinkedListPop() {
        doubleLinkedList.push(10);
        doubleLinkedList.push(20);
        assertEquals(20, doubleLinkedList.pop());
        assertEquals(10, doubleLinkedList.pop());
        assertNull(doubleLinkedList.peek());
    }

    @Test
    void testSingleLinkedListPushAndPeek() {
        singleLinkedList.push(5);
        singleLinkedList.push(15);
        assertEquals(15, singleLinkedList.peek());
    }

    @Test
    void testSingleLinkedListPop() {
        singleLinkedList.push(5);
        singleLinkedList.push(15);
        assertEquals(15, singleLinkedList.pop());
        assertEquals(5, singleLinkedList.pop());
        assertNull(singleLinkedList.peek());
    }

    @Test
    void testVectorStackPushAndPeek() {
        vectorStack.push(3);
        vectorStack.push(7);
        assertEquals(7, vectorStack.peek());
    }

    @Test
    void testVectorStackPop() {
        vectorStack.push(3);
        vectorStack.push(7);
        assertEquals(7, vectorStack.pop());
        assertEquals(3, vectorStack.pop());
        assertNull(vectorStack.peek());
    }

    @Test
    void testVectorStackSize() {
        assertEquals(0, vectorStack.size());
        vectorStack.push(1);
        vectorStack.push(2);
        assertEquals(2, vectorStack.size());
        vectorStack.pop();
        assertEquals(1, vectorStack.size());
    }
}
