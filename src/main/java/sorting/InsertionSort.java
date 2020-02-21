package sorting;

import java.util.Arrays;

import static helpers.Util.swap;

public class InsertionSort {
    private static void insertionSort(int[] arrInput) {
        int size = arrInput.length;
        for (int i = 1; i < size; i++) {
            int j = i - 1;
            int valueToCompare = arrInput[i];
            for (; j >= 0; j--) {
                if (valueToCompare > arrInput[j]) {
                    break;
                } else {
                    swap(arrInput, j + 1, j);
                }
            }
        }
    }

    private static void insertionSortMethod2(int[] arrInput) {
        int size = arrInput.length;
        for (int i = 1; i < size; i++) {
            int j = i - 1;
            int valueToCompare = arrInput[i];
            for (; j >= 0 && valueToCompare < arrInput[j]; j--) {
                arrInput[j + 1] = arrInput[j];
            }
            arrInput[j + 1] = valueToCompare;
        }
    }

    public static void main(String[] args) {
        int[] arrInput = {9, 5, 1, 4, 3};
//        insertionSort(arrInput);
        insertionSortMethod2(arrInput);
        System.out.println(Arrays.toString(arrInput));
    }
}
