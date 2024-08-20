package LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    public void testDoublyLinkedListConstructor() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals(0, list.size());
    }

    @Test
    public void testOneElement() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(42);
        assertEquals(42, list.getHead());
        assertEquals(42, list.getTail());
        assertEquals(1, list.size());
    }

    @Test
    public void testAddAtPosition() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(3);
        list.addLast(2);
        list.addAtPosition(1, 5);
        assertEquals(3, list.size());
        assertNull(list.removeFromPosition(10));
        assertEquals(3, list.size());
        assertEquals(3, list.removeFirst());
        assertEquals(5, list.removeFirst());
        assertEquals(2, list.removeFirst());
    }

}