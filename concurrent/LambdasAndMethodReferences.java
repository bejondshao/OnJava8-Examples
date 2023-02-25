// concurrent/LambdasAndMethodReferences.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.concurrent.*;

class NotRunnable {
  public void go() {
    System.out.println("NotRunnable");
  }
}

class NotCallable {
  public Integer get() {
    System.out.println("NotCallable");
    return 1;
  }
}

public class LambdasAndMethodReferences {
  public static void main(String[] args)
          throws InterruptedException, ExecutionException {
    ExecutorService exec =
      Executors.newCachedThreadPool();
    exec.execute(() -> System.out.println("Lambda1"));
    exec.execute(new NotRunnable()::go);
    Future<Integer> in = exec.submit(() -> {
      System.out.println("Lambda2");
      return 1;
    });
    System.out.println(in.get());
    exec.submit(new NotCallable()::get);
    exec.shutdown();
  }
}
/* Output:
Lambda1
NotRunnable
Lambda2
1
NotCallable
*/
