package LinkedList;

public class CircularlyLinkedList {
    private static class Node {
        private Object element;
        private Node next;

        public Node(Object element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Object getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node tail;
    private int size;
    public CircularlyLinkedList() {
        tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void addFirst(Object e) {
        if (size == 0) {
            tail = new Node(e, null);
            tail.setNext(tail);
        } else {
            Node newNode = new Node(e, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void addLast(Object e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public Object removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node head = tail.getNext();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }
}
