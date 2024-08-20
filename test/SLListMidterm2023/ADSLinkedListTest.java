package SLListMidterm2023;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ADSLinkedListTest {
    @Test
    void removeExample() {
        ADSLinkedList<Integer> l = createADSLinkedList(List.of(1, 2, 3, 4, 5, 6));
        l.remove();
        assertLinkedList(List.of(1, 3, 5), l);
    }

    @Test
    void remove2() {
        ADSLinkedList<Integer> l = createADSLinkedList(List.of(1, 2, 3, 4, 5, 6,7,8,9,10));
        l.remove();
        assertLinkedList(List.of(1,3,5,7,9), l);
    }

    @Test
    void reverseExample() {
        ADSLinkedList<Integer> l = createADSLinkedList(List.of(1, 2, 3, 4, 5, 6));
        l.reverse();
        assertLinkedList(List.of(6, 5, 4, 3, 2, 1), l);
    }

    @Test
    void packExample() {
        ADSLinkedList<Integer> l = createADSLinkedList(List.of(1, 2, 3, 4, 5, 6));
        l.pack();
        assertLinkedList(List.of(1, 3, 5, 2, 4, 6), l);
    }

    @Test
    void reverse2() {
        ADSLinkedList<Integer> l = createADSLinkedList(List.of(1, 2, 3, 4, 5, 6,7,8,9,10));
        l.reverse();
        assertLinkedList(List.of(10,9,8,7,6, 5, 4, 3, 2, 1), l);
    }

    private static <T> ADSLinkedList<T> createADSLinkedList(List<T> l) {
        ADSLinkedList<T> result = new ADSLinkedList<>();
        for (int i = 0; i < l.size(); i++) {
            result.head = new Node<>(l.get(l.size() - 1 - i), result.head);
        }
        return result;
    }

    private static <T> void assertLinkedList(List<T> expected, ADSLinkedList<T> actual) {
        ArrayList<Node<T>> nodeList = new ArrayList<>(expected.size());
        Node<T> walker = actual.head;
        while (walker != null) {
            assertFalse(nodeList.contains(walker), "The linked list most likely has a loop.");
            nodeList.add(walker);
            walker = walker.getNext();
        }
        List<T> actualList = nodeList.stream().map(Node::getElement).toList();
        assertEquals(expected, actualList);
    }

}