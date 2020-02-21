package sorting;

import java.util.Arrays;

import static helpers.Util.swap;

public class SelectionSort {
    private static void selectionSort(int[] arrInput) {
        int size = arrInput.length;
        int minimumIndex;
        int minimum;
        for (int i = 0; i < size; i++) {
            minimumIndex = i;
            minimum = arrInput[minimumIndex];
            for (int j = i; j < size; j++) {
                if (arrInput[j] < minimum) {
                    minimumIndex = j;
                    minimum = arrInput[minimumIndex];
                }
            }
            if (i != minimumIndex) {
                swap(arrInput, i, minimumIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] arrInput = {20, 12, 10, 15, 2};
        selectionSort(arrInput);
        System.out.println(Arrays.toString(arrInput));
    }
}
