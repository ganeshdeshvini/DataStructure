package sorting;

import helpers.Util;

import java.util.Arrays;

import static helpers.Util.swap;

public class QuickSort {
    static void quickSort(int[] arrInput, int start, int end) {
        int diff = end - start;
        int startBackup = start;

        if (diff == 1) {
            //If it contains only 2 elements then directly sort them
            if (arrInput[start] > arrInput[end]) {
                swap(arrInput, start, end);
            }
            return;
        }
        if (diff < 1) {
            return;
        }
        int pivot = arrInput[end];
        int indexCnt = start;
        while (start < end) {
            if (arrInput[start] < pivot) {
                swap(arrInput, start, indexCnt);
                indexCnt++;
            }
            start++;
        }
        //finally swap with the Pivot, bring it to the middle
        swap(arrInput, indexCnt, end);
        quickSort(arrInput, startBackup, indexCnt - 1);
        quickSort(arrInput, indexCnt + 1, end);
    }


    public static void main(String[] args) {
        int[] arrInput = {8, 7, 6, 1, 0, 9, 2};
        quickSort(arrInput, 0, arrInput.length - 1);
        System.out.println(Arrays.toString(arrInput));
    }
}