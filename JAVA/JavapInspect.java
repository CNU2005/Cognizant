// Exercise 37: Using javap to Inspect Bytecode
public class JavapInspect {

    public int add(int a, int b) {
        return a + b;
    }

    public int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        JavapInspect demo = new JavapInspect();
        System.out.println("add(3, 4)   = " + demo.add(3, 4));
        System.out.println("square(5)   = " + demo.square(5));
        System.out.println("Now run:  javap -c JavapInspect");
    }
}
