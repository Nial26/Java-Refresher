# Chapter 1
----------------------

### The Basics

The good old, hello world...

    public class Hello{
        public static void main(String[] args){
            System.out.println("Hello World");
        }
    }

* The File has to be saved with the same name as the only public class in that file.
* Compiling : `javac Hello.java`
* After compiling the java compiler produces an intermediate byte code representation and stores it in a `Hello.class` file, this is where java shines in that you can take this file and run it any Computer which has a java virtual machine (JVM) of the version for which this was compiled for. This JVM is an interpreter (It also has some weird optimizations like Just in time compilation...) which interprets the byte code and essentially executes the code.
* Running : `java Hello`

### Naming Convention

* Class names should be in PascalCase and should be noun. *Example*: `String` 
* Method should be in strict camelCase and should be verb, *Example*: `getCount()`
* Variable names should be in strict camelCase, *Example*: `count`
* Constants should be in SCREAMING_SNAKES case *Example*: `MAX_VAL`
* Package names are in lower case letters *Example*: `java`

### Basic Data Types

##### __Primitives__
* `byte` : 8-bit signed Integer
* `short`: 16-bit signed Integer
* `int`: 32-bit signed Integer
* `long` : 64-bit signed Integer

* `float` : 32-bit single precision floating point
* `double`: 64-bit single precision floating point

* `char`: Character (16-bit Unicode), can also be treated as unsigned int in arithmetic operations

* `bool`: boolean, either `true` or `false`

##### __Others__
* `String` 

### Variables

General format `<data type> <variable name>;` or `<data type> <variable name> = <value>;` 
There is also the `final` keyword in java to make a variable immutable. 

*Examples*:  

*  `int number;`
* `int value = 10;`
* `final double PI=3.14159`

##### _Some things about `final`_

* `final` primitives cannot be modified
* `final` instances cannot be reassigned to a new object
* `final` classes cannot be extended ( Inherited )
* `final` methods cannot be overridden


### Standard Programming Constructs

Java follows pretty much the common syntax for almost all of the standard programming constructs and offers the same standard operators for arithmetic and relational operations.

##### __Flow Control__

    import java.util.Scanner;
    
    public class FizzBuzz{
      public static void main(String[] args){
        int n;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the value of N: ");
        n = in.nextInt();
        
        for (int i = 0; i < n; i++){
          if (i % 15 == 0){
            System.out.println("FizzBuzz");
          }
          else if (i % 3 == 0){
            System.out.println("Fizz");
          }
          else if (i % 5 == 0){
            System.out.println("Buzz");
          }
          else{
            System.out.println(i);
          }
        }
      }
    }

##### __Looping__

*With for loops:*

    import java.util.Scanner;
    
    public class HarmonicSeriesSum{
      public static void main(String[] args){
        int n;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        n = in.nextInt();
        
        double sum = 0;
        
        for (int i = 1; i <= n; i++){
          sum += 1.0/i;
        }
        
        System.out.println("Sum of Harmonic series upto "+ n + " terms = " + sum);
        
      }
    }

*With while loops:*

    import java.util.Scanner;
    
    class GeometricSeries{
      public static void main(String[] args){
        int a, n;
        double r;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the starting number of the Geometric Series: ");
        a = in.nextInt();
        System.out.print("Enter the constand ratio of the series: ");
        r = in.nextFloat();
        System.out.print("Enter the number of terms of the series to generate: ");
        n = in.nextInt();
        
        int count = 1;
        while (count != n + 1){
          double term = a * Math.pow(r, count - 1);
          System.out.println(count + " : " + term);
          count++;
        }
        
      }
    }

##### __Arrays__

    import java.util.Scanner;
    import java.io.Console;
    
    public class Scores{
      
      static int getSum(int[] scores){
        int sum = 0;
        for(int i = 0; i < scores.length; i++){
          sum += scores[i];
        }
        return sum;
      }
      
      static float getAverage(int[] scores){
        int sum = 0;
        for (int score: scores){
          sum += score;
        }
        return (float)sum/scores.length;
      }
      
      public static void main(String[] args){
        int n;
        int[] scores;
        Console con = System.console();
        
        n = Integer.parseInt(con.readLine("Enter the number of scores to enter: "));
        
        Scanner in = new Scanner(con.reader());
        
        scores = new int[n];
        
        System.out.println("Enter the Scores: ");
        
        for (int i = 0; i < n; i++){
          scores[i] = in.nextInt();
        }
        
        System.out.println("The sum of the scores is : " + getSum(scores));
        System.out.println("Ther average of the scores is : " + getAverage(scores));
      }
    }

##### __Recursive Functions__

    import java.util.Scanner;
    
    public class Factorial{
    
      static int factorial(int n){
    	  if (n == 0 || n == 1){
    		  return 1;
    	  }
    	  else{
    		  return n * factorial(n-1);
    	  }
      }
    
      public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = in.nextInt();
        System.out.println("Factorial of " + n + " is: " + factorial(n));
        in.close();
      }
    }

##### __Some notes on Function parameters__

In Java whenever an argument of the primitive is passed on to a method, a copy of that primitive is passed into the method. (Pass by value)

For objects java copies and passes the reference of the object by value, not the object itself.

Java also supports varargs, which can be manipulated using the standard array manipulation methods.

    public class Varargs{
      static int varArgFunc(int i, int... args){
        int sum = i;
        for (int val : args){
          sum += val;
        }
        return sum;
      }
      
      public static void main(String[] args){
        System.out.println(varArgFunc(1, 2, 3, 4));
      }
    }


##### __Other Miscellaneous things__

* Java supports labeled breaks and continues.
* Java has the `System.out.printf()` which can be used for formatted printing.
* The constructor for the scanner can take in a `file` object as an argument and it behaves symmetrically on files and keyboard inputs.
* Varargs if present should be the last argument to the method
