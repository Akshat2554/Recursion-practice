import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Simple Calculator ===");
        System.out.println("Operations: +  -  *  /");
        System.out.println("Enter 'q' to quit.\n");

        while (running) {
            System.out.print("First number: ");
            String firstInput = scanner.nextLine().trim();
            if (firstInput.equalsIgnoreCase("q")) {
                break;
            }

            double first = parseNumber(firstInput, scanner);
            if (Double.isNaN(first)) {
                continue;
            }

            System.out.print("Operator (+, -, *, /): ");
            String operator = scanner.nextLine().trim();
            if (operator.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Second number: ");
            String secondInput = scanner.nextLine().trim();
            if (secondInput.equalsIgnoreCase("q")) {
                break;
            }

            double second = parseNumber(secondInput, scanner);
            if (Double.isNaN(second)) {
                continue;
            }

            Double result = calculate(first, operator, second);
            if (result != null) {
                System.out.println("Result: " + result);
            }
            System.out.println();

            System.out.print("Calculate again? (y/n): ");
            String again = scanner.nextLine().trim();
            if (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("yes")) {
                running = false;
            }
            System.out.println();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    static double parseNumber(String input, Scanner scanner) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Try again.\n");
            return Double.NaN;
        }
    }

    static Double calculate(double a, String operator, double b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    System.out.println("Error: cannot divide by zero.");
                    yield null;
                }
                yield a / b;
            }
            default -> {
                System.out.println("Invalid operator. Use +, -, *, or /.");
                yield null;
            }
        };
    }
}
