package Arrays;

import java.util.Arrays;

public class ElementAppearKTimes {
    /**
     * Checks if every integer element in the array `a` appears at most `k` times.
     * This method should have a worst-case time complexity of O(n log n).
     * If the input array is null, return true.
     *
     * @param a - the array to search
     * @param k - the maximum number of times each unique element should appear in the array
     * @return true if each integer element appears at most 'k' times in 'a', false otherwise
     */
    public static boolean upperCount(int[] a, int k) {
        if (a == null) {
            return true;
        }
        LibraryPQ pq = new LibraryPQ();
        for (int i = 0; i < a.length; i++) {
            pq.insert(a[i]);
        }
        int index = 0;
        while (!pq.isEmpty()) {
            a[index] = pq.removeMax();
            index++;
        }

        int longestRun = 1;
        int duplicate = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i+1]) {
                duplicate++;
                if (duplicate > longestRun) {
                    longestRun = duplicate;
                }
            } else {
                duplicate = 1;
            }
        }
        return longestRun == k;
    }

    public static void main(String[] args) {
        int[] result = new int[]{2, 3, 1, 4, 5, 1, 7, 0};
        System.out.println(upperCount(result, 2));
        System.out.println(Arrays.toString(result));
    }
}
