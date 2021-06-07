## 1. Inheritance

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/10.png" />

```

------------Main.java------------

var control = new TextBox();
control.disable();
control.setText();

------------UIControl.java------------

public abstract class UIControl {
  private boolean isEnabled = true;
  
  public void enable() {
    isEnabled = true;
  }

  public void disable() {
    isEnabled = false;
  }

  public boolean isEnabled() {
    return isEnabled;
  }
}

------------TextBox.java------------

public class TextBox extends UIControl {
  private String text = "";

  public void setText(String text) {
    this.text = text;
  }

  public void clear() {
    text = "";
  }
}

```

## 2. Abstraction 
(Example:- TV Remote)

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/8.png" />

## 3. Coupling

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

## 4. Constructors

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

## 5. Method Overloading
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


## 6. Constructor Overloading
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

## 7. Static Variables
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