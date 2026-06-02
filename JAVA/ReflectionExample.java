// Exercise 39: Reflection in Java

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionExample {

    // A simple target class whose methods we'll call via reflection.
    public static class Greeter {
        public String greet(String name) {
            return "Hello, " + name + "!";
        }

        public int multiply(int a, int b) {
            return a * b;
        }
    }

    public static void main(String[] args) {
        try {
            // Load the class by name.
            Class<?> clazz = Class.forName("ReflectionExample$Greeter");
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // List all declared methods with their parameters.
            System.out.println("Declared methods of " + clazz.getSimpleName() + ":");
            for (Method m : clazz.getDeclaredMethods()) {
                StringBuilder sig = new StringBuilder(m.getName() + "(");
                Parameter[] params = m.getParameters();
                for (int i = 0; i < params.length; i++) {
                    sig.append(params[i].getType().getSimpleName());
                    if (i < params.length - 1) sig.append(", ");
                }
                sig.append(")");
                System.out.println("  " + sig);
            }

            // Invoke methods dynamically.
            Method greet = clazz.getMethod("greet", String.class);
            Object result1 = greet.invoke(instance, "Reflection");
            System.out.println("\ngreet(\"Reflection\") -> " + result1);

            Method multiply = clazz.getMethod("multiply", int.class, int.class);
            Object result2 = multiply.invoke(instance, 6, 7);
            System.out.println("multiply(6, 7)        -> " + result2);

        } catch (Exception e) {
            System.out.println("Reflection error: " + e.getMessage());
        }
    }
}
