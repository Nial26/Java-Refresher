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
	
	B c = (B) k; //Downcasting
	c.y();
	
  }
}