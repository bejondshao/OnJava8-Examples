// concurrent/CompletedMachina.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.concurrent.*;

public class CompletedMachina {
  public static void main(String[] args) {
    CompletableFuture<Machina> cf =
      CompletableFuture.completedFuture(
        new Machina(0));
    try {
      Machina m = cf.get();  // Doesn't block
      System.out.println(m);
      cf.thenApply(Machina::work);
      cf.thenApply(Machina::work);
    } catch(InterruptedException |
            ExecutionException e) {
      throw new RuntimeException(e);
    }
  }
}

/**
 * Machina0: START
 * Machina0: ONE
 * Machina0: TWO
 */