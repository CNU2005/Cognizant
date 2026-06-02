
import java.util.Scanner;

public class ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int count = sc.nextInt();

        int[] numbers = new int[count];
        int sum = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }

        double average = count == 0 ? 0 : (double) sum / count;
        System.out.println("Sum     = " + sum);
        System.out.printf("Average = %.2f%n", average);

        sc.close();
    }
}
