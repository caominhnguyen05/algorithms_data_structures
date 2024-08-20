package Heap.MaxHeapExam;

import java.util.*;

public class MaxHeap extends AbstractMaxHeap {
    /**
     * Creates a new MaxHeap with an initial capacity of 4 elements.
     */
    public MaxHeap() {
        size = 0;
        arr = new int[4];
    }

    /**
     * Inserts the specified element into this heap.
     * If the heap is at full capacity, the capacity is doubled.
     *
     * @param elem The element to add.
     */
    public void add(int elem) {
        if (size == arr.length) {
            resize(arr.length*2);
        }
        arr[size] = elem;
        upHeap(size);
        size++;
    }

    /**
     * Restores the heap property in a heap represented as an array
     * by performing downheap on a certain item.
     * This method takes O(log n) time.
     * Ties may be broken arbitrarily.
     *
     * @param index Index of the item to perform downheap on.
     *              You can assume the index given is always valid.
     */
    void downHeap(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largestIndex = index;
        if (left < size && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }
        if (right < size && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }
        if (largestIndex == index) {
            return;
        }
        swap(index, largestIndex);
        downHeap(largestIndex);
    }

    /**
     * Merge another heap into this heap (add its elements to ours).
     * The current heap remains a valid max heap.
     * The new capacity of the current heap increases by the capacity of the other heap.
     * The other heap remains intact, i.e. its elements stay the same.
     * If the other heap is null, the method throws an IllegalArgumentException.
     * <p>
     * The other heap will always be an instance of MaxHeap.
     * <p>
     * Merging two heaps should take linear time in terms of the number of elements in both heaps combined, i.e.
     * it takes O(n + m) time for n = number of elements in current heap, m = number of elements in other heap.
     *
     * @param other Heap to merge into the current one.
     * @throws IllegalArgumentException if the other heap is null.
     */
    public void mergeWith(AbstractMaxHeap other) throws IllegalArgumentException {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        MaxHeap otherHeap = (MaxHeap) other;

        int oldSize = size;
        int newCapacity = arr.length + otherHeap.arr.length;
        resize(newCapacity);
        int otherIndex = 0;
        for (int i = oldSize; i < oldSize + otherHeap.size(); i++) {
            arr[i] = otherHeap.arr[otherIndex];
            otherIndex++;
        }
        this.size += otherHeap.size();
        heapify();
    }

    private void resize(int capacity) {
        int[] newArr = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public static void main(String[] args) {
        MaxHeap heap1 = new MaxHeap();
        MaxHeap heap2 = new MaxHeap();
        // Add items to heaps
        List.of(1, 2, 3, 4).forEach(heap1::add);
        List.of(5, 6, 7, 8).forEach(heap2::add);
        System.out.println(heap1.size());
        System.out.println(Arrays.toString(heap1.arr));
        heap1.mergeWith(heap2);
        System.out.println(heap1.size());
    }
}
