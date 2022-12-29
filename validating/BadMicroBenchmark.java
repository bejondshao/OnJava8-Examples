// validating/BadMicroBenchmark.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {ExcludeFromTravisCI}
import java.util.*;

public class BadMicroBenchmark {
  static final int SIZE = 500_000_000;
  public static void main(String[] args) {
    try { // For machines with insufficient memory
      long[] la = new long[SIZE];
      System.out.println("setAll: " +
        Timer.duration(() ->
          Arrays.setAll(la, n -> n)));
      System.out.println("parallelSetAll: " +
        Timer.duration(() ->
          Arrays.parallelSetAll(la, n -> n)));
    } catch(OutOfMemoryError e) {
      System.out.println("Insufficient memory");
      System.exit(0);
    }
  }
}
/* Output:
setAll: 708
parallelSetAll: 483
*/
/*
setAll: 392
parallelSetAll: 319
 */
/*
setAll: 335
parallelSetAll: 312
 */
/*
Now days, machine performance is more powerful than when the book was written.
For 250_000_000 size, parallel is little slower than sequential.
For 500_000_000 size, parallel is faster than sequential.
Anyway, like the book said, the benchmark here is not ideal. It's affected by JVM state, is not accurate.
 */