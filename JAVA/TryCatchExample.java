// Exercise 20: Try-Catch Example
// Objective: Handle exceptions gracefully.
import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int a = sc.nextInt();

        System.out.print("Enter the second integer: ");
        int b = sc.nextInt();

        try {
            int result = a / b;
            System.out.println(a + " / " + b + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: cannot divide by zero.");
        }

        sc.close();
    }
}
