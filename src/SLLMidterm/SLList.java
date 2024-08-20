package SLLMidterm;

import java.util.ArrayList;
import java.util.List;

public class SLList<T> {
    class Node {
        // Each Node object has these two fields
        private T element;
        private Node next;

        // Constructor: Creates a Node object with element = e and next = n
        Node(T e, Node n) {
            element = e;
            next = n;
        }

        // This function gets T e as input and sets e as the element of the Node
        public void setElement(T e) {
            element = e;
        }

        // This function returns the element variable of the Node
        public T getElement() {
            return element;
        }

        // This function gets Node n as input and sets the next variable of the current Node object as n.
        public void setNext(Node n) {
            next = n;
        }

        // This function returns the next Node
        public Node getNext() {
            return next;
        }
    }

    // Each object in SLList has one field head, which points to the starting Node of SLList.
    private Node head;

    /**
     * Constructor: initialises the head field as null
     */
    public SLList() {
        head = null;
    }

    /**
     * @return The element in the first Node of this SLL. If the list is empty, this method returns null.
     */
    public T getFirst() {
        if (head == null)
            return null;
        return head.getElement();
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e The element to add.
     */
    public void addFirst(T e) {
        head = new Node(e, head);
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the first Node. If the list is empty, this method returns null.
     */
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T result = head.getElement();
        head = head.getNext();
        return result;
    }

    /**
     * Combine this list with the other list.
     * Each element of the resulting list is a Pair object holding one element of this list
     * and the corresponding element at the same position of the other list.
     * If one list is longer than the other, any extra elements should be dropped.
     * Example: Zipping [1, 2] with [5, 6, 7] results in [(1, 5), (2, 6)], where (x, y) denotes a Pair object.
     *
     * @param other The other list to combine elements with. Is treated as an empty list if it is null.
     * @return A new list with alternated elements of this list and the other list.
     */
    public SLList<Pair<T, T>> zip(SLList<T> other) {
        SLList<Pair<T, T>> result = new SLList<>();
        Node thisHead = head;
        Node otherHead;
        if (other == null) {
            otherHead = null;
        } else {
            otherHead = other.head;
        }

        while (thisHead != null && otherHead != null) {
            Pair<T, T> pair = new Pair<>(thisHead.getElement(), otherHead.getElement());
            result.addFirst(pair);
            thisHead = thisHead.getNext();
            otherHead = otherHead.getNext();
        }

        SLList<Pair<T, T>> reverse = new SLList<>();
        Pair<T, T> current = result.removeFirst();
        while (current != null) {
            reverse.addFirst(current);
            current = result.removeFirst();
        }
        return reverse;
    }


    /**
     * Appends another SLL to this SLL.
     *
     * @param other The list to append to this list. Is treated as an empty list if it is null.
     */
    public void append(SLList<T> other) {
        if (other == null) {
            return;
        }

        if (head == null) {
            head = other.head;
            return;
        }
        Node otherHead = other.head;
        Node current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(otherHead);
    }

    /**
     * Removes all elements at the even positions in this list.
     * Note that the head of the list is element number 0, which is an even position.
     */
    public void dropEven() {
        if (head == null) {
            return;
        }
        Node current = head;
        head = current.getNext();
        current = current.getNext();
        while (current != null && current.getNext() != null) {
            if (current.getNext().getNext() != null) {
                current.setNext(current.getNext().getNext());
            } else {
                current.setNext(null);
            }
            current = current.getNext();
        }

    }

    public static void main(String[] args) {
        SLList<Integer> list = new SLList<>();
        list.addFirst(42);
        list.addFirst(43);
        list.addFirst(44);
        list.addFirst(45);
        list.addFirst(46);
        list.dropEven();
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
    }
}
