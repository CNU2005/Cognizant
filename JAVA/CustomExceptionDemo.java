// Exercise 21: Custom Exception
// Objective: Create and use custom exceptions.
// Supporting file: InvalidAgeException.java
import java.util.Scanner;

public class CustomExceptionDemo {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is below 18. Access denied.");
        }
        System.out.println("Age " + age + " is valid. Access granted.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        sc.close();
    }
}
