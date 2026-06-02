
public class OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;       
        int result2 = (10 + 5) * 2;     
        int result3 = 100 / 10 / 2;     
        int result4 = 10 + 20 % 7;      
        boolean result5 = 5 > 3 && 2 < 1 || 4 == 4; 

        System.out.println("10 + 5 * 2          = " + result1 + "  (* evaluated before +)");
        System.out.println("(10 + 5) * 2        = " + result2 + "  (parentheses evaluated first)");
        System.out.println("100 / 10 / 2        = " + result3 + "   (division is left-to-right)");
        System.out.println("10 + 20 % 7         = " + result4 + "  (% evaluated before +)");
        System.out.println("5>3 && 2<1 || 4==4  = " + result5 + " (&& before ||)");

        System.out.println();
        System.out.println("Order of operations (high to low): "
                + "parentheses > * / % > + - > relational > && > ||");
    }
}
