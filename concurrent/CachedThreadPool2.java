// concurrent/CachedThreadPool2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.concurrent.*;
import java.util.stream.*;

public class CachedThreadPool2 {
  public static void main(String[] args) {
    ExecutorService exec =
      Executors.newCachedThreadPool();
    IntStream.range(0, 10)
      .mapToObj(InterferingTask::new)
      .forEach(exec::execute);
    exec.shutdown();
  }
}
/* Output:
0 pool-1-thread-1 127
2 pool-1-thread-3 300
1 pool-1-thread-2 200
3 pool-1-thread-4 400
5 pool-1-thread-6 500
4 pool-1-thread-5 600
8 pool-1-thread-9 700
7 pool-1-thread-8 848
9 pool-1-thread-10 848
6 pool-1-thread-7 948
*/
