package StableSortingStrings;

import java.util.Arrays;

public class Solution {
    public static void stableSort(String[][] table, int column) {
        if (table == null || table.length == 0) {
            return;
        }
        for (int i = 1; i < table.length; i++) {
            String current = table[i][column];
            String[] currentRow = table[i];
            int j = i;
            while (j > 0 && table[j-1][column].compareTo(current) > 0) {
                table[j] = table[j-1];
                j--;
            }
            table[j] = currentRow;
        }
    }

    public static void main(String[] args) {
        String[][] data = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        stableSort(data, 1);
        System.out.println(Arrays.deepToString(data));
    }
}
