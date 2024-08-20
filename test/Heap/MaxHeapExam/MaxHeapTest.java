package Heap.MaxHeapExam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class MaxHeapTest {
    @Test
    void example() {
        MaxHeap heap1 = new MaxHeap();
        MaxHeap heap2 = new MaxHeap();
        // Add items to heaps
        List.of(1, 2, 3, 4).forEach(heap1::add);
        List.of(5, 6, 7, 8).forEach(heap2::add);
        // Both heaps should now have 4 items
        assertEquals(4, heap1.size());
        assertEquals(4, heap2.size());
        heap1.mergeWith(heap2);
        // After merging, heap1 should have all 8 elements
        assertEquals(8, heap1.size());
        // heap2 should remain unchanged
        assertEquals(4, heap2.size());
        // Remove all elements from heap1
        List<Integer> actual = new ArrayList<>();
        while (heap1.size() > 0) {
            actual.add(heap1.poll());
        }
        // heap1 should return all elements in descending order
        assertEquals(List.of(8, 7, 6, 5, 4, 3, 2, 1), actual);
    }
}