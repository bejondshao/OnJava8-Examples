// functional/TransformFunction.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.function.*;

class I {
  @Override public String toString() { return "I"; }
}

class O {
  @Override public String toString() { return "O"; }
}

class V {
  @Override public String toString() { return "V"; }
}

public class TransformFunction {
  static Function<I,O> transform(Function<I,V> in) { /* a public used function "transform", input "I" output "O". But it's not friendly
     for inside business, the inside function is "in", which input "I" output "V". So the work is to create a function that
     input "V" output "O", in order to use function "in". */
    return in.andThen(v -> {
      System.out.println(v);
      return new O();
    });
  }

  static Function<I,O> prepare(Function<V,O> in) { /* a public used function "prepare", input "I" output "O". But it's not friendly
     for inside business, the inside function is "in", which input "V" output "O". So the work is to create a function that
     input "I" output "V", in order to use function "in". */
    return in.compose(i -> {
      System.out.println("Before: " + i);
      return new V();
      }
    );
  }

  static Function<I,V> temp = i -> {System.out.println("Before: " + i); return new V();};
  static Function<I,O> prepare2(Function<V,O> in) {
    return in.compose(temp);
  }

  public static void main(String[] args) {
    Function<I,O> f2 = transform(i -> {
      System.out.println(i);
      return new V();
    });
    O o = f2.apply(new I());
    Function<I,O> f3 = prepare2(i -> {System.out.println("i is: " + i);
      return new O();
    });
  }
}
/* Output:
I
O
*/
