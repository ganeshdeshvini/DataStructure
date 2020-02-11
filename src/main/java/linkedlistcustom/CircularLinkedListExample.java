package linkedlistcustom;


public class CircularLinkedListExample {
    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<Integer>();
        customLinkedList.insert(1);
        customLinkedList.insert(2);
        customLinkedList.insert(3);
        System.out.println(customLinkedList);
        customLinkedList.isCircularLink();
        customLinkedList.makeCircularLink();
        customLinkedList.isCircularLink();
    }

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "->";
        }
    }

    static class CustomLinkedList<T> {
        Node<T> first;
        Node<T> last;

        void insert(T data) {
            Node<T> newNode = new Node<T>(data);
            if (first == null) {
                first = newNode;
                last = first;
            } else {
                last.next = newNode;
                last = last.next;
            }
        }

        void makeCircularLink() {
            last.next = first;
        }

        void isCircularLink() {
            Node<T> slowPtr = first;
            Node<T> fastPtr = first.next;
            while ((slowPtr != fastPtr || fastPtr.next == null) && fastPtr.next.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
            if (slowPtr == fastPtr) {
                System.out.println("CIRCULAR");
            } else {
                System.out.println("NON-CIRCULAR");
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<T> current = first;

            while (current != null) {
                sb.append(current);
                current = current.next;
            }
            return sb.toString();
        }
    }
}