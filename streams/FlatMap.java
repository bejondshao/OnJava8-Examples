// streams/FlatMap.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

class Order {
  List<Item> items = new ArrayList<>();
  double total;

  public Order(List<Item> items, double total) {
    this.items = items;
    this.total = total;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}

class Item {
  String name;
  double price;

  int quantity;

  public Item(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}

public class FlatMap {
  public static void main(String[] args) {
    Stream.of(1, 2, 3)
      .flatMap(
        i -> Stream.of("Gonzo", "Fozzie", "Beaker"))
      .forEach(System.out::println);

    List<Order> orders = Arrays.asList(
            new Order(Arrays.asList(new Item("Milk", 2.5, 2), new Item("Bread", 1, 1)), 0),
            new Order(Arrays.asList(new Item("DalsMilk", 3.5, 3), new Item("MiniBread", 0.5, 1)), 0),
            new Order(Arrays.asList(new Item("Beer", 3, 4), new Item("Noddles", 2, 4)), 0));

    List<Double> totals = orders.stream().flatMap(order -> order.getItems().stream()
            .map(item -> item.getPrice() * item.getQuantity())).collect(Collectors.toList());
    System.out.println(totals);
    List<Double> totalsByOrder = orders.stream().map(
            order -> order.getItems().stream()
                    .map(item -> item.getPrice() * item.getQuantity())
                    .reduce(order.getTotal(), Double::sum)).collect(Collectors.toList());
    System.out.println(totalsByOrder);
  }
}
/* Output:
Gonzo
Fozzie
Beaker
Gonzo
Fozzie
Beaker
Gonzo
Fozzie
Beaker
[5.0, 1.0, 10.5, 0.5, 12.0, 8.0]
[6.0, 11.0, 20.0]
*/
