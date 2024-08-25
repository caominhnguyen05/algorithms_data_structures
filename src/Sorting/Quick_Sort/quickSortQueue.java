package Sorting.Quick_Sort;

import java.util.LinkedList;
import java.util.Queue;

public class quickSortQueue {
    public static Queue<Integer> quickSort(Queue<Integer> queue) {
        if (queue == null || queue.size() <= 1) {
            return queue;
        }

        int pivot = queue.peek();

        Queue<Integer> smaller = new LinkedList<>();
        Queue<Integer> equal = new LinkedList<>();
        Queue<Integer> larger = new LinkedList<>();
        while (!queue.isEmpty()) {
            if (queue.peek() < pivot) {
                smaller.add(queue.poll());
            } else if (queue.peek() == pivot) {
                equal.add(queue.poll());
            } else {
                larger.add(queue.poll());
            }
        }
        smaller = quickSort(smaller);
        larger = quickSort(larger);
        while (!smaller.isEmpty()) {
            queue.add(smaller.poll());
        }
        while (!equal.isEmpty()) {
            queue.add(equal.poll());
        }
        while (!larger.isEmpty()) {
            queue.add(larger.poll());
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> res = new LinkedList<>();
        res.add(4);
        res.add(985959);
        res.add(9);
        res.add(2);
        res.add(10);
        res.add(5);
        res.add(8484);
        quickSort(res);
        System.out.println(res);
    }
}
