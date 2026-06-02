// Exercise 29: Records (Java 16+)
import java.util.List;
import java.util.stream.Collectors;

public class RecordsExample {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        Person alice = new Person("Alice", 30);
        Person bob = new Person("Bob", 17);
        System.out.println(alice);
        System.out.println(bob);

        // Access components.
        System.out.println(alice.name() + " is " + alice.age() + " years old.");

        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 17),
                new Person("Charlie", 25),
                new Person("Diana", 16)
        );

        // Filter adults (age >= 18) using Streams.
        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("\nAdults (18+):");
        adults.forEach(System.out::println);
    }
}
