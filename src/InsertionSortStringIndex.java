import java.util.Arrays;

public class InsertionSortStringIndex {
    /**
     * Sorts the indices of the array based on the corresponding value in alphabetical order.
     * Returns null if the input array is null.
     * <p>
     * Example: The array ["c","a","b"] will result in [1, 2, 0].
     *
     * @param arr array of Strings that stored the values
     * @return the indices in sorted order
     */
    public static int[] indexSort(String[] arr) {
        if (arr == null) {
            return null;
        }

        int[] indices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[i] = i;
        }

        insertionSort(arr, indices);
        return indices;
    }

    private static void insertionSort(String[] arr, int[] indices) {
        for (int i = 1; i < arr.length; i++) {
            int current = indices[i];
            String currentChar = arr[i];
            int index = i;
            while (index > 0 && arr[index - 1].compareTo(currentChar) > 0) {
                indices[index] = indices[index - 1];
                arr[index] = arr[index - 1];
                index--;
            }
            indices[index] = current;
            arr[index] = currentChar;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"a", "d", "b", "c"};
        int[] res = indexSort(arr);
        int[] expected = {0, 2, 3, 1};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }
}
