package Sorting.Merge_Sort;

public class Solution {
    public static LibraryQueue<Lawyer> sortingSomeLawyer(LibraryQueue<Lawyer> queue) {
        if (queue == null || queue.size() <= 1) {
            return queue;
        }
        LibraryQueue<Lawyer> left = new LibraryQueue<>();
        LibraryQueue<Lawyer> right = new LibraryQueue<>();
        LibraryQueue<Lawyer> copy = copyQueue(queue);
        int size = queue.size();

        for (int i = 0; i < size/2; i++) {
            left.enqueue(copy.dequeue());
        }
        while (!copy.isEmpty()) {
            right.enqueue(copy.dequeue());
        }
        left = sortingSomeLawyer(left);
        right = sortingSomeLawyer(right);
        return merge(left, right);

    }

    private static LibraryQueue<Lawyer> merge(LibraryQueue<Lawyer> queue1, LibraryQueue<Lawyer> queue2) {
        LibraryQueue<Lawyer> result = new LibraryQueue<>();
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.front().getHourlyWage() > queue2.front().getHourlyWage()) {
                result.enqueue(queue1.dequeue());
            } else if (queue1.front().getHourlyWage() < queue2.front().getHourlyWage()) {
                result.enqueue(queue2.dequeue());
            } else {
                if (queue1.front().getTotalIncome() > queue2.front().getTotalIncome()) {
                    result.enqueue(queue1.dequeue());
                } else {
                    result.enqueue(queue2.dequeue());
                }
            }
        }
        while (!queue1.isEmpty()) {
            result.enqueue(queue1.dequeue());
        }
        while (!queue2.isEmpty()) {
            result.enqueue(queue2.dequeue());
        }
        return result;
    }

    private static LibraryQueue<Lawyer> copyQueue(LibraryQueue<Lawyer> queue) {
        LibraryQueue<Lawyer> copy = new LibraryQueue<>();
        LibraryQueue<Lawyer> copy2 = new LibraryQueue<>();
        while (!queue.isEmpty()) {
            Lawyer current = queue.dequeue();
            copy.enqueue(current);
            copy2.enqueue(current);
        }
        while (!copy2.isEmpty()) {
            queue.enqueue(copy2.dequeue());
        }
        return copy;
    }
}
