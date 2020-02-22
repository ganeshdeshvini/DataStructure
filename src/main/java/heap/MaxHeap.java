package heap;

import java.util.Arrays;

import static helpers.Util.swap;

/**
 * Left Child = (2*index) + 1
 * Right Child = (2*index) + 2
 * Parent = (index-1)/2
 */
public class MaxHeap {
    private final Integer[] arrMinHeap;
    private final int maxSize;
    private int currentIndex = -1;

    public MaxHeap(int maxSize) {
        this.arrMinHeap = new Integer[maxSize];
        this.maxSize = maxSize;
    }

    public void insert(int data) {
        if (isFull()) {
            System.out.println("Heap is full");
            return;
        }
        arrMinHeap[++currentIndex] = data;
        heapifyUp(data);
    }

    private void heapifyUp(int data) {
        int insertedIndexLocation = currentIndex;
        Integer parentIndex = getParentIndex(insertedIndexLocation);
        while (parentIndex != null && arrMinHeap[parentIndex] < data) {
            swap(arrMinHeap, insertedIndexLocation, parentIndex);
            insertedIndexLocation = parentIndex;
            parentIndex = getParentIndex(insertedIndexLocation);
        }
    }

    public Integer remove() {
        if (isEmpty()) {
            System.out.println("Nothing to remove");
            return null;
        }
        int heapifyDownIndex = 0;
        Integer deletedValue = arrMinHeap[heapifyDownIndex];
        currentIndex--;
        heapifyDown(heapifyDownIndex);
        return deletedValue;
    }

    /**
     * Steps:
     * 1) First update the heapify index with the last element of array
     * 2) If it is a leaf Node then exit
     * 3) If it contains only one child i.e., Only Left child then compare the leftchild value with the heapifyindex,
     * if leftchild > heapifyindex then do a swap, else exit
     * 4) If both the child are present then check if heapifyindex value is greater then both the child
     * if condition satisfies then exit as this is the desired location,
     * if condition doesn't satisfies then find the greatest between both the child (left vs right)
     * & swap the heapifyindex with the largest child and continue to Step 2 again
     */
    private void heapifyDown(int heapifyDownIndex) {
        arrMinHeap[heapifyDownIndex] = arrMinHeap[currentIndex + 1];
        arrMinHeap[currentIndex + 1] = null;

        while (!isLeafNode(heapifyDownIndex)) {
            Integer leftChildIndex = getLeftChildIndex(heapifyDownIndex);
            Integer rightChildIndex = getRightChildIndex(heapifyDownIndex);
            Integer valueToBeProcessed = arrMinHeap[heapifyDownIndex];
            if (rightChildIndex == null) {
                if (arrMinHeap[leftChildIndex] > valueToBeProcessed) {
                    swap(arrMinHeap, heapifyDownIndex, leftChildIndex);
                    heapifyDownIndex = leftChildIndex;
                }
            } else {
                if (valueToBeProcessed > arrMinHeap[leftChildIndex] && valueToBeProcessed > arrMinHeap[rightChildIndex]) {
                    return;
                }
                int indexToSwappedWith = arrMinHeap[leftChildIndex] > arrMinHeap[rightChildIndex] ? leftChildIndex : rightChildIndex;
                swap(arrMinHeap, indexToSwappedWith, heapifyDownIndex);
                heapifyDownIndex = indexToSwappedWith;
            }
        }
    }

    boolean isEmpty() {
        return currentIndex == -1;
    }

    boolean isFull() {
        return currentIndex == maxSize - 1;
    }

    boolean isLeafNode(int index) {
        return getLeftChildIndex(index) == null;
    }

    public Integer getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        return leftChildIndex <= currentIndex ? leftChildIndex : null;
    }

    public Integer getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        return rightChildIndex <= currentIndex ? rightChildIndex : null;
    }

    public Integer getParentIndex(int index) {
        int parentIndex = (index - 1) / 2;
        return parentIndex >= 0 ? parentIndex : null;
    }

    public void print() {
        System.out.println(Arrays.toString(arrMinHeap));
        for (int i = 0; i <= currentIndex / 2; i++) {
            if (isLeafNode(i)) {
                continue;
            }
            System.out.printf("%d =>  [%s, %s]",
                    arrMinHeap[i], formatChildValue(getLeftChildIndex(i)), formatChildValue(getRightChildIndex(i)));
            System.out.println();
        }
    }

    private String formatChildValue(Integer index) {
        return index != null ? (arrMinHeap[index] != null ? arrMinHeap[index].toString() : "NULL") : "NULL";
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(7);
        maxHeap.insert(9);
        maxHeap.insert(8);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.print();
        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.print();
        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.print();
        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.print();
        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.print();
        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.print();
        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.print();
        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.print();
        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.print();
    }
}
