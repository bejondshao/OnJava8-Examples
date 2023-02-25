// concurrent/PizzaParallelSteps.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.IntStream;

public class PizzaParallelSteps {
  static final int QUANTITY = 5;
  public static void main(String[] args) {
    Timer timer = new Timer();
    IntStream.range(0, QUANTITY)
      .mapToObj(Pizza::new)
      .parallel()
      .map(Pizza::roll)
      .map(Pizza::sauce)
      .map(Pizza::cheese)
      .map(Pizza::toppings)
      .map(Pizza::bake)
      .map(Pizza::slice)
      .map(Pizza::box)
      .forEach(System.out::println);
    System.out.println(timer.duration());
  }
}
/* Output:
Pizza 1: ROLLED
Pizza 2: ROLLED
Pizza 4: ROLLED
Pizza 3: ROLLED
Pizza 0: ROLLED
Pizza 1: SAUCED
Pizza 2: SAUCED
Pizza 4: SAUCED
Pizza 0: SAUCED
Pizza 3: SAUCED
Pizza 1: CHEESED
Pizza 2: CHEESED
Pizza 4: CHEESED
Pizza 3: CHEESED
Pizza 0: CHEESED
Pizza 1: TOPPED
Pizza 4: TOPPED
Pizza 2: TOPPED
Pizza 3: TOPPED
Pizza 0: TOPPED
Pizza 4: BAKED
Pizza 1: BAKED
Pizza 2: BAKED
Pizza 3: BAKED
Pizza 0: BAKED
Pizza 1: SLICED
Pizza 4: SLICED
Pizza 2: SLICED
Pizza 3: SLICED
Pizza 0: SLICED
Pizza 1: BOXED
Pizza 4: BOXED
Pizza4: complete
Pizza1: complete
Pizza 2: BOXED
Pizza2: complete
Pizza 3: BOXED
Pizza3: complete
Pizza 0: BOXED
Pizza0: complete
16075

BUILD SUCCESSFUL in 17s
4 actionable tasks: 2 executed, 2 up-to-date
1:06:04 PM: Execution finished ':concurrent:PizzaParallelSteps.main()'.

*/
