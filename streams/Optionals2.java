// streams/Optionals2.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Car {
    Wheel wheel;
    List<Wheel> groundWheels;

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public List<Wheel> getGroundWheels() {
        return groundWheels;
    }

    public void setGroundWheels(List<Wheel> groundWheels) {
        this.groundWheels = groundWheels;
    }
}

class Wheel {
    String brand;

    public Wheel(String brand) {
        this.brand = brand;
    }

    public Wheel() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

public class Optionals2 {

    public static void main(String[] args) {
        Car car1 = null;
        Car car2 = new Car();
        Car car3 = new Car();
        Wheel wheel3 = new Wheel();
        car2.wheel = wheel3;
        Car car4 = new Car();
        Wheel wheel4 = new Wheel();
        wheel4.brand = "ABC";
        car3.wheel = wheel4;

        Car car5 = new Car();
        List<Wheel> wheels = new ArrayList<>();
        car5.setGroundWheels(wheels);

        List<Car> cars = Arrays.asList(car1, car2, car3, car4, car5);
        for (Car car : cars) {
            if (Optional.ofNullable(car).map(Car::getWheel).isPresent()) {
                System.out.println("Printing...");
                System.out.println(car.getWheel().getBrand());
            }
        }

        System.out.println("----------------------");

        cars.stream().filter(car -> Optional.ofNullable(car).map(Car::getWheel).isPresent())
                .forEach(car -> System.out.println(car.getWheel().getBrand()));

        System.out.println("++++++++++++++++++++++");
        if (Optional.ofNullable(car5).map(Car::getGroundWheels).isPresent()) {
            System.out.println("GroundWheels is present.");
            System.out.println("The car has " + car5.getGroundWheels().size() + " ground wheels.");
            Optional<Wheel> wheelOp = car5.getGroundWheels().stream().findFirst();
            wheelOp.ifPresent(wheel -> System.out.println(wheel.getBrand()));
        }
    }
}
/*
Printing...
null
Printing...
ABC
----------------------
null
ABC
 */
