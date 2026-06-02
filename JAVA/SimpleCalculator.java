
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double b = sc.nextDouble();

        System.out.print("Choose an operation (+, -, *, /): ");
        String op = sc.next();

        double result;
        switch (op) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> {
                if (b == 0) {
                    System.out.println("Error: division by zero is not allowed.");
                    sc.close();
                    return;
                }
                result = a / b;
            }
            default -> {
                System.out.println("Invalid operation: " + op);
                sc.close();
                return;
            }
        }

        System.out.printf("Result: %.2f %s %.2f = %.2f%n", a, op, b, result);
        sc.close();
    }
}
