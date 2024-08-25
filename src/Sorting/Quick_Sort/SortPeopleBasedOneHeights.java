package Sorting.Quick_Sort;

public class SortPeopleBasedOneHeights {
    public String[] sortPeople(String[] names, int[] heights) {
        quickSort(names, heights, 0, names.length - 1);
        return names;
    }

    private static void quickSort(String[] names, int[] heights, int low, int high) {
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high - 1;
        int pivot = heights[high];
        while (left <= right) {
            while (left <= right && heights[left] >= pivot) {
                left++;
            }
            while (left <= right && heights[right] <= pivot) {
                right--;
            }
            if (left <= right) {
                swap(names, heights, left, right);
                left++;
                right--;
            }
        }
        swap(names, heights, left, high);
        quickSort(names, heights, low, left - 1);
        quickSort(names, heights, left + 1, high);
    }

    private static void swap(String[] names, int[] heights, int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;

        int temp2 = heights[i];
        heights[i] = heights[j];
        heights[j] = temp2;
    }


}
