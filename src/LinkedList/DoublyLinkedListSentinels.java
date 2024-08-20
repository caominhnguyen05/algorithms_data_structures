package LinkedList;

public class DoublyLinkedListSentinels {
    private static class Node {
        private Object element;
        private Node prev;
        private Node next;

        public Node(Object element, Node prev, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public Object getElement() {
            return element;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node header;
    private Node trailer;
    private int size;
    public DoublyLinkedListSentinels() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.setNext(trailer);
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public Object first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext();
    }

    public Object last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev();
    }
    private void addBetween(Object e, Node predecessor, Node successor) {
        Node newNode = new Node(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }
    private Object remove(Node node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        return node.getElement();
    }
    public void addFirst(Object e) {
        addBetween(e, header, header.getNext());
    }
    public void addLast(Object e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public Object removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    public Object removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }
}
