package Sorting.In_Place_Quick_Sort;

import java.util.Arrays;

public class Solution {
    public static void quickSort(int[] elements) {
        if (elements == null || elements.length <= 1) {
            return;
        }
        quickSortInPlace(elements, 0, elements.length - 1);
    }

    private static void quickSortInPlace(int[] elements, int a, int b) {
        if (a >= b) {
            return;
        }
        int left = a;
        int right = b - 1;
        int pivot = elements[b];

        while (left <= right) {
            while (left <= right && elements[left] < pivot) {
                left++;
            }
            while (left <= right && elements[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(elements, left, right);
                left++;
                right--;
            }
        }
        swap(elements, left, b);
        quickSortInPlace(elements, a, left - 1);
        quickSortInPlace(elements, left + 1, b);
    }

    private static void swap(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,8,34,1,3,577,4,3,5565};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
