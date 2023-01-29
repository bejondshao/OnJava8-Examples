// generics/Unconstrained.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

class Other {}
class SubOther extends BasicHolder<Other> {}

public class Unconstrained {
  public static void main(String[] args) {
    SubOther b = new SubOther();
    SubOther b2 = new SubOther();
    b.set(new Other());
    Other other = b.get();
    b.print();
  }
}
/* Output:
Other
Other@5305068a
*/
