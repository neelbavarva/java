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
