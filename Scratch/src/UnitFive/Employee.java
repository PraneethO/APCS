
import java.util.Date;

public class Employee {
    // name, birthdate, position, salary
    // Data should be private
    // Functions are *typically* public (unless specifically states private)

    // Instance Data
    // If no data given to instance data, JRE auto gives data default values
    private String name;
    private Date birthdate;
    private String position;
    private double salary;

    public Employee(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        position = "";
        salary = 0;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Date getBirthDate() {
        return birthdate;
    }

    public void setSalary(double s) {
        if (s < 0) {
            throw new IllegalArgumentException();
        }

        salary = s;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String pos) {
        position = pos;
    }

    public void setBirthdate(Date d) {
        birthdate = d;
    }

    public boolean equals(Object o) {
        Employee e = (Employee) o; // if o was not an employee, we get

        return this.position.equals(e.position) && this.salary == e.salary;

    }

    public String toString() {
        return "Name: " + name + "\nPosition: " + position;
    }

}

/*
 * class - a blueprint for how an Object of this type will work
 * 
 * 1. attributes (characteristics/instance data)
 * 2. constructor(s) - special methods that allow the user to instantiate
 * (create)
 * an object of this type
 * 3. other functions - accessors (getters) and mutators (setters)
 * 
 * ATTRIBUTES
 * private - accessible directly (using the dot operator) only in this class
 * protected - accessible directly inside this class, in any direct subclasses
 * of this class
 * and in any class in the same package as this class
 * public - accessible directly from any class
 * 
 * instance data should be private (unless you have a good reason to make it
 * protected)
 * instance data should never be public (only class constants should be public)
 * 
 * CONSTRUCTORS
 * the job of a constructor is to initialize instance data
 * 
 * if you don't define any constructors, the JRE will provide the default
 * constructor
 * as soon as you define a constructor, the default is no longer provided
 * 
 * default constructor - empty parameter list - initializes instance data to
 * default values
 * 
 * OTHER FUNCTIONS
 * accessors - functions that allow the client to access the value(s) of
 * instance data
 * mutators - functions that allow the client to change the value(s) of instance
 * data
 * but on our terms
 */