package Merge_Sort;

import java.util.Arrays;

public class MergeSortInteger {
    /**
     * Sorts an array of integers in ascending order. This operation is not-in-place.
     *
     * @param arr the array of integers that needs to be sorted in ascending order.
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int size = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, size);
        int[] right = Arrays.copyOfRange(arr, size, arr.length);

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int first = 0;
        int second = 0;
        int res = 0;
        int[] result = new int[arr1.length + arr2.length];
        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] <= arr2[second]) {
                result[res++] = arr1[first++];
            } else {
                result[res++] = arr2[second++];
            }
        }
        while (first < arr1.length) {
            result[res++] = arr1[first++];
        }
        while (second < arr2.length) {
            result[res++] = arr2[second++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new int[]{5, 6, 2572, 7, 3, 9, 78, 54, 23, 643434, 0, 8, 6};
        System.out.println(Arrays.toString(mergeSort(result)));
    }
}
