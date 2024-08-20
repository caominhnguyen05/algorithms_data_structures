import java.util.*;

public class MapStringOccurrences {
    /**
     * Counts the number of occurrences of substring of length k in string s.
     *
     * @param s
     *     The String in which to look for substrings.
     * @param k
     *     The length of the substrings to look for.
     * @return Map with entries in the form of (sub, numOcc), where sub denotes a substring with numOcc occurrences in s.
     * Note: There should be no entries in the map for substrings that do not occur in string s.
     */
    public static Map<String, Integer> countSubstringOccurrences(String s, int k) {
        if (s == null) {
            return null;
        }
        if (k > s.length() || k == 0) {
            return new HashMap<>();
        }
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            String subString = s.substring(i, i + k);
            if (!result.containsKey(subString)) {
                result.put(subString, 1);
            } else {
                result.replace(subString, result.get(subString) + 1);
            }
        }
        return result;
    }

    /**
     * Counts the occurrences of substrings (of **all lengths**) in a given string s.
     * Should make use of the method countSubstringOccurrences(String s, int k).
     *
     * @param s
     *     The String in which to look for substrings.
     * @return Map with entries in the form of (sub, numOcc), where sub denotes a substring with numOcc occurrences in s.
     * Note 1: There should be no entries in the map for substrings that do not occur in string s.
     * Note 2: When iterating through the returned map, the substrings should be found in increasing order of their length.
     */
    public static Map<String, Integer> countSubstringOccurrences(String s) {
        Map<String, Integer> result = new LinkedHashMap<>();
        if (s == null) {
            return null;
        }
        for (int i = 0; i <= s.length(); i++) {
            Map<String, Integer> thisRun = countSubstringOccurrences(s, i);
            if (thisRun != null) {
                result.putAll(thisRun);
            }
        }
        return result;
    }

    /**
     * Simplifies a given map of substrings and their occurrences by removing substrings that do not repeat.
     * Must be implemented in-place.
     *
     * @param substringsMap
     *     The map from which substrings that do not repeat (occur only once) are to be removed.
     */
    public static void repeatedSubstrings(Map<String, Integer> substringsMap) {
        Iterator<Map.Entry<String, Integer>> iterator = substringsMap.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() == 1) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> missMap = countSubstringOccurrences("mississippi", 4);
        System.out.println(missMap.entrySet());
    }
}
