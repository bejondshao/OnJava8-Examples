// reflection/InterfaceViolation.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Sneaking around an interface
import interfacea.*;

class B implements A {
  @Override public void f() {
    System.out.println("calling B.f()");
  }
  public void g() {
    System.out.println("calling B.g()");
  }
}

public class InterfaceViolation {
  public static void main(String[] args) {
    A a = new B();
    a.f();
    // a.g(); // Compile error
    System.out.println(a.getClass().getName());
    if(a instanceof B) {
      B b = (B)a;
      b.g();
    }
  }
}
/* Output:
B
*/
