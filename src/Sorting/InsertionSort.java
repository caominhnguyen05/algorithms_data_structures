package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,6,8,355,1,6777,90,24};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int elementToInsert = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > elementToInsert) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = elementToInsert;
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        for (int i = 1; i < names.length; i++) {
            int currentNum = heights[i];
            String currentName = names[i];
            int j = i;
            while (j > 0 && heights[j-1] < currentNum) {
                names[j] = names[j - 1];
                heights[j] = heights[j-1];
                j--;
            }
            heights[j] = currentNum;
            names[j] = currentName;
        }
        return names;
    }
}
