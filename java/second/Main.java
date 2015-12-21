import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Main{

    public static void main(String[] args) {
        boolean trivial = false;
        boolean minus = false;
        boolean outOfRange = false;
        if (args.length == 0) {
            System.err.println("No program arguments given!");
            System.err.println("Program does factorization to primes.");
            System.err.println("Simply add some numbers at the end " +
            "of your console enry when you run this program.");
        }
        else {
            long number = 0;
            for (String arg : args){
                trivial = true;
                minus = false;
                if (arg.equals("0"))
                    System.out.println("0 = 0");
                else if (arg.equals("1"))
                    System.out.println("1 = 1");
                else if (arg.equals("-1"))
                    System.out.println("-1 = -1");
                else if (arg.equals("−9223372036854775808")){
                    outOfRange = true;
                    minus = true;
                    number = new Long(4611686018427387904L);
                }
                else if (arg.charAt(0) == '-'){
                    outOfRange = false;
                    trivial = false;
                    minus = true;
                    number = new Long(arg.substring(1)); 
                }
                else {
                    outOfRange = false;
                    trivial = false;
                    number = new Long(arg);
                }

                if (trivial == false) {
                    PrimeNumbers pn = new PrimeNumbers();
                    List<Long> factorials = new ArrayList<Long>();
                    factorials = pn.factorizationFinal(number);

                    boolean first = true;
                    System.out.print(number + " = ");
                    if (minus == true)
                        System.out.print("-1 * ");
                    if (outOfRange == true)
                        System.out.print("2 * ");
                    for (Long i : factorials){
                        if (i == (factorials.get(0)) && first == true){
                            System.out.print(i);
                            first = false;
                        }
                        else
                            System.out.print(" * " + i);

                    }

                    System.out.println();
                }
            }
        }
            
           
        
    }
}
