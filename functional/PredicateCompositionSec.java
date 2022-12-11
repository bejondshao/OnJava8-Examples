// functional/PredicateCompositionSec.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Student {
  String name;
  boolean gender; // true for Female, false for Male
  int age;
  double height;
  double weight;
  String address;

  public Student(String name, boolean gender, int age, double height, double weight, String address) {
    this.name = name;
    this.gender = gender;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            ", gender=" + gender +
            ", age=" + age +
            ", height=" + height +
            ", weight=" + weight +
            ", address='" + address + '\'' +
            '}';
  }
}

public class PredicateCompositionSec {
  static Predicate<Student>
    p1 = s -> s.gender,
    p2 = s -> s.age >= 18,
    p3 = s -> s.height > 160,
    p4 = s -> s.weight > 65,
    p5 = s -> s.address.contains("Beijing"),
    p = p1.negate().and(p2).and(p3).and(p4).or(p5);

  public static void main(String[] args) {
    List<Student> students = Arrays.asList(
            new Student("Lily", true, 19, 170, 67, "Henan"),
            new Student("David", false, 16, 170, 67, "Henan"),
            new Student("Bob", false, 19, 150, 67, "Henan"),
            new Student("Brown", false, 18, 170, 60, "Henan"),
            new Student("Webo", false, 18, 170, 67, "Henan"),
            new Student("G", false, 15, 150, 65, "Beijing Chaoyang")
    );
    students.stream().filter(p).forEach(System.out::println);
  }
}
