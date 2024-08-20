package LinkedList;

public class DoublyLinkedList {
    private static class Node {
        private Object element;
        private Node previous;
        private Node next;

        public Node(Object element, Node prev, Node next) {
            this.element = element;
            this.previous = prev;
            this.next = next;
        }

        public Object getElement() {
            return element;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext() {
            return next;
        }

        public void setPrevious(Node prev) {
            this.previous = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public Object getHead() {
        if (head == null) {
            return null;
        }
        return head.getElement();
    }

    public Object getTail() {
        if (tail == null) {
            return null;
        }
        return tail.getElement();
    }

    /**
     * Returns the number of Nodes in the list.
     *
     * @return the number of Nodes in the list.
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        Node currentNode = head;
        int count = 0;
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            count++;
        }
        return count;
    }

    /**
     * Adds element e in a new Node to the head of the list.
     *
     * @param e the element to add.
     */
    public void addFirst(Object e) {
        Node newNode = new Node(e, null, head);
        if (head != null) {
            head.setPrevious(newNode);
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    /**
     * Remove the first Node in the list and return its element.
     *
     * @return The element of the head Node. If the list is empty, this method returns null.
     */
    public Object removeFirst() {
        if (head == null) {
            return null;
        }
        Object result = head.getElement();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrevious(null);
        }
        return result;
    }

    /**
     * Adds element e in a new Node to the tail of the list.
     *
     * @param e the element to add.
     */
    public void addLast(Object e) {
        if (tail == null) {
            addFirst(e);
        } else {
            Node newNode = new Node(e, tail, null);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    /**
     * Remove the last Node in the list and return its element.
     *
     * @return The element of the tail Node. If the list is empty, this method returns null.
     */
    public Object removeLast() {
        if (tail == null) {
            return null;
        }
        Object result = tail.getElement();
        tail = tail.getPrevious();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        return result;
    }

    /**
     * Adds element e in a new Node which is inserted at position pos.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
     * If there is no Node in position pos, this method adds it to the last position.
     *
     * @param pos
     *     The position to insert the element at.
     * @param e
     *     The element to add.
     */
    public void addAtPosition(int pos, Object e) {
        if (pos <= 0) {
            addFirst(e);
            return;
        }
        int index = 0;
        Node currentNode = head;
        while (currentNode != null && index < pos) {
            currentNode = currentNode.getNext();
            index++;
        }
        if (currentNode == null) {
            addLast(e);
        } else {
            Node newNode = new Node(e, currentNode.getPrevious(), currentNode);
            currentNode.getPrevious().setNext(newNode);
            currentNode.setPrevious(newNode);
        }

    }

    /**
     * Remove Node at position pos and return its element.
     * The list is zero indexed, so the first element in the list corresponds to position 0.
     * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
     *
     * @param pos
     *     The position to remove the Node from.
     * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
     */
    public Object removeFromPosition(int pos) {
        if (pos < 0) {
            return null;
        }
        if (pos == 0) {
            return removeFirst();
        }
        Node currentNode = head;
        int index = 0;
        while (currentNode != null && index < pos) {
            currentNode = currentNode.getNext();
            index++;
        }
        if (currentNode != null) {
            Object result = currentNode.getElement();
            currentNode.getPrevious().setNext(currentNode.getNext());
            if (currentNode.getNext() != null) {
                currentNode.getNext().setPrevious(currentNode.getPrevious());
            } else {
                tail = currentNode.getPrevious();
            }
            return result;
        } else {
            return null;
        }
    }

    /**
     * @return A new DLL that contains the elements of the current one in reversed order.
     */
    public DoublyLinkedList reverse() {
        DoublyLinkedList result = new DoublyLinkedList();
        Node currentNode = tail;
        while (currentNode != null) {
            result.addLast(currentNode.getElement());
            currentNode = currentNode.getPrevious();
        }
        return result;
    }
}
