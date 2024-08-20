package Heap.HeapProperties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testNull() {
        assertFalse(Solution.isCompleteTree(null));
        assertFalse(Solution.hasHeapProperty(null));
    }

    @Test
    public void testOneLevelFull() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(84), new BinaryTree(21));
        assertTrue(Solution.isCompleteTree(tree));
    }

    @Test
    public void testOneLeftChild() {
        BinaryTree tree = new BinaryTree(42, new BinaryTree(21), null);
        assertTrue(Solution.isCompleteTree(tree));
    }

    @Test
    public void testOneRightChild() {
        BinaryTree tree = new BinaryTree(42, null, new BinaryTree(21));
        assertFalse(Solution.isCompleteTree(tree));
    }

    @Test
    public void isHeapSmall() {
        BinaryTree heap =
                new BinaryTree(
                        99,
                        new BinaryTree(64, new BinaryTree(36), new BinaryTree(8)),
                        new BinaryTree(5, new BinaryTree(1), null));
        assertTrue(Solution.hasHeapProperty(heap), "Valid heap returned false instead of true");
    }
}