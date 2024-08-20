package Heap.Tree;

public abstract class LibraryHeap {
    TreeNode root;

    int size;

    public LibraryHeap(int key) {
        root = new TreeNode(key);
        size = 1;
    }

    /**
     * Returns the last node in this heap when performing a breadth-first traversal
     */
    public TreeNode getLastNode() {
        int height = (int) Math.ceil(Math.log(size + 1) / Math.log(2)) - 1;
        int completeSize = (int) Math.pow(2, height) - 1;
        int lastIndex = (size - completeSize - 1);
        TreeNode node = this.root;
        for (int mask = 1 << (height - 1); mask > 0; mask >>= 1) {
            int bit = lastIndex & mask;
            if (bit == 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node;
    }

    /**
     * Removes the last node in the heap
     */
    public void removeLastNode() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            root = null;
            size--;
            return;
        }
        TreeNode parent = getLastNode().getParent();
        if (parent.hasRight()) {
            parent.removeRight();
        } else {
            parent.removeLeft();
        }
        size--;
    }

    /**
     * Swaps the keys of two nodes i and j without affecting their pointers i.e. left, right, and parent
     */
    public void swap(TreeNode i, TreeNode j) {
        int temp = i.getKey();
        i.setKey(j.getKey());
        j.setKey(temp);
    }

    public abstract void downHeap(TreeNode node);

    public abstract int removeMax();
}
