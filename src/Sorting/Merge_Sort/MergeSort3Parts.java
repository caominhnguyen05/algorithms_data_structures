package Sorting.Merge_Sort;

import java.util.*;

public class MergeSort3Parts {
    public static int[] coatiSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int n = arr.length;

        int partitionSize;
        if (n % 3 == 2) {
            partitionSize = n / 3 + 1;
        } else {
            partitionSize = n / 3;
        }


        int[] subArray1 = Arrays.copyOfRange(arr, 0, partitionSize);

        int[] subArray2 = Arrays.copyOfRange(arr, partitionSize, partitionSize * 2);

        int[] subArray3 = Arrays.copyOfRange(arr, partitionSize * 2, arr.length);

        subArray1 = coatiSort(subArray1);
        subArray2 = coatiSort(subArray2);
        subArray3 = coatiSort(subArray3);

        int[] firstMerge = merge(subArray1, subArray2);
        return merge(firstMerge, subArray3);
    }

    public static int[] merge(int[] subArray1, int[] subArray2) {
        int[] res = new int[subArray1.length + subArray2.length];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < subArray1.length && j < subArray2.length) {
            if (subArray1[i] <= subArray2[j]) {
                res[index] = subArray1[i];
                index++;
                i++;
            } else {
                res[index] = subArray2[j];
                j++;
                index++;
            }
        }
        while (i < subArray1.length) {
            res[index++] = subArray1[i++];
        }
        while (j < subArray2.length) {
            res[index++] = subArray2[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {4, 2, 5, 1, 3};
        int[] result = coatiSort(input);
        System.out.println(Arrays.toString(result));
    }
}
