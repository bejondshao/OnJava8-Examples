// concurrent/ThrowsChecked.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ThrowsChecked {
    class Checked extends Exception {
    }

    static ThrowsChecked nochecked(ThrowsChecked tc) {
        System.out.println("nochecked. " + tc);
        return tc;
    }

    static ThrowsChecked
    withchecked(ThrowsChecked tc) throws Checked {
        System.out.println("checked. " + tc);
        return tc;
    }

    static void testStream() {
        Stream.of(new ThrowsChecked())
                .map(ThrowsChecked::nochecked)
                // .map(ThrowsChecked::withchecked);        // [1]
                .map(tc -> {
                    try {
                        return withchecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    static void testCompletableFuture() {
        CompletableFuture
                .completedFuture(new ThrowsChecked())
                .thenApply(ThrowsChecked::nochecked)
                // .thenApply(ThrowsChecked::withchecked);  // [2]
                .thenApply(tc -> {
                    try {
                        return withchecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public static void main(String[] args) {
        testStream();
        testCompletableFuture();
    }
}

/**
 * nochecked. ThrowsChecked@33c7353a
 * checked. ThrowsChecked@33c7353a
 */