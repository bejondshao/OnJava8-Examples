// annotations/ifx/Multiplier.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// javac-based annotation processing
// {java annotations.ifx.Multiplier}
package ifx;

@ExtractInterface(interfaceName="IMultiplier")
public class Multiplier {
  public boolean flag = false;
  private int n = 0;
  public int multiply(int x, int y) {
    int total = 0;
    for(int i = 0; i < x; i++)
      total = add(total, y);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(x).append(" * ").append(y).append(" = ").append(total);
    System.out.println(stringBuilder);
    return total;
  }
  public int fortySeven() { return 47; }
  private int add(int x, int y) {
    return x + y;
  }
  public double timesTen(double arg) {
    return arg * 10;
  }
  public static void main(String[] args) {
    Multiplier m = new Multiplier();
    m.multiply(11, 16);
  }
}
/* Output:
11 * 16 = 176
*/
