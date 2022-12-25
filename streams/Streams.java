// streams/Streams.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Streams {
    public static void main(String[] args) {
        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three"); /* this happens before collect(), so it can be added to list, but it's not a good manner */
        String s = sl.collect(joining(" "));
        System.out.println(s);
        System.out.println(l);
    }
}

/*
one two three
[one, two, three]
 */