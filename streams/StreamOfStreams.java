// streams/StreamOfStreams.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.stream.*;

public class StreamOfStreams {
  public static void main(String[] args) {
    Stream.of(1, 2, 3).parallel()
      .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
      .map(Stream::findAny)
      .forEach(System.out::println);
  }
}
/* Output:
Optional[Gonzo]
Optional[Gonzo]
Optional[Gonzo]
*/
