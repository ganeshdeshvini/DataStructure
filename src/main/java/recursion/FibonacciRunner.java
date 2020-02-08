package recursion;

public class FibonacciRunner {
    public static void main(String[] args) {
        //0, 1, 1, 2, 3, 5, 8, 13, 21
        int number = 8;
        System.out.println("Iterative: " + fibonacciIterative(number));
        System.out.println("Recursive: " + fibonacciRecursive(number));
    }

    private static int fibonacciRecursive(int number) {
        if (number <= 1) {
            return number;
        }
        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }

    private static int fibonacciIterative(int number) {
        if (number == 0) {
            return 0;
        }

        int firstNumber = 0;
        int secondNumber = 1;
        int fiboResult = 1;

        for (int i = 2; i <= number; i++) {
            fiboResult = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = fiboResult;
        }
        return fiboResult;
    }
}
