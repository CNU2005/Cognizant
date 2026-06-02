// Exercise 38: Decompile a Class File
public class DecompileDemo {

    private final String label;

    public DecompileDemo(String label) {
        this.label = label;
    }

    public int sumUpTo(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) {
        DecompileDemo demo = new DecompileDemo("demo");
        System.out.println(demo.label + ": sum 1..10 = " + demo.sumUpTo(10));
    }
}
