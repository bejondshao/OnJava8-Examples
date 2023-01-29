// enumerations/PetPatternMatch2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {NewFeature} Preview in JDK 17
// Compile with javac flags:
//   --enable-preview --source 17
import java.util.*;

sealed interface Pet1 {
  void feed();
}

final class Dog1 implements Pet1 {
  @Override public void feed() {}
  void walk() {}
}

final class Fish1 implements Pet1 {
  @Override public void feed() {}
  void changeWater() {}
}

public class PetPatternMatch2 {
  static void careFor(Pet1 p) {
    switch(p) {
      case Dog1 d -> d.walk();
      case Fish1 f -> f.changeWater();
    };
  }
  static void petCare() {
    List.of(new Dog1(), new Fish1())
      .forEach(p -> careFor(p));
  }
}
