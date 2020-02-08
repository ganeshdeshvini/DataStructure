package queue;

/**
 * Best DataStructure for QUEUE is LINKEDLIST
 * Don't use Arrays as Arrays are not efficient, because everytime we are going to DEQUEUE
 * elements, then it will have to perform indexing again for other, will take O(n) complexity
 *
 * @param <T>
 */
public class CustomQueue<T> {
    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int length = 0;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (length == 0) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public T dequeue() {
        if (length == 0) {
            System.out.println("Queue is Empty");
            return null;
        }
        T data = head.data;
        head = head.next;
        length--;
        return data;
    }

    public void print() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " => ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        customQueue.enqueue(1);
        customQueue.enqueue(2);
        customQueue.enqueue(3);
        customQueue.print();
        System.out.println("DEQUE: " + customQueue.dequeue());
        System.out.println("DEQUE: " + customQueue.dequeue());
        System.out.println("DEQUE: " + customQueue.dequeue());
        System.out.println("DEQUE: " + customQueue.dequeue());
        customQueue.print();
    }
}
