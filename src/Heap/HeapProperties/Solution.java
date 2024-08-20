package Heap.HeapProperties;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * Checks whether the given BinaryTree has the heap property for a max-heap.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree satisfies the heap property, else false.
     */
    public static boolean hasHeapProperty(BinaryTree tree) {
        if (tree == null) {
            return false;
        }
        return hasHeapPropertyHelper(tree);
    }

    private static boolean hasHeapPropertyHelper(BinaryTree tree) {
        if (tree == null) {
            return true;
        }
        if (tree.hasLeft() && tree.getLeft().getKey() > tree.getKey()) {
            return false;
        }
        if (tree.hasRight() && tree.getRight().getKey() > tree.getKey()) {
            return false;
        }
        return hasHeapPropertyHelper(tree.getLeft()) && hasHeapPropertyHelper(tree.getRight());
    }

    /**
     * Checks whether the BinaryTree is complete.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isCompleteTree(BinaryTree tree) {
        if (tree == null) {
            return false;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);

        boolean foundNullChild = false;
        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            if (current == null) {
                foundNullChild = true;
            } else {
                if (foundNullChild) {
                    return false;
                }
                queue.add(current.getLeft());
                queue.add(current.getRight());
            }
        }
        return true;
    }
}
