package sorting;

import helpers.Util;

import java.util.Arrays;

public class BubbleSort {
    static void bubbleSort(int[] arrInput) {
        int size = arrInput.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arrInput[j] > arrInput[j + 1]) {
                    Util.swap(arrInput, j, j + 1);
                }
            }
        }
    }

    static void bubbleSortOptimized(int[] arrInput) {
        boolean isSwapped = true;
        while (isSwapped) {
            isSwapped = false;
            int pass = 0;
            for (int j = 0; j < arrInput.length - 1 - pass; j++) {
                if (arrInput[j] > arrInput[j + 1]) {
                    Util.swap(arrInput, j, j + 1);
                    isSwapped = true;
                }
            }
            pass++;
            if (!isSwapped) {
                System.out.println("No need to iterate further as it is Sorted");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrInput = {-2, 45, 0, 11, -9};
        bubbleSortOptimized(arrInput);
        System.out.println(Arrays.toString(arrInput));
    }
}
