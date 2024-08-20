import Stack.Stack;

import java.util.*;

public class ArithmeticExpression {
    public static int compute(String expression) {
        // Create a new stack, insert at front of linked list, remove at front
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        List<String> available = Arrays.asList("*", "-", "+", "/", "^");

        Scanner scanner = new Scanner(expression);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                stack.offerFirst(Integer.parseInt(scanner.next()));
            } else {
                String nextChar = scanner.next();
                if (!available.contains(nextChar)) {
                    throw new IllegalArgumentException();
                } else {
                    if (stack.size() < 2) {
                        throw new IllegalArgumentException();
                    }

                    int first = stack.pollFirst();

                    int second = stack.pollFirst();

                    result = calculate(second, first, nextChar);

                    stack.push(result);
                }
            }
        }
        scanner.close();
        if (stack.size() != 1) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private static int calculate(int a, int b, String c) {
        switch (c) {
            case "+":
                return a+b;
            case "*":
                return a * b;
            case "-":
                return a - b;
            case "/":
                return a/b;
            default:
                return (int) Math.pow(a, b);
        }
    }

    public static void main(String[] args) {
        String input = "10 2 8 *";
        int expected = 7;
        System.out.println(compute(input));
    }
}
