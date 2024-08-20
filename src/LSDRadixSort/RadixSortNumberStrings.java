package LSDRadixSort;

import java.util.*;

public class RadixSortNumberStrings {
    /**
     * Sorts the list of student IDs as defined in the description.
     *
     * @param studentIds - list of student IDs
     * @return sorted list of student IDs
     */
    static List<String> sortStudentId(List<String> studentIds) {
        for (int i = 5; i >= 0; i--) {
            studentIds = bucketSort(studentIds, i);
        }
        return studentIds;
    }

    static List<String> bucketSort(List<String> list, int index) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        List<String> result = new ArrayList<>();
        if (index != 3 && index != 1) {
            List<List<String>> buckets = new ArrayList<>(26);
            for (int i = 0; i < 26; i++) {
                buckets.add(new ArrayList<>());
            }

            for (String s : list) {
                int pos = s.charAt(index) - 'A';
                buckets.get(pos).add(s);
            }


            for (int i = 25; i >= 0; i--) {
                for (String s : buckets.get(i)) {
                    result.add(s);
                }
            }
        } else {
            List<List<String>> buckets = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }

            for (String s : list) {
                int pos = Character.getNumericValue(s.charAt(index)) - 1;
                buckets.get(pos).add(s);
            }

            for (int i = buckets.size() - 1; i >= 0; i--) {
                for (String item : buckets.get(i)) {
                    result.add(item);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        List<String> arr = List.of("A1A3BB", "A2B4AB", "B4C2DA", "A1B3BB", "A2B4AA", "A1C3BB", "A1C4DB");
        System.out.println(Character.getNumericValue('1'));
        System.out.println(sortStudentId(arr));
    }
}
