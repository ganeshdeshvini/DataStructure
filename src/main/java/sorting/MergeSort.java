package sorting;

import java.util.Arrays;

import static helpers.Util.swap;

public class MergeSort {
    private static void mergeSort(int[] arrInput) {
        int size = arrInput.length;
        int mid = size / 2;
        if (size == 2) {
            if (arrInput[0] > arrInput[1]) {
                swap(arrInput, 0, 1);
            }
        }
        if (size == 1) {
            return;
        }
        int[] arrLeft = Arrays.copyOfRange(arrInput, 0, mid);
        int[] arrRight = Arrays.copyOfRange(arrInput, mid, size);
        mergeSort(arrLeft);
        mergeSort(arrRight);
        merge2SortedArrays(arrInput, arrLeft, arrRight);
    }

    private static void merge2SortedArrays(int[] arrInput, int[] arrLeft, int[] arrRight) {
        int leftSize = arrLeft.length;
        int rightSize = arrRight.length;
        int leftPtr = 0;
        int rightPtr = 0;
        int sortedIndex = 0;
        while (leftPtr < leftSize || rightPtr < rightSize) {
            // If right array is finished then go to else part
            // If Left array is finished then skip & move to else part
            if (isArrayCompleted(rightPtr, rightSize) || (!isArrayCompleted(leftPtr, leftSize) && arrLeft[leftPtr] < arrRight[rightPtr])) {
                arrInput[sortedIndex] = arrLeft[leftPtr];
                leftPtr++;
            } else {
                arrInput[sortedIndex] = arrRight[rightPtr];
                rightPtr++;
            }
            sortedIndex++;
        }
    }

    static boolean isArrayCompleted(int ptr, int size) {
        return ptr >= size;
    }

    public static void main(String[] args) {
        int[] arrInput = {3, 44, 38, 5, 47, 3, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        int[] arrInput = {3, 44, 38, 5, 47, 15, 36, 26};
        mergeSort(arrInput);
        System.out.println(Arrays.toString(arrInput));
    }
}
