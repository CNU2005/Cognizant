// Exercise 27: Lambda Expressions
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(List.of("Banana", "Apple", "Cherry", "Mango", "Date"));

        System.out.println("Original list: " + fruits);

        // Sort alphabetically using a lambda comparator.
        Collections.sort(fruits, (a, b) -> a.compareTo(b));
        System.out.println("Sorted (A-Z) : " + fruits);

        // Sort by length, then reverse alphabetical, to show another lambda.
        fruits.sort((a, b) -> b.compareTo(a));
        System.out.println("Sorted (Z-A) : " + fruits);
    }
}
