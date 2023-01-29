// arrays/MultidimensionalPrimitiveArray.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;

public class MultidimensionalPrimitiveArray {
  public static void main(String[] args) {
    int[][] a = {
      { 1, 2, 3, },
      { 4, 5, 6, },
    };
    System.out.println(Arrays.deepToString(a));
    System.out.println(a[1][2]); // row 1 + 1, column 2 + 1, which is 6
  }
}
/* Output:
[
[1, 2, 3],
 [4, 5, 6]
 ]
 6
*/
