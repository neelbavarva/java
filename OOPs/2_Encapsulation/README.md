## 1. Encapsulation

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
