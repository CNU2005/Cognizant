// Exercise 17: Class and Object Creation
// Objective: Understand classes and objects.
public class ClassAndObjectCreation {

    static class Car {
        String make;
        String model;
        int year;

        Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        void displayDetails() {
            System.out.println(year + " " + make + " " + model);
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2021);
        Car car2 = new Car("Tesla", "Model 3", 2023);

        car1.displayDetails();
        car2.displayDetails();
    }
}
