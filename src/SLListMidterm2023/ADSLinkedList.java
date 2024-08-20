package SLListMidterm2023;

public class ADSLinkedList<T> {
    Node<T> head;

    /**
     * Removes every other element from the list.
     */
    public void remove() {
        if (head == null || head.getNext() == null) {
            return;
        }
        Node<T> current = head;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getNext() != null) {
                current.setNext(current.getNext().getNext());
            } else {
                current.setNext(null);
            }
            current = current.getNext();
        }
    }

    /**
     * Reverses the list.
     */
    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> nextNode;
        while (current != null) {
            nextNode = current.getNext();
            current.setNext(previous);

            previous = current;
            current = nextNode;

            if (current == null) {
                head = previous;
            }
        }
    }

    /**
     * Rearranges the nodes such that all nodes with even indices end
     * up packed together at the front, and all nodes with odd indices
     * end up packed together at the back.
     * <p>
     * Note: the first node in the list corresponds to index 0,
     * which is considered even.
     */
    public void pack() {
        Node<T> even = head;
        Node<T> odd = head.getNext();

        // Remember first node of odd list.
        Node<T> oddFirst = odd;
        while (true) {
            if (even == null || odd == null || odd.getNext() == null) {
                even.setNext(oddFirst);
                break;
            }

            even.setNext(odd.getNext());
            even = odd.getNext();

            // If there are no more odd nodes after the even one.
            if (even.getNext() == null) {
                odd.setNext(null);
                even.setNext(oddFirst);
                break;
            }
            odd.setNext(even.getNext());
            odd = even.getNext();
        }
    }
}
