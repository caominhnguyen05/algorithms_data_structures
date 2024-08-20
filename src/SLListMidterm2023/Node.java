package SLListMidterm2023;
import java.util.*;

public class Node<T> {

    // Each Node object has these two fields
    private T element;

    private Node<T> next;

    // Constructor: Creates a Node object with element = e and next = n
    Node(T e, Node<T> n) {
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

    // This function gets Node n as input and sets the next variable of the current Node object as
    // n.
    public void setNext(Node<T> n) {
        next = n;
    }

    // This function returns the next Node
    public Node<T> getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(element, node.element) && Objects.equals(next, node.next);
    }
}

