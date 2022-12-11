// functional/Curry3Args.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.function.*;

public class Curry3Args {
   public static void main(String[] args) {
      Function<String,
        Function<String,
          Function<String, String>>> sum =
            a -> (b -> (c -> a + b + c));
      Function<String,
        Function<String, String>> hi =
          sum.apply("Hi "); /* sum.apply("Hi ") means input "Hi ",
           output Function<String, Function<String, String>>, assign to function "hi" */
      Function<String, String> ho =
        hi.apply("Ho "); /* hi.apply("Ho ") means input "Ho ",
        output Function<String, String>, assign to function "ho" */
      System.out.println(ho.apply("Hup")); /* ho.apply("Hup") means input "Hup",
       output String, the result is a + b + c */
   }
}
/* Output:
Hi Ho Hup
*/
