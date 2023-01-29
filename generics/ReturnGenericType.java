// generics/ReturnGenericType.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class ReturnGenericType<T extends HasF> {
  private T obj;
  ReturnGenericType(T x) { obj = x; }
  public T get() { return obj; }

  public static void main(String[] args) {
    ReturnGenericType<HasF> type1 = new ReturnGenericType<>(new HasF());
    ReturnGenericType<SubHasF> type2 = new ReturnGenericType<>(new SubHasF(2));
    HasF type1t = type1.get();
    type1t.f();
    SubHasF type2t = type2.get();
    type2t.f();
    System.out.println("a of SubHasF: " + type2t.getA());
  }
}
/**
 * HasF.f()
 * SubHasF.f()
 * a of SubHasF: 2
 */
