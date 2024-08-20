package QuickSelect;
import java.util.*;

public class Solution {
    public static Integer quickSelect(List<Integer> l, int k) {
        if (l == null || l.isEmpty()) {
            return null;
        }

        return quickSelect(l, 0, l.size() - 1, k - 1);
    }

    public static Integer quickSelect(List<Integer> l, int start, int end, int k) {
        if (start == end) {
            return l.get(start);
        }

        int pivotIndex = partition(l, start, end);
        int pivot = l.get(pivotIndex);

        if (pivotIndex == k) {
            return pivot;
        } else if (pivotIndex < k) {
            return quickSelect(l, pivotIndex + 1, end, k);
        } else {
            return quickSelect(l, start, pivotIndex - 1, k);
        }
    }

    private static int partition(List<Integer> l, int start, int end) {
        int pivotIndex = new Random().nextInt(start, end+1);
        swap(l, pivotIndex, end);
        pivotIndex = end;

        int pivot = l.get(pivotIndex);
        int left = start;
        int right = end - 1;

        while (left <= right) {
            while (left <= right && l.get(left) < pivot) {
                left++;
            }
            while (left <= right && l.get(right) > pivot) {
                right--;
            }
            if (left <= right) {
                swap(l, left, right);
                left++;
                right--;
            }
        }
        swap(l, left, pivotIndex);
        pivotIndex = left;
        return pivotIndex;
    }

    private static void swap(List<Integer> l, int i, int j) {
        int temp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 52, 42, 6, 123, 2, 1, 4, 44, 64));
        System.out.println(quickSelect(list, 7));
    }
}
