
public class TypeCastingExample {
    public static void main(String[] args) {
       
        double myDouble = 9.78;
        int castedInt = (int) myDouble;
        System.out.println("double " + myDouble + " cast to int = " + castedInt);

      
        int myInt = 5;
        double castedDouble = (double) myInt;
        System.out.println("int " + myInt + " cast to double = " + castedDouble);
    }
}
