// Exercise 30: Pattern Matching for switch (Java 21)
// Objective: Simplify conditional logic with pattern matching in switch expressions.''
public class PatternMatchingSwitch {

    static String describe(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer with value " + i;
            case String s  -> "String of length " + s.length() + ": \"" + s + "\"";
            case Double d  -> "Double with value " + d;
            case null      -> "It's null";
            default        -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }

    public static void main(String[] args) {
        Object[] items = {42, "Hello", 3.14, 'c', null};
        for (Object item : items) {
            System.out.println(describe(item));
        }
    }
}
