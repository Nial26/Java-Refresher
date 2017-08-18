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