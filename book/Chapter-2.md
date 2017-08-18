# Chapter 2

-----------------------

[TOC]

### Object Oriented Programming

* Java is one of the best languages to learn OOP, literally everything in Java is an object (Except the primitives, they didn't want to make the primitives as objects to improve space performance, you see IIRC objects are created and it requires memory allocation and de-allocation on the heap, and that requires keeping track of a lot of states, so they were like meh.. ) 

* Classes have member variables called attributes and functions that act on these attributes called as methods.

##### __An Example Illustrating several features provided by Java for OOP__

    class Person{ 
      private String name;
      private int age;
      
      /*Constructor, the name of the constructor should be the same as that of the class and 
       it should be declared public and they also don't have a return type
      Constructors can only be invoked by the new operator and thus can only be used once */
      public Person(String name, int age){ 
        this.name = name; //the keyword this is used to refer to this instance of the class definition, it is generally used for resolving ambiguity
        this.age = age;
      }
      
      //Like any other method the constructor can also be overloaded
      public Person(){
    	
      }
      
      public void setName(String a){
    	  name = a;  
      }
      
      public void setAge(int a){
    	  age = a;
      }
      
      public String getName(){
        return name;
      }
      
      public int getAge(){
        return age;
      }
      
    }
    
    public class PersonDriver{
      public static void main(String[] args){
      
        Person p;  //Declaring an instance of the class
        p = new Person("Aditya", 21); // Constructing the instance (also called as instantiation)
    	
        System.out.println("Hello " + p.getName()); //The standard dot operator is used for accessing public methods and variables
    	
    	Person q = new Person();
    	q.setName("Alpha");
    	
    	System.out.println("Hello " + q.getName());
        
        /* Errors 
        System.out.println(p.age); //Trying to access private attributes
    	p.Person(); //Trying to explicitly invoke the constructor */
    
      }
    }
 
 <br/>
*Some Notes*

* The Default visibility for methods and attributes is knows as package private, which means that the fields are accessible from inside the same package to which the class belongs.

### Encapsulation and Abstraction

* Encapsulation is the idea of binding together attributes and it's related methods into a single class and hiding all the implementation details while only providing controlled interfaces with which to interact and change the state of the object (Abstraction).
* Access specifiers are the primary way through which this is provided, the standard technique is to make all variables private and provide getter and setter methods to access them but more generally hide everything except what is necessary.

### Composition

* Composition is when you create a class by using other classes.
 *Example:* A Book class can be composed by using the Author Class
 
### Inheritance 
 
* In Inheritance you inherit all the public fields of the base class, and usually specific features are added in the Derived class.
* A common paradigm is to define a Base class for a group of objects (For Example, define a Base Class for Vehicle), usually this base class will have the attributes and methods that are common to the group of objects.
After that a number of classes are derived from the base class and specific features pertaining to that class are added or modified. (Example, A Bike class which extends the Vehicle Class might add attributes specific to bikes, not found in Vehicles in common)

* Classes in Java are Inherited by the `extends` keyword.

*Example:*

		class A{
		  private int i;
		  public int j;
		  
		  public A(){
		    i = 10;
		    j = 100;
		    System.out.println("Class A : Constructor");
		  }
		  
		  private void x(){
		    System.out.println("Class A : x method");
		  }
		  
		  public void y(){
		    System.out.println("Class A: y method");
		  }
		  
		}
		
		class B extends A{
		  
		  public B(){
			super(); //call the super class constructor, Implicit if the base class only has a default constructor
		    System.out.println("Class B : Constructor");
		  }
		  
		  public void runStuff(){
			super.y(); //Calls the super class version of the y method, instead of the one overridden here
		    y(); //calls the version overridden here
			System.out.println(j);
		    // super.x(); // Error x has private access in A
		    // System.out.println(i); //Error i has Private access in A
		  }
		  
		  @Override
		  public void  y(){
			  System.out.println("Class B : y method");
		  }
		  
		}
		
		public class TestOOP{
		  public static void main(String[] args){
		    B b = new B();
		    b.runStuff();
		  }
		}

*Output:*

    Class A : Constructor
    Class B : Constructor
    Class A: y method
    Class B : y method
    
  *Some Notes*

* `@Override` is annotation, which asks the compiler to check whether the method that follows it (which you intend to override), is actually present in the base class. So if you misspelled a method name (Assuming you were overriding that method) then you will get a error, saying there is no corresponding method in the base class.
It is optional.
* public methods and attributes hidden the derived class by overriding can be accessed by using the keyword `super`
* Explicit `super` invocations for the base class has to be done, if the base class has either defined multiple constructors.
* You cannot extend more than one class in Java (i.e, Java doesn't support multiple inheritance), thus avoiding the diamond inheritance problem
* You cannot disable inherited methods in the derived class. (Pretty important for Substitutability)
* All classes in Java are derived from the base class `java.lang.object` and thus have certain methods which they all inherit, one of them is the `toString` method, which is called whenever the object is sent as a parameter to one of the print functions, a class can override this method and provide its own implementation.
* overridden methods generally have the same return type as the original method, but it [can also have a return type that is assignable to the return type of the method you are overriding](https://stackoverflow.com/questions/14694852/can-overridden-methods-differ-in-return-type).

#### Composition Vs. Inheritance

Consider Composition before Inheritance, the general way to think about this is through *has a* and *is a* paradigm, i.e, A Bike *is a* Vehicle (So it inherits the attributes of a Vehicle), but a house *has a* room (So there is no point in having the room extend Room, use abstract classes or interfaces if you want to have a common base and build on top of it)  

### Polymorphism

* Substitutability is the idea that a derived class can substitute for a base class.
i.e, if B derives from A , `A <- B` then we can have `A a  = new B()`, this is because objects of the B class will still have all the methods of class A (maybe overridden to give different implementation). 
In the above example, we can use the object `a` to invoke any methods that were defined in `A` and they will run the method with the instructions as defined in `B`, but the object cannot be used to invoke any method defined in `B`

*Example:*

    class A{
      public void x(){
        System.out.println("Class A : method x");
      }
    }
    
    class B extends A {
      public B(int a){
        System.out.println("Class B: a = " + a);
      }
      
      public void x(){
        System.out.println("Class B : method x");
      }
      
      public void y(){
        System.out.println("Class B : method y");
      }
    }
    
    public class TestPolymorphism{
      public static void main(String[] args){
        A a = new B(10);
        a.x();
        //a.y(); //Compilation Error, cannot find symbol
    	System.out.println(a instanceof A); //true
    	System.out.println(a instanceof B); //true
    	
    	B b = new B(2);
    	A k = new A();
    	
    	System.out.println(b instanceof A); //true
    	System.out.println(k instanceof B); //false
    	
    	B c = (B) a; //Downcasting
    	c.y();
    	
      }
    }

*Output:*

    Class B: a = 10
    Class B : method x
    true
    true
    Class B: a = 2
    true
    false
    Class B : method y

* The `instanceof` operator can be used to check if an object is an instance of a class
* You need to careful when downcasting, because the compiler cannot figure out errors in explicit cast and thus the executable can throw a Runtime Exception

* Polymorphism is an extremely powerful concept in that it allows to program at an interface level, you can hold reference to a super class object and you can be sure that all the methods in that class can be run, although they may have different implementation based on which is the derived class that is substituted in its place.
This probably doesn't make sense now, but it makes a lot of sense when using abstract classes and interfaces.