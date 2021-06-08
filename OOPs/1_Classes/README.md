## 1. Classes and Objects

<p align="center">
  <img width="475" src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/4.png" />
  <img width="475" src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/5.png" />
</p>

## 2. Creating Classes and Objects

Similar way you create Node and all in Trees

```
public class TestBox {
    public String text;

    public void setText(String text) {
        this.text = text;
    }
}

------------Ans For Creating Objects------------

TextBox textBox1 = new TextBox();
textBox1.setText("Box 1");
System.out.println(testBox1.text);
```

## 3. Memory Allocation

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/6.png" />

```
var textBox1 = new TextBox();
var textBox2 = new TextBox();
textBox2.setText("Hello World");
System.out.println(testBox1.text);
```

This will print "Hello World",

• Java runtime will see "new TextBox()" and will align a TextBox() in Heap area <br/>
• Now, both textBox1, textBox2 will be pushed in Stack area (both are referencing the same address) <br/>
• As soon as the execution finishes, both textBox1, textBox2 will be removed from Stack area <br/>
• Now, TextBox() is in Heap area and Java's garbage collector will remove this from memory.

## 4. Encapsulation

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/7.png" />

```
------------Main.java------------

Employee employee = new Employee();
employee.baseSalary() = 50000;
employee.hourlySalary() = 200;

int wage = employee.calculateWage(20);
System.out.println(wage);

------------Employee.java------------

public class Employee{
  public int baseSalary;
  public int hourlyRate;

  public int calculateWage(int extraHours){
    return baseSalary + (hourlyRate*extraHours);
  }
}
```

## 5. Abstraction

(Example:- TV Remote)

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/8.png" />

## 6. Coupling

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/9.png" />

Make sendHttpRequest, findIpAddress private cause they are of no meaning to a user.

```
------------Main.java------------

Browser browser = new Browser();
browser.navigate("127.0.0.1");

------------Browser.java------------

public class Browser {
  public void navigate(String address) {
    String ip = findIpAddress(address);
    String html = sendHttpRequest(ip);
    System.out.println(html);
  }

  private String sendHttpRequest(String ip) {
    return "<html></html>";
  }

  private String findIpAddress(String address) {
    return "127.0.0.1";
  }
}
```

## 7. Constructors

```
------------Main.java------------

Employee employee = new Employee(50000, 20);

int wage = employee.calculateWage(20);
System.out.println(wage);

------------Employee.java------------

public class Employee{
  public int baseSalary;
  public int hourlyRate;

  // Constructor
  public Employee(int baseSalary, int hourlyRate) {
    this.baseSalary = baseSalary;
    this.hourlyRate = hourlyRate;
  }

  public int calculateWage(int extraHours){
    return baseSalary + (hourlyRate*extraHours);
  }
}
```

Btw, new Employee() is also a constructor and Java runtime will take all default values for it.4

## 8. Method Overloading

Same functions with same name but with different paramaters

```
------------Main.java------------

Employee employee = new Employee(50000, 20);

// int wage = employee.calculateWage(20);
int wage = employee.calculateWage(); // When extra hour are not there
System.out.println(wage);

------------Employee.java------------

public class Employee{
  public int baseSalary;
  public int hourlyRate;

  // Constructor
  public Employee(int baseSalary, int hourlyRate) {
    this.baseSalary = baseSalary;
    this.hourlyRate = hourlyRate;
  }


  public int calculateWage(int extraHours){
    return baseSalary + (hourlyRate*extraHours);
  }

  // Method Overloading
  public int calculateWage(){
    return baseSalary + (hourlyRate);
  }

}
```

## 9. Constructor Overloading

Same as Method Overloading

```
------------Main.java------------

// Employee employee = new Employee(50000, 20);
Employee employee = new Employee(50000);

// int wage = employee.calculateWage(20);
int wage = employee.calculateWage();
System.out.println(wage);

------------Employee.java------------

public class Employee{
  public int baseSalary;
  public int hourlyRate;

  // Constructor
  public Employee(int baseSalary, int hourlyRate) {
    this.baseSalary = baseSalary;
    this.hourlyRate = hourlyRate;
  }

  // Constructor Overloading
  public Employee(int baseSalary) {
    this.baseSalary = baseSalary;
  }
         -----OR-----
  public Employee(int baseSalary) {
    this(baseSalary, 0);
  }

}
```

## 10. Static Variables

Static variables defined as a class member can be accessed without object of that class. Static variable is initialized once and shared among different objects of the class. All the object of the class having static variable will have the same instance of static variable.

```
------------Main.java------------

Employee employee = new Employee(50000, 20);
System.out.println(Employee.numberOfEmployee);
int wage = employee.calculateWage(20);
System.out.println(wage);

------------Employee.java------------

public class Employee{
  public int baseSalary;
  public int hourlyRate;

  public static int numberOfEmployee; // static Variables

  // Constructor
  public Employee(int baseSalary, int hourlyRate) {
    this.baseSalary = baseSalary;
    this.hourlyRate = hourlyRate;
    numberOfEmployee++;
  }

}
```

Like, public int hourlyRate; public int baseSalary; are instance variable, they have instance of the class.
