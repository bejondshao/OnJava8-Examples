// generics/ComparablePet.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class ComparablePet
implements Comparable<ComparablePet> {
  private double weight;
  @Override
  public int compareTo(ComparablePet arg) {
    return Double.compare(weight, arg.weight);
  }
}
