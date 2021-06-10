## 1. Interfaces
<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/18.png" />

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/19.png" />

Like, using abstraction and by applying private keyboard we can reduce the coupling between A & B, but thats not enough. So, using Interfaces we can completely de-couple the relationship between A & B.

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/20.png" />

An interface is a type similar to a class but it only includes method declaration, it has no code, it only defines the capabilities a class should have. (Restaurant cheif(John) example).

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/21.png" />

If we change B it will also affect the changes in A. So, to minimize the effect of changes we put an interface between these two classes. Now if we make any changes in B, A will not be affected, as long as both of the class(A & B) follows our Interface.


## • Tightly coupled code

```
------------TaxCalculator.java------------

public class TaxCalculator {
  private double taxableIncome;
  
  public TaxCalculator(double taxableIncome){  ---(1)
    this.taxableIncome = taxableIncome;
  }
  
  public double calculateTax() {
    return taxableIncome * 0.3;  ---(2)
  }
}

------------TaxReport.java------------

public class TaxReport {
  private TaxCalculator calculator;
  
  public TaxReport() {
    calculator = new TaxCalculator(100_000);
  }
  
  public void show() {
    var tax = calculator.calculateTax();
    System.out.println(tax);
  }
}
```
Now, if we add one more paramater in (1) we need to make changes in our TextReport class, or if we change 0.3 to 0.5 in (2) we need to recompile both the classes again. So, here interfaces comes to rescue.

## • Creating Interface

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/23.png" />

```
------------TaxCalculator2018.java------------

public class TaxCalculator2018 implements TaxCalculator{ // implementing interface
  private double taxableIncome;
  
  public TaxCalculator2018(double taxableIncome){  ---(1)
    this.taxableIncome = taxableIncome;
  }
  
  @Override
  public double calculateTax() {  ---(3)
    return taxableIncome * 0.3;  ---(2)
  }
}

------------TaxReport.java------------

public class TaxReport {
  private TaxCalculator calculator;
  
  public TaxReport() {
    calculator = new TaxCalculator(100_000);
  }
  
  public void show() {
    var tax = calculator.calculateTax();
    System.out.println(tax);
  }
}

             // Interface //
             
------------TaxCalculator.java------------ 

public class TaxCalculator{
  double calculateTax();
}
```

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/24.png" />

Here, public keyword is greyed out, cause it's not needed. Because every method that is declared in interface should be declared by the class and the class should me public cause it should be accessable everywhere.

Now, at (3) the medthod we are using has the exact name that we defined in the interface, so as a good practice, we should Override it. If we remove the method in interface it will show the error in our Override method saying we are implementing an interface method but this method actually doesnot exists in interface, this is the benifit of using "Override" anotation.

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/25.png" />

