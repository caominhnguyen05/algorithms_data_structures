package LinkedList;

public class SinglyLinkedListComplete implements Cloneable {
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
        public void setNext(Node n) {
            next = n;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    public SinglyLinkedListComplete() {
        head = null;
        tail = null;
        size = 0;
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
        return head.getElement();
    }
    public Object last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(Object e) {
        head = new Node(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }
    public void addLast(Object e) {
        if (size == 0) {
            addFirst(e);
        } else {
            Node newNode = new Node(e, null);
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }

    public Object removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Object result = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return result;
    }

    public Object removeAtPosition(int pos) {
        if (pos < 0 || isEmpty()) {
            return null;
        }
        if (pos == 0) {
            return removeFirst();
        }
        Node previousNode = null;
        Node currentNode = head;
        int index = 0;
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

    public void addAtPosition(Object e, int pos) {
        if (pos < 0) {
            return;
        }
        if (pos == 0) {
            addFirst(e);
        } else {
            Node newNode = new Node(e, null);
            Node previous = null;
            Node current = head;
            int index = 0;
            while (current != null && index < pos) {
                previous = current;
                current = current.getNext();
                index++;
            }

            if (index < pos) {
                addLast(e);
            } else {
                previous.setNext(newNode);
                newNode.setNext(current);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        SinglyLinkedListComplete that = (SinglyLinkedListComplete) o;
        if (size != that.size()) {
            return false;
        }
        Node current1 = head;
        Node current2 = that.head;
        while (current1 != null) {
            if (!current1.getElement().equals(current2.getElement())) {
                return false;
            }
            current1 = current1.getNext();
            current2 = current2.getNext();
        }
        return true;
    }

    public SinglyLinkedListComplete clone() throws CloneNotSupportedException {
        SinglyLinkedListComplete other = (SinglyLinkedListComplete) super.clone();
        // we need independent chain of nodes
        if (size > 0) {
            // create new head
            other.head = new Node(head.getElement(), null);
            Node currentOld = head.getNext();
            Node currentNew = other.head;
            while (currentOld != null) {
                Node newest = new Node(currentOld.getElement(), null);
                currentNew.setNext(newest);
                currentNew = newest;
                currentOld = currentOld.getNext();
            }
        }
        return other;
    }
}
