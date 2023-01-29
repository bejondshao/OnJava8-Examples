// generics/WatercolorSets.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import watercolors.*;
import java.util.*;

import static com.google.common.collect.Sets.*;
import static watercolors.Watercolors.*;

public class WatercolorSets {
  public static void main(String[] args) {
    Set<Watercolors> set1 =
      EnumSet.range(B, H);
    Set<Watercolors> set2 =
      EnumSet.range(E, N);
    System.out.println("set1: " + set1);
    System.out.println("set2: " + set2);
    System.out.println(
      "union(set1, set2): " + union(set1, set2));
    Set<Watercolors> subset = intersection(set1, set2);
    System.out.println(
      "intersection(set1, set2): " + subset);
    System.out.println("difference(set1, subset): " +
      difference(set1, subset));
    System.out.println("difference(set2, subset): " +
      difference(set2, subset));
    System.out.println("complement(set1, set2): " +
      Sets.complement(set1, set2));
  }
}
/* Output:
set1: [B, C, D, E, F, G, H]
set2: [E, F, G, H, I, J, K, L, M, N]
union(set1, set2): [B, C, D, E, F, G, H, I, J, K, L, M, N]
intersection(set1, set2): [E, F, G, H]
difference(set1, subset): [B, C, D]
difference(set2, subset): [I, J, K, L, M, N]
complement(set1, set2): [B, C, D, I, J, K, L, M, N]
*/
