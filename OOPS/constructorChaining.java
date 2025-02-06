// Constructor Chaining in Java refers to the process of calling
//  one constructor from another constructor within 
// the same class or a superclass. It is primarily used to reuse code 
// between multiple constructors, reducing redundancy and ensuring
//  consistent object initialization.

// Types of Constructor Chaining:
// Within the same class: 
// One constructor calls another constructor 
// in the same class using the this() keyword.
// Between superclass and subclass:
//  A subclass constructor calls the superclass constructor
//   using the super() keyword.
// Purpose of Constructor Chaining:
// To avoid code duplication.
// To ensure proper initialization of object properties.
// To maintain a clear and efficient constructor structure.

class Vehicle {
    String brand;
    int wheels;

    // Constructor 1
    public Vehicle() {
        this("Unknown", 4); // Calls Constructor 2
        System.out.println("Default constructor called.");
    }

    // Constructor 2
    public Vehicle(String brand) {
        this(brand, 4); // Calls Constructor 3
        System.out.println("Single parameter constructor called.");
    }

    // Constructor 3
    public Vehicle(String brand, int wheels) {
        this.brand = brand;
        this.wheels = wheels;
        System.out.println("Two parameter constructor called.");
    }

    public void display() {
        System.out.println("Vehicle Brand: " + brand + ", Wheels: " + wheels);
    }
}

public class constructorChaining{
    public static void main(String[] args) {
        // Creating object using different constructors
        Vehicle vehicle1 = new Vehicle();        // Default constructor
        Vehicle vehicle2 = new Vehicle("Toyota"); // Single parameter constructor
        Vehicle vehicle3 = new Vehicle("Honda", 2); // Two parameter constructor

        // Display the vehicle details
        vehicle1.display();
        vehicle2.display();
        vehicle3.display();
    }
}
