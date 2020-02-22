package helpers;

public class Util {
    public static void swap(int[] arrInput, int srcIndex, int destIndex) {
        int temp = arrInput[srcIndex];
        arrInput[srcIndex] = arrInput[destIndex];
        arrInput[destIndex] = temp;
    }

    public static void swap(Integer[] arrInput, int srcIndex, int destIndex) {
        int temp = arrInput[srcIndex];
        arrInput[srcIndex] = arrInput[destIndex];
        arrInput[destIndex] = temp;
    }
}
