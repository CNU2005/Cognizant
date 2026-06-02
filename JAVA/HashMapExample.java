// Exercise 25: HashMap Example
// Objective: Use key-value pairs.
import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();

        System.out.print("How many student entries do you want to add? ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            students.put(id, name);
        }

        System.out.print("\nEnter an ID to look up: ");
        int searchId = sc.nextInt();

        if (students.containsKey(searchId)) {
            System.out.println("Name for ID " + searchId + ": " + students.get(searchId));
        } else {
            System.out.println("No student found with ID " + searchId);
        }

        sc.close();
    }
}
