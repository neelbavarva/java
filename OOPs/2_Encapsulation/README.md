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
