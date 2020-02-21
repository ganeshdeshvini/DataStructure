package queue;

public class CircularQueue {
    static class Node {
        private int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    private final Node[] queue;
    private int startingIndex = 0;
    private int endingIndex = 0;
    private final int MAX_SIZE;

    public CircularQueue(int maxSize) {
        this.MAX_SIZE = maxSize;
        this.queue = new Node[maxSize];
    }

    private void enqueue(int data) {
        if (isQueueFull()) {
            System.out.println("Queue is not Empty...cannot proceed!!!");
            return;
        }
        if (endingIndex == MAX_SIZE) {
            endingIndex = 0;
        }
        queue[endingIndex++] = new Node(data);
    }

    private Node dequeue() {
        if (startingIndex == MAX_SIZE - 1) {
            startingIndex = 0;
        }
        Node node = queue[startingIndex];
        queue[startingIndex] = null;
        startingIndex++;
        return node;
    }

    private boolean isQueueFull() {
        if (queue[0] != null) {
            return endingIndex == MAX_SIZE;
        } else {
            return endingIndex + 1 == startingIndex;
        }
    }

    void print() {
        int currentIndex = startingIndex;
        Node node;
        while (true) {
            node = queue[currentIndex];
            System.out.print((node != null ? node : "NULL") + " - ");
            currentIndex++;
            if (startingIndex != 0) {
                if (currentIndex == MAX_SIZE) {
                    currentIndex = 0;
                }
                if (currentIndex == endingIndex) {
                    break;
                }
            } else {
                if (currentIndex == MAX_SIZE) {
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.print();
        System.out.println("Queue Full: " + circularQueue.isQueueFull());
        System.out.println("Dequeue: " + circularQueue.dequeue());
        circularQueue.enqueue(123);
        circularQueue.print();
    }
}
