package Heap.Tree;

public class Heap extends LibraryHeap {
    /**
     * Constructor of the heap
     *
     * @param key the key value for the root
     */
    public Heap(int key) {
        super(key);
    }

    /**
     * Performs the downheap operation starting from the specified node
     *
     * @param node the node where the downheap starts
     */
    @Override
    public void downHeap(TreeNode node) {
        if (node == null) {
            return;
        }
        int largest = node.getKey();
        if (node.hasLeft() && node.getLeft().getKey() > largest) {
            largest = node.getLeft().getKey();
        }
        if (node.hasRight() && node.getRight().getKey() > largest) {
            largest = node.getRight().getKey();
        }
        if (largest == node.getKey()) {
            return;
        }
        if (node.hasLeft() && largest == node.getLeft().getKey()) {
            swap(node, node.getLeft());
            downHeap(node.getLeft());
            return;
        } if (node.hasRight() && largest == node.getRight().getKey()) {
            swap(node, node.getRight());
            downHeap(node.getRight());
        }
    }

    /**
     * Removes the maximum element in this max heap
     *
     * @return the maximum element in the heap
     */
    @Override
    public int removeMax() {
        int result = root.getKey();
        swap(root, getLastNode());
        removeLastNode();
        downHeap(root);
        return result;
    }
}
