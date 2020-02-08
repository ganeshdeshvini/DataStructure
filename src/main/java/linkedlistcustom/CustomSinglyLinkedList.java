package linkedlistcustom;

public class CustomSinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length = 0;

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            //if it is NOT the first node to add
            tail.setNext(newNode);
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
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == length - 1) {
            addLast(data);
            return;
        }

        Node<T> currentNode = head;
        Node<T> previousNode = null;
        int pointer = 0;
        while (currentNode != null) {
            if (pointer == index) {
                previousNode.next = newNode;
                newNode.next = currentNode;
                length++;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            pointer++;
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

    public void reverse() {
        Node<T> current = head;
        tail = reverseLinkedList(current);
        tail.next =null;
    }

    private Node<T> reverseLinkedList(Node<T> current) {
        if(current.next == null) {
            head = current;
            return current;
        }
        reverseLinkedList(current.next).next = current;
        return current;
    }

    public static void main(String[] args) {
        CustomSinglyLinkedList<Integer> customSinglyLinkedList = new CustomSinglyLinkedList<>();
        customSinglyLinkedList.addLast(1);
        customSinglyLinkedList.addLast(2);
        customSinglyLinkedList.addLast(3);
        customSinglyLinkedList.addLast(1);
        customSinglyLinkedList.addFirst(10);
        customSinglyLinkedList.insertAt(3, 123);
        customSinglyLinkedList.print();
        System.out.println(customSinglyLinkedList.getFirst());
        System.out.println(customSinglyLinkedList.getLast());
        System.out.println(customSinglyLinkedList.getLength());
        customSinglyLinkedList.reverse();
        customSinglyLinkedList.print();
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

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
    }
}