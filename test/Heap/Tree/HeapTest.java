package Heap.Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    @Test
    public void testExampleRemove() {
        Heap heap = new Heap(2);
        heap.root.setLeft(new TreeNode(1));
        heap.size++;
        heap.root.setRight(new TreeNode(0));
        heap.size++;
        assertEquals(2, heap.removeMax());
        assertEquals(1, heap.removeMax());
    }

    @Test
    public void testExampleDownHeap() {
        Heap heap = new Heap(101);
        heap.root.setLeft(new TreeNode(42));
        heap.size++;
        heap.root.setRight((new TreeNode(24)));
        heap.size++;
        heap.root.setKey(7);
        assertEquals(7, heap.root.getKey());
        heap.downHeap(heap.root);
        assertEquals(42, heap.root.getKey());
    }
}