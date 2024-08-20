package Palindrome;

import java.util.*;

public class Solution {
    /**
     * Checks for a String represented as a SLList whether this String is a palindrome.
     * This is done by using a stack.
     * <p>
     * An empty String or null should return true.
     *
     * @param list SLList used to represent a String
     * @return true if the String represented as a SLList is a palindrome, otherwise false
     */
    public static boolean checkPalindrome(SLList list) {
        if (list == null || list.size() == 0) {
            return true;
        }

        LibraryStack<Character> stack = new LibraryStack<>();
        int size = list.size();
        for (int i = 0; i < size/2; i++) {
            stack.push(list.removeFirst());
        }
        if (size % 2 != 0) {
            list.removeFirst();
        }
        while (!stack.isEmpty()) {
            char res = stack.pop();
            char fromList = list.removeFirst();
            if (res != fromList) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SLList list = new SLList("mom");
        System.out.println(checkPalindrome(list));
    }
}
