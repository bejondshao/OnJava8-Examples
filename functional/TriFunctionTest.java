// functional/TriFunctionTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class TriFunctionTest {
  static int f(int i, long l, double d) { return 99; }
  public static void main(String[] args) {
    TriFunction<Integer, Long, Double, Integer> tf =
      TriFunctionTest::f;
    TriFunction<Integer, Long, Double, Integer> tf2 = (i, l, d) -> 12;
    int c = tf.apply(1, 1L, 2D);
    int c2 = tf2.apply(1, 1L, 2D);
    System.out.println(c);
    System.out.println(c2);
  }
}
