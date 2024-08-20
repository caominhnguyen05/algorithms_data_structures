package LinkedList;

public class SinglyLinkedList {
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
        public void setElement(Object e) {
            element = e;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node n) {
            next = n;
        }
    }

    private Node head;
    public SinglyLinkedList() {
        head = null;
    }

    public Object getHead() {
        return head.getElement();
    }

    public void addFirst(Object e) {
        head = new Node(e, head);
    }

    public Object removeFirst() {
        if (head == null) {
            return null;
        }
        Object result = head.getElement();
        head = head.getNext();
        return result;
    }

    public void addLast(Object e) {
        if (head == null) {
            addFirst(e);
        } else {
            Node newNode = new Node(e, null);
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }
    public Object removeLast() {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return removeFirst();
        }
        Node previousNode = head;
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        previousNode.setNext(null);
        return currentNode.getElement();
    }

    public Object removeFromPosition(int pos) {
        // Invalid index or empty list
        if (pos < 0 || head == null) {
            return null;
        }
        if (pos == 0) {
            return removeFirst();
        }
        Node previousNode = null;
        Node currentNode = head;
        int index = 0;

        // Iterate through the list to find the node at the specified index
        while (currentNode != null && index < pos) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            index++;
        }
        if (currentNode == null) {
            return null;
        }
        previousNode.setNext(currentNode.getNext());
        return currentNode.getElement();

    }
}
