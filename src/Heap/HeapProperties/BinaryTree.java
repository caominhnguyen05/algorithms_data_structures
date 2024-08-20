package Heap.HeapProperties;

public class BinaryTree {
    private int key;

    private BinaryTree left, right;

    /**
     * Simple constructor.
     *
     * @param key to set as key.
     */
    public BinaryTree(int key) {
        this.key = key;
    }

    /**
     * Extended constructor.
     *
     * @param key to set as key.
     * @param left to set as left child.
     * @param right to set as right child.
     */
    public BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this.key = key;
        setLeft(left);
        setRight(right);
    }

    public int getKey() {
        return key;
    }

    /**
     * Gives the left child of this node.
     *
     * @return the left child.
     */
    public BinaryTree getLeft() {
        return left;
    }

    /**
     * Gives the right child of this node.
     *
     * @return the right child.
     */
    public BinaryTree getRight() {
        return right;
    }

    /**
     * Indicates whether this node has a left child.
     *
     * @return true if there is a left child, false otherwise
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * Indicates whether this node has a right child.
     *
     * @return true if there is a right child, false otherwise
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * Sets the left child of this node.
     *
     * @param left to set
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * Sets the right child of this node.
     *
     * @param right to set
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTree{" + "key=" + key + ", left=" + left + ", right=" + right + '}';
    }
}
