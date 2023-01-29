// generics/TupleTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class TupleTest {
  static Tuple2<String, Integer> f() {
    // Autoboxing converts the int to Integer:
    return new Tuple2<>("hi", 47);
  }
  static Tuple3<Amphibian, String, Integer> g() {
    return new Tuple3<>(new Amphibian(), "hi", 47);
  }
  static
  Tuple4<Vehicle, Amphibian, String, Integer> h() {
    return
      new Tuple4<>(
        new Vehicle(), new Amphibian(), "hi", 47);
  }
  static
  Tuple5<Vehicle, Amphibian,
         String, Integer, Double> k() {
    return new
      Tuple5<>(
        new Vehicle(), new Amphibian(), "hi", 47, 11.1);
  }
  public static void main(String[] args) {
    Tuple2<String, Integer> ttsi = f();
    System.out.println(ttsi);
    // ttsi.a1 = "there"; // Compile error: final
    Tuple3<Amphibian, String, Integer> tuple3 = g();
    System.out.println(tuple3.a1);
    System.out.println(tuple3.a2);
    System.out.println(tuple3.a3);
    System.out.println(h());
    System.out.println(k());
  }
}
/* Output:
(hi, 47)
Amphibian@3a71f4dd
hi
47
(Vehicle@65b54208, Amphibian@1be6f5c3, hi, 47)
(Vehicle@5b2133b1, Amphibian@72ea2f77, hi, 47, 11.1)
*/
