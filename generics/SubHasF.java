// generics/HasF.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class SubHasF extends HasF {
  private int a;
  public void f() {
    System.out.println("SubHasF.f()");
  }

  /**
   * Even though we can change access level of override methods, it's not
   * suggested. Why not create a brand-new method name?
   */
  public void g() {
    System.out.println("SubHasF.g()");
  }

  public SubHasF(int a) {
    this.a = a;
  }

  public int getA() {
    return a;
  }

  public void setA(int a) {
    this.a = a;
  }
}
