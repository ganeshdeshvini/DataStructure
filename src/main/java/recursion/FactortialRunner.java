package recursion;

import java.util.HashMap;
import java.util.Map;

public class FactortialRunner {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int number = 5;

        System.out.println(fact(number));
        System.out.println(factDyamicProgramming(number));
        System.out.println("Iterative: " + factIterative(number));
    }

    private static int factDyamicProgramming(int number) {
        if (memo.containsKey(number)) {
            return memo.get(number);
        }
        if (number == 2) {
            memo.put(2, 2);
            return 2;
        }
        return number * fact(number - 1);
    }

    private static int fact(int number) {
        if (number == 2) {
            return 2;
        }
        return number * fact(number - 1);
    }

    private static int factIterative(int number) {
        if (number == 1 || number == 2) {
            return number;
        }

        int product = 1;
        for (int i = 2; i <= number; i++) {
            product = product * i;
        }
        return product;
    }

}
