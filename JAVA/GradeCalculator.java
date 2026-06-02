

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks (out of 100): ");
        int marks = sc.nextInt();

        char grade;
        if (marks >= 90 && marks <= 100) {
            grade = 'A';
        } else if (marks >= 80) {
            grade = 'B';
        } else if (marks >= 70) {
            grade = 'C';
        } else if (marks >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        if (marks < 0 || marks > 100) {
            System.out.println("Warning: marks should be between 0 and 100.");
        } else {
            System.out.println("Grade: " + grade);
        }

        sc.close();
    }
}
