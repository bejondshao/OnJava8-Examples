// generics/GenericCast.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.*;
import java.util.stream.*;

class FixedSizeStack<T> {
  private final int size;
  private Object[] storage;
  private int index = 0;
  FixedSizeStack(int size) {
    this.size = size;
    storage = new Object[size];
  }
  public void push(T item) {
    if(index < size)
      storage[index++] = item;
  }
  @SuppressWarnings("unchecked")
  public T pop() {
    T t = index == 0 ? null : (T)storage[--index];
    storage[index] = null;
    return t;
  }
  @SuppressWarnings("unchecked")
  Stream<T> stream() {
    return (Stream<T>)Arrays.stream(storage);
  }
}

public class GenericCast {
  static String[] letters =
    "ABCDEFGHIJKLMNOPQRS".split("");
  public static void main(String[] args) {
    FixedSizeStack<String> strings =
      new FixedSizeStack<>(letters.length);
    Arrays.stream(letters)
      .forEach(strings::push);
    System.out.println(strings.pop());
    System.out.println(strings.pop());
    System.out.println(strings.pop());
    strings.stream().filter(Objects::nonNull).sorted(Comparator.reverseOrder())
      .map(s -> s + " ")
      .forEach(System.out::print);
  }
}
/* Output:
S
R
Q
P O N M L K J I H G F E D C B A
*/
