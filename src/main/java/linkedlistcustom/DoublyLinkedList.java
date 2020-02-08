package linkedlistcustom;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length = 0;

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            //if it is NOT the first node to add
            tail.setNext(newNode);
            newNode.previous = tail;
            tail = newNode;
        } else {
            //if it is the first node to add
            head = newNode;
            tail = head;
        }
        length++;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            //if it is NOT the first node to add
            newNode.setNext(head);
            head.previous = newNode;
            head = newNode;
        } else {
            //if it is the first node to add
            head = newNode;
            tail = head;
        }
        length++;
    }

    public void insertAt(int index, T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = head;

        int pointer = 0;
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == length - 1) {
            addLast(data);
            return;
        }

        while (currentNode != null) {
            if (pointer == index) {
                //Found the index to insert the Node
                newNode.previous = currentNode.previous;
                currentNode.previous.next = newNode;
                currentNode.previous = newNode;
                currentNode.previous = newNode;
                newNode.next = currentNode;
                length++;
            }
            pointer++;
            currentNode = currentNode.next;
        }
    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        return tail.getData();
    }

    public int getLength() {
        return length;
    }

    public void print() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " => ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(1);
        doublyLinkedList.addFirst(10);
        doublyLinkedList.insertAt(2, 30);
        doublyLinkedList.print();
        System.out.println(doublyLinkedList.getFirst());
        System.out.println(doublyLinkedList.getLast());
        System.out.println(doublyLinkedList.getLength());
    }

    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}


