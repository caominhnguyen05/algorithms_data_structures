package MSDRadixSort;
import java.util.*;

public class Solution {
    /**
     * Sorts a list of words using MSD radix sort.
     *
     * @param words The list of words to sort.
     * @return The sorted list of words.
     * @throws NullPointerException If `words` equals `null`.
     */
    static List<String> radixSortMSD(List<String> words) {
        if (words == null) {
            throw new IllegalArgumentException();
        }
        return bucketSort(words, 0);
    }

    private static List<String> bucketSort(List<String> words, int index) {
        if (words.size() < 2) {
            return words;
        }
        List<List<String>> buckets = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            buckets.add(new ArrayList<>());
        }

        List<String> result = new ArrayList<>(words.size());
        for (String word : words) {
            if (index < word.length()) {
                int p = word.charAt(index) - 'a';
                buckets.get(p).add(word);
            } else {
                result.add(word);
            }
        }

        for (List<String> bucket : buckets) {
            words.addAll(bucketSort(bucket, index +1));
        }
        return result;
    }
}
