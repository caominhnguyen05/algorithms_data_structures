package Heap.MaxHeapExam;
import java.util.*;
public abstract class AbstractMaxHeap {
    int[] arr;

    protected int size;

    // You need to implement these three methods in your solution
    public abstract void add(int elem);

    abstract void downHeap(int index);

    public abstract void mergeWith(AbstractMaxHeap other);

    // All methods below are available to use in your solution
    /**
     * Returns the number of elements in the heap.
     *
     * @return the current number of elements in the heap
     */
    public int size() {
        return this.size;
    }

    /**
     * Retrieves and removes the first element of this heap.
     *
     * @return The first element of the heap.
     */
    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot poll empty heap!");
        }
        int res = arr[0];
        swap(0, --size);
        arr[size] = 0;
        downHeap(0);
        return res;
    }

    @Override
    public String toString() {
        return "MaxHeap{" + "heap=" + Arrays.toString(arr) + '}';
    }

    /**
     * Turns the array of integers into a heap.
     * This is an in-place algorithm, the heap is built in the array itself.
     *
     * On return, this heap's array represents a valid heap.
     */
    protected void heapify() {
        int n = this.arr.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) downHeap(i);
    }

    /**
     * Restores the heap property in a heap represented as an array
     * by performing upheap on a certain item.
     *
     * @param index Index of the node to perform upheap on.
     */
    protected void upHeap(int index) {
        while (index >= 1) {
            int j = (index - 1) / 2;
            if (arr[j] >= arr[index]) break;
            swap(j, index);
            index = j;
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param i Position of element to swap.
     * @param j Position of element to swap.
     */
    protected void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
