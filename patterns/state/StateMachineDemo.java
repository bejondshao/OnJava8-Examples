// patterns/state/StateMachineDemo.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The State Machine pattern.
// {java patterns.state.StateMachineDemo}
package state;
import java.util.*;


interface State1 {
  void run();
}

abstract class StateMachine {
  protected State1 currentState;
  protected abstract boolean changeState();
  // Template method:
  protected final void runAll() {
    while(changeState())
      currentState.run();
  }
}

// A different subclass for each state:

class Wash implements State1 {
  @Override public void run() {
    System.out.println("Washing");
    new Nap(0.5);
  }
}

class Spin implements State1 {
  @Override public void run() {
    System.out.println("Spinning");
    new Nap(0.5);
  }
}

class Rinse implements State1 {
  @Override public void run() {
    System.out.println("Rinsing");
    new Nap(0.5);
  }
}

class Washer extends StateMachine {
  private int i = 0;
  private Iterator<State1> states =
    Arrays.asList(
      new Wash(), new Spin(),
      new Rinse(), new Spin()
    ).iterator();
  Washer() { runAll(); }
  @Override public boolean changeState() {
    if(!states.hasNext())
      return false;
    // Set the surrogate reference
    // to a new State object:
    currentState = states.next();
    return true;
  }
}

public class StateMachineDemo {
  public static void main(String[] args) {
    new Washer();
  }
}
/* Output:
Washing
Spinning
Rinsing
Spinning
*/
