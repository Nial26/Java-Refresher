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

* Access specifiers are the primary way through which one of the core tenets of OOP *Encapsulation and Information Hiding*, the standard technique is to make all variables private and provide getter and setter methods to access them.