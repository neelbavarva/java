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

