## 1. Inheritance
("Is a" relationship)<br/>
Inheritance provides mechanism that allowes a class to inherit property of another class. When a Class extends another class it inherits all non-private members including fields and methods. Inheritance in Java can be best understood in terms of Parent and Child relationship, also known as Super class(Parent) and Sub class(child).

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

## 2. Constructor & Inheritance


```

------------Main.java------------

var control = new TextBox();

------------UIControl.java------------

public abstract class UIControl {
  private boolean isEnabled = true;
  
  // ------- //
  public UIControl() {
    System.out.println("UIControl");
  }
  
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
  
   // ------- //
   public TextBox() {
     System.out.println("TextBox");
   }

  public void setText(String text) {
    this.text = text;
  }

  public void clear() {
    text = "";
  }
}

```

Output:- <br/>
UIControl<br/>
TextBox


<h3>Call the constructor of the base class</h3>

```

------------Main.java------------

var control = new TextBox();

------------UIControl.java------------

public abstract class UIControl {
  private boolean isEnabled = true;
  
  // ------- //
  public UIControl(boolean isEnabled) {
    this.isEnabled = isEnabled;
    System.out.println("UIControl");
  }
  
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
  
   // ------- //
   public TextBox() {
     super(true); // calling the constructor of base class
     System.out.println("TextBox");
   }

  public void setText(String text) {
    this.text = text;
  }

  public void clear() {
    text = "";
  }
}

```

## 3. Access Modifiers

Public - Accessable everywhere (even outside of the class).

Private - Accessable only inside the class. Private members are not inherited by subclasses, (TextBox extends UIControl, so you can't access private members of UIControl in TextBox).

Protected - Accessable everywhere in the same package.

## 4. Method Overriding

For example:- Overriding the methods of Object class
```
@Override
public String toString(){
  return text;
}
```

## 5. Upcasting and Downcasting

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/11.png" />

```
------------Main.java------------

public static void main(String[] args) {
  var control = new UIControl(true);
  var textBox = new TextBox();
  show(textBox); --(1)
}

public static void show(UIControl control){  --(2)
  System.out.println(control);
}
```

Upcasting - We have passed textBox object at (1) but it will automatically get casted to UIControl (Object is casted to it's parent) 

Output = "", because textBox is casted to UIControl in (2) but during runtime toString() method of TextBox gets executed.

You will not be able to access the method of TextBox in the method after (2)

To access the methods of TextBox after (2) prefix it with (TextBox),
```
------------Main.java------------

public static void show(UIControl control){
  var textBox = (TextBox)control;
  textBox.setText("Hello World");
  System.out.println(control);
}
```

Output: "Hello World"

So this was Downcasting

Now, after all this, if e pass control object {show(control)} at (1) our program will crash during runtime, because every TextBox is a control object but not every control object is a TextBox.

So, to prevent this

```
------------Main.java------------

public static void show(UIControl control){
  if(control instanceof TextBox){
    var textBox = (TextBox)control;
    textBox.setText("Hello World");
  }
  System.out.println(control);
}
```


## 6. Comparing Objects

```
------------Main.java------------

var point1 = new Point(1, 2);
var point2 = new Point(1, 2);
System.out.println(point1.equals(point2));

------------Point.java------------

public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

```

Output = false <br/>
Cause here we are checking the equality for reference of both Point objects. To overcome this we will Override equals method in our Point class.

```
------------Main.java------------

var point1 = new Point(1, 2);
var point2 = new Point(1, 2);
System.out.println(point1.equals(point2));

------------Point.java------------

public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
    @Override
  public boolean equals(Object obj) {
    var other = (Point)obj;
    return other.x == x && other.y == y;
  }
}

```
Output = true <br/>

Now if we pass any other Object instead of Point it will throw an exception. So always check instanceof before comparing. Also, always Override hashCode() method when Overriding equals() method.

```
------------Main.java------------

var point1 = new Point(1, 2);
var point2 = new Point(1, 2);
System.out.println(point1.equals(point2));

------------Point.java------------

public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (!(obj instanceof Point))
      return false;

    var other = (Point) obj;
    return other.x == x && other.y == y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}

```

## 7. Polymorphism

<img src="https://github.com/neelbavarva/Java/blob/main/Z_Images/OOPs/12.png" />

```
------------Main.java------------
UIControl[] controls = { new TextBox(), new CheckBox() };

for(var control : controls){
//  if control is TextBox
//    renderTextBox
//  else if it is a CheckBox
//    renderCheckBox
}

```
We will end up have many if-else statements.

So, applying Polymorphism concept (render method is having many forms)

```
------------Main.java------------

UIControl[] controls = { new TextBox(), new CheckBox() };

for(var control : controls){
  control.render();
}

------------UIControl.java------------

public void render() {

}

------------TextBox.java------------

@Override
public void render() {
  System.out.println("Render TextBox");
}

------------CheckBox.java------------

@Override
public void render() {
  System.out.println("Render CheckBox");
}
```
