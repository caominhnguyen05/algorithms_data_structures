package LSDRadixSort;

import java.util.*;

public class RadixSortString {
    public static List<String> radixSortLSD(List<String> arr) {
        int maxLength = arr.get(0).length();

        // Perform counting sort for each character position, starting from the least significant digit
        for (int i = maxLength - 1; i >= 0; i--) {
            arr = bucketSort(arr, i);
        }
        return arr;
    }

    private static List<String> bucketSort(List<String> arr, int exp) {
        if (arr == null || arr.size() <= 1) {
            return arr;
        }
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            buckets.add(new ArrayList<>());
        }
        for (String s : arr) {
            int index = s.charAt(exp) - 'A';
            buckets.get(index).add(s);
        }
        List<String> result = new ArrayList<>();
        for (List<String> bucket : buckets) {
            for (String s : bucket) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> arr = List.of("ZRH", "ARN", "AMS", "LHR", "BCN");
        System.out.println(radixSortLSD(arr));
    }
}
